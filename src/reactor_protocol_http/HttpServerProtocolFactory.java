package reactor_protocol_http;

import reactor_protocol.AsyncServerProtocol;
import reactor_protocol.ServerProtocolFactory;
import reactor_tokenizer_http.HttpMessage;

/**
 * Created by airbag on 1/8/15.
 */
public class HttpServerProtocolFactory implements ServerProtocolFactory<HttpMessage> {
    @Override
    public AsyncServerProtocol<HttpMessage> create() {
        return new HttpServerProtocol();
    }
}
