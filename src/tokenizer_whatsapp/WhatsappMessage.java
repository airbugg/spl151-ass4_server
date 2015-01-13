package tokenizer_whatsapp;

import tokenizer.Message;
import tokenizer_http.HttpMessage;

/**
 * Created by Eugene on 09/01/2015.
 */
public abstract class WhatsappMessage implements Message {

    private HttpMessage _httpMessage;

    public WhatsappMessage() {
    }

    public abstract String toString();
}
