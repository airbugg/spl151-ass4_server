package message;

import java.util.Map;

/**
 * this class represents an HTTP response. Inherits from HttpMessage.
 */
public class HttpResponseMessage extends HttpMessage {

    private final HttpStatusCode _httpStatusCode;
    private String _body;

    public HttpResponseMessage(HttpStatusCode httpStatusCode, String body) {
        _httpStatusCode = httpStatusCode;
        _body = body;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(HTTP_VERSION);
        sb.append(" ");
        sb.append(_httpStatusCode.getCode());
        sb.append("\n");

        for (Map.Entry<String, String> header: _headers.entrySet()) {
            sb.append(header.getKey());
            sb.append(": ");
            sb.append(header.getValue());
            sb.append("\n");
        }

        sb.append("\n");
        sb.append(_body);
        sb.append("\n");

        return sb.toString();
    }
}
