package protocol_whatsapp;

import protocol.AsyncServerProtocol;
import tokenizer_whatsapp.WhatsappMessage;

/**
 * Created by Eugene on 09/01/2015.
 */
public class WhatsappAsyncServerProtocol implements AsyncServerProtocol<WhatsappMessage> {
    @Override
    public WhatsappMessage processMessage(WhatsappMessage msg) {
        return null;
    }

    @Override
    public boolean isEnd(WhatsappMessage msg) {
        return false;
    }

    @Override
    public boolean shouldClose() {
        return false;
    }

    @Override
    public void connectionTerminated() {

    }
}
