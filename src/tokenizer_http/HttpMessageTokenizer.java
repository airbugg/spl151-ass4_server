package tokenizer_http;

import tokenizer.MessageTokenizer;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.util.Vector;

/**
 * this class is responsible for parsing byte streams to HttpMessage objects & vice versa.
 */
public class HttpMessageTokenizer implements MessageTokenizer<HttpMessage> {

    private final String _messageSeparator;

    private final String HTTP_VERSION = "HTTP/1.1";

    private final Vector<HttpMessage> _messageBuf = new Vector<HttpMessage>(); // holds complete HTTP messages.
    private final StringBuffer _stringBuf = new StringBuffer(); // holds incomplete message string

    private final CharsetDecoder _decoder;
    private final CharsetEncoder _encoder;

    public HttpMessageTokenizer() {
        _messageSeparator = "$";
        Charset charset = Charset.forName("UTF-8"); // we'll be encoding / decoding our byte stream using UTF-8
        this._decoder = charset.newDecoder();
        this._encoder = charset.newEncoder();
    }

    @Override
    public synchronized void addBytes(ByteBuffer bytes) {
        CharBuffer chars = CharBuffer.allocate(bytes.remaining()); // initialize buffer for chars
        _decoder.decode(bytes, chars, false); // reads bytes, spit out chars

        chars.flip(); // prepare buffer for reading
        _stringBuf.append(chars);
    }

    @Override
    public synchronized boolean hasMessage() {
        return (_stringBuf.indexOf(_messageSeparator) != -1); // a complete message will contain a delimiter
    }

    @Override
    public synchronized HttpMessage nextMessage() {

        String rawMessageString = "";
        HttpMessage httpMessage = null;

        int messageEnd = _stringBuf.indexOf(_messageSeparator);

        if (messageEnd != -1) { // if separator char exists, buffer contains an entire message

            rawMessageString = _stringBuf.substring(0, messageEnd);
            _stringBuf.delete(0, messageEnd + _messageSeparator.length()); // clear retrieved message from buffer

            String line = getFirstLine(rawMessageString);
            String[] splitFirstLine = splitFirstLine(line); // retrieve first line of HTTP message

            if (!isResponseMessage(splitFirstLine)) { // response message?
                String requestURI = splitFirstLine[1];

                if (splitFirstLine[0].equals("GET")) { // GET message?
                    httpMessage = new HttpGetRequest(requestURI);
                }
                if (splitFirstLine[0].equals("POST")) { // POST, then..
                    httpMessage = new HttpPostRequest(requestURI);
                }
            }


            // getting headers..
            while (!line.equals("")) {
                int delimiterIndex = line.indexOf(":");

                String name = line.substring(0, delimiterIndex);
                String value = line.substring(delimiterIndex + 1);

                httpMessage.addMessageHeader(name, value);
                line = getFirstLine(rawMessageString);
            }

            // add body
            String body = getFirstLine(rawMessageString);
            if ((httpMessage instanceof HttpPostRequest) && !body.equals("$")) {
                ((HttpPostRequest) httpMessage).addBody(body);
            }
        }

        return httpMessage;
    }

    @Override
    public ByteBuffer getBytesForMessage(HttpMessage msg) throws CharacterCodingException {

        StringBuilder sb = new StringBuilder(msg.toString());
        sb.append(_messageSeparator);
        String returnMsg = sb.toString();

        try {
            return ByteBuffer.wrap(returnMsg.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    private boolean isResponseMessage(String[] firstLine) {
        // a response message will always begin with HTTP/1.1
        return firstLine[0].equals(HTTP_VERSION);
    }

    private String getFirstLine(String message) {
        int lineBreak = message.indexOf("\r\n|\r|\n");

        String firstLine = message.substring(0, lineBreak);
        message = message.substring(lineBreak);

        return  firstLine;
    }

    private String[] splitFirstLine(String line) {
        return line.split(" ");
    }

}
