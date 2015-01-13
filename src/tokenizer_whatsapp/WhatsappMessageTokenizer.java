package tokenizer_whatsapp;

import protocol_http.HttpServerProtocol;
import tokenizer.Message;
import tokenizer.MessageTokenizer;
import tokenizer_http.HttpMessage;
import tokenizer_http.HttpMessageTokenizer;
import tokenizer_http.HttpRequestMessage;
import tokenizer_http.HttpResponseMessage;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.util.Map;

/**
 * WhatsappMessageTokenizer
 */
public class WhatsappMessageTokenizer implements MessageTokenizer<WhatsappMessage> {

    HttpServerProtocol _httpProtocol;
    HttpMessageTokenizer _httpTokenizer;

    public WhatsappMessageTokenizer() {
        this._httpProtocol = new HttpServerProtocol();
        this._httpTokenizer = new HttpMessageTokenizer();
    }

    @Override
    public void addBytes(ByteBuffer bytes) {
        _httpTokenizer.addBytes(bytes);
    }

    @Override
    public boolean hasMessage() {
        return false;
    }

    @Override
    public WhatsappMessage nextMessage() {

        WhatsappMessage msg = null;

        HttpMessage httpMessage = _httpTokenizer.nextMessage();
        HttpMessage httpResponseMessage = _httpProtocol.processMessage(httpMessage);

        if (httpResponseMessage instanceof HttpResponseMessage) {
            msg = new WhatsappResponseMessage((HttpResponseMessage) httpResponseMessage);

        }
        else if (httpResponseMessage instanceof HttpRequestMessage) {
            msg = new WhatsappRequestMessage(((HttpRequestMessage) httpResponseMessage).getHttpRequestURI(),
                    httpResponseMessage.getMessageBody());

        }



        return msg;
    }

    @Override
    public ByteBuffer getBytesForMessage(WhatsappMessage msg) throws CharacterCodingException {
        try {
            return ByteBuffer.wrap(msg.toString().getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
