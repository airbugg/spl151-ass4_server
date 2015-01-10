package tokenizer_http;

/**
 * this class represents an HTTP response. Inherits from HttpMessage.
 */
public class HttpResponseMessage extends HttpMessage {

    private final HttpStatusCodes _httpStatusCodes;

    public HttpResponseMessage(HttpStatusCodes httpStatusCodes) {
        _httpStatusCodes = httpStatusCodes;
    }
}
