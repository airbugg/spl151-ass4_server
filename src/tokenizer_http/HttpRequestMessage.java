package tokenizer_http;

/**
 * this class represents an HTTP request object. Inherits from HttpMessage.
 */
public class HttpRequestMessage extends HttpMessage {

    private final HttpRequestType _httpRequestType;
    private final String _httpRequestUri;

    public HttpRequestMessage(HttpRequestType httpRequestType, String httpRequestUri) {
        _httpRequestType = httpRequestType;
        _httpRequestUri = httpRequestUri;
    }
}
