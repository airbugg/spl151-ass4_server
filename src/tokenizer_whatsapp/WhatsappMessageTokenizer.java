package tokenizer_whatsapp;

import protocol_http.HttpServerProtocol;
import tokenizer.MessageTokenizer;
import tokenizer_http.*;

import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;

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

        // let us parse the underlying HTTP message.
        HttpMessage httpMessage = _httpTokenizer.nextMessage();
        HttpMessage httpResponseMessage = _httpProtocol.processMessage(httpMessage);

        // if the HTTP protocol return a response, we'll convert it to a WhatsappResponse message
        if (httpResponseMessage instanceof HttpResponseMessage) {
            msg = new WhatsappResponseMessage((HttpResponseMessage) httpResponseMessage);

        } else {

            if (httpResponseMessage instanceof HttpPostRequest) {
                msg = new WhatsappRequestMessage((HttpPostRequest) httpResponseMessage);

            }

            if (httpResponseMessage instanceof HttpGetRequest) {
                msg = new WhatsappRequestMessage((HttpGetRequest) httpResponseMessage);

            }
        }

        return msg;
    }

    @Override
    public ByteBuffer getBytesForMessage(WhatsappMessage msg) throws CharacterCodingException {



    }
}
