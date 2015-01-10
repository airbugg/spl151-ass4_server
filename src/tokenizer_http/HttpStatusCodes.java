package tokenizer_http;

/**
 * Created by Eugene on 10/01/2015.
 */
public enum HttpStatusCodes {
    S200 (200, "OK"),
    S403 (403, "Forbidden"),
    S404 (404, "Not Found"),
    S405 (405, "Method Not Allowed"),
    S418 (418, "I'm a teapot");

    private final int _code;
    private final String _status;

    private HttpStatusCodes(int code, String status) {
        this._code = code;
        this._status = status;
    }

}
