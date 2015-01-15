package reactor_tokenizer_whatsapp;

import reactor_tokenizer_http.HttpGetRequest;
import reactor_tokenizer_http.HttpPostRequest;

import java.util.Map;

/**
 * WhatsappRequestMessage
 */
public class WhatsappRequestMessage extends WhatsappMessage {

    private String _requestType;
    String _requestedURI;
    Map<String, String> _actionParameters;

    public WhatsappRequestMessage(HttpGetRequest getRequest) { // constructor for HttpGetRequests
        _requestType = "GET";
        _actionParameters = null;
        _requestedURI = getRequest.getURI();
    }
    public WhatsappRequestMessage(HttpPostRequest postRequest) { // constructor for HttpPostRequests
        _requestType = "POST";
        _actionParameters = postRequest.getPostBody();
        _requestedURI = postRequest.getURI();
    }

    public String getRequestURI() { // returns request URI
        return _requestedURI;
    }

    public Map<String, String> getURIParameters() { // returns POST body inside map
        return _actionParameters;
    }


    @Override
    public String toString() {
        return null;
    }
}
