package reactor_protocol_http;

/**
 * Created by airbag on 1/8/15.
 */
public class HttpServerProtocolFactory implements ServerProtocolFactory<HttpMessage> {
    @Override
    public AsyncServerProtocol<HttpMessage> create() {
        return new HttpServerProtocol();
    }
}
