package protocol_http;

import protocol.AsyncServerProtocol;
import protocol.ServerProtocolFactory;
import tokenizer_http.HttpMessage;

/**
 * Created by airbag on 1/8/15.
 */
public class HttpServerProtocolFactory implements ServerProtocolFactory<HttpMessage> {
    @Override
    public AsyncServerProtocol<HttpMessage> create() {
        return new HttpServerProtocol();
    }
}
