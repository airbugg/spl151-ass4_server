package reactor_tokenizer_http;

import message.Message;

import java.util.HashMap;
import java.util.Map;

/**
 * HttpMessage abstract class. both HttpResponseMessage & HttpRequestMessage inherit from this class.
 */
public abstract class HttpMessage implements Message {

    protected final String HTTP_VERSION = "HTTP/1.1";
    protected final Map<String, String> _headers;

    public HttpMessage() {
        this._headers = new HashMap<String, String>();
    }

    /**
     * add a new header to HttpMessage
     * @param name of header
     * @param value of header
     */
    public void addMessageHeader(String name, String value) {
        _headers.put(name, value);
    }

    public abstract String toString();
}
