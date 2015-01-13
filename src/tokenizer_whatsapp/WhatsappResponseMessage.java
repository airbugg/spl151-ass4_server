package tokenizer_whatsapp;

import tokenizer_http.HttpResponseMessage;
import tokenizer_http.HttpStatusCode;

/**
 * WhatsappResponseMessage
 */
public class WhatsappResponseMessage extends WhatsappMessage {

    HttpResponseMessage _httpResponse;
    HttpStatusCode _statusCode;
    String _body;

    public WhatsappResponseMessage(HttpStatusCode statusCode, String body) {
        _httpResponse = null;
        _statusCode = statusCode;
        _body = body;
    }

    @Override
    public String toString() {
        return null;
    }
}
