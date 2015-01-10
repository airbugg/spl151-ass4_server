package protocol_whatsapp;

import protocol.AsyncServerProtocol;
import protocol.ServerProtocol;
import protocol.ServerProtocolFactory;
import tokenizer_whatsapp.WhatsappMessage;

/**
 * Created by airbag on 1/8/15.
 */
public class WhatsappProtocolFactory implements ServerProtocolFactory<WhatsappMessage> {

    @Override
    public AsyncServerProtocol<WhatsappMessage> create() {
        return null;
    }
}
