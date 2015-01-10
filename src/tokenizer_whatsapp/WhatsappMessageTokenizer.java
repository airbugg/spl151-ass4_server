package tokenizer_whatsapp;

import tokenizer.MessageTokenizer;

import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;

/**
 * Created by Eugene on 09/01/2015.
 */
public class WhatsappMessageTokenizer implements MessageTokenizer<WhatsappMessage> {
    @Override
    public void addBytes(ByteBuffer bytes) {

    }

    @Override
    public boolean hasMessage() {
        return false;
    }

    @Override
    public WhatsappMessage nextMessage() {
        return null;
    }

    @Override
    public ByteBuffer getBytesForMessage(WhatsappMessage msg) throws CharacterCodingException {
        return null;
    }
}
