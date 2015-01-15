package message;

import message.Message;

/**
 * Created by Eugene on 09/01/2015.
 */
public abstract class WhatsappMessage implements Message {


    public WhatsappMessage() {
    }

    public abstract String toString();
}
