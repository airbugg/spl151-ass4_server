package tokenizer_whatsapp;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

/**
 * WhatsappRequestMessage
 */
public class WhatsappRequestMessage extends WhatsappMessage {

    String _action;
    Map<String, String> _actionParameters;

    public WhatsappRequestMessage(String action, String parameters) {
        _action = action;
        parseParameters(parameters);
    }

    public String getAction() {
        return _action;
    }

    public String getActionParameters() {
        return null;
    }


    private void parseParameters(String parameters) {

        String[] bodyParts = parameters.split("&");

        for (String b : bodyParts) {
            int delimiterIndex = b.indexOf("=");

            String name = b.substring(0, delimiterIndex);
            String value = b.substring(delimiterIndex + 1);

            try {
                value = URLEncoder.encode(value, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

            _actionParameters.put(name, value);
        }
    }

    @Override
    public String toString() {
        return null;
    }
}
