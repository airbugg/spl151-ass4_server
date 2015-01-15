package tokenizer_whatsapp;

import tokenizer_http.HttpResponseMessage;
import tokenizer_http.HttpStatusCode;

/**
 * WhatsappResponseMessage
 */
public class WhatsappResponseMessage extends WhatsappMessage {

    HttpStatusCode _statusCode;
    String _reply;
    String _cookie;

    public WhatsappResponseMessage(HttpStatusCode statusCode) {
        _statusCode = statusCode;
        _reply = null;
    }

    public void addReply(String reply) { // adds URI response to message body
        _reply = reply;
    }

    public void addCookie(String cookie) { // adds Cookie, if necessary
        _cookie = cookie;
    }

    public boolean isEnd() {
        return true; // TODO: Complete.
    }

    @Override
    public String toString() { // encapsulates message in HTTP frame, converts to string.

        HttpResponseMessage msg = new HttpResponseMessage(_statusCode, _reply);
        msg.addMessageHeader("Set-Cookie", _cookie);

        return msg.toString();
    }
}
