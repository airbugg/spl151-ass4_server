package protocol_whatsapp;

import protocol.AsyncServerProtocol;
import protocol.ServerProtocolFactory;
import tokenizer_whatsapp.WhatsappOverHttpMessage;

/**
 * Created by airbag on 1/8/15.
 */
public class WhatsappProtocolFactory implements ServerProtocolFactory<WhatsappOverHttpMessage> {

    @Override
    public AsyncServerProtocol<WhatsappOverHttpMessage> create() {
        return null;
    }
}
