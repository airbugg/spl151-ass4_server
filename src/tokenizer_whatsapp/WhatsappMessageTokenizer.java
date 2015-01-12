package tokenizer_whatsapp;

import tokenizer.MessageTokenizer;

import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;

/**
 * Created by Eugene on 09/01/2015.
 */
public class WhatsappMessageTokenizer implements MessageTokenizer<WhatsappOverHttpMessage> {
    @Override
    public void addBytes(ByteBuffer bytes) {

    }

    @Override
    public boolean hasMessage() {
        return false;
    }

    @Override
    public WhatsappOverHttpMessage nextMessage() {
        return null;
    }

    @Override
    public ByteBuffer getBytesForMessage(WhatsappOverHttpMessage msg) throws CharacterCodingException {
        return null;
    }
}
