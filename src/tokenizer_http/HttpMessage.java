package tokenizer_http;

import tokenizer.Message;

import java.util.HashMap;
import java.util.Map;

/**
 * HttpMessage abstract class. both HttpResponseMessage & HttpRequestMessage inherit from this class.
 */
public abstract class HttpMessage implements Message<HttpMessage> {

    private final Map<String, String> _headers;
    private String _body; // object?

    public HttpMessage() {
        this._headers = new HashMap<String, String>();
        this._body = null;
    }

    /**
     * add a new header to HttpMessage
     * @param name of header
     * @param value of header
     */
    public void addHeader(String name, String value) {
        _headers.put(name, value);
    }

    /**
     * adds body to HttpMessage.
     * @param body
     */
    public void addBody(String body) {
        _body = body;
    }
}
