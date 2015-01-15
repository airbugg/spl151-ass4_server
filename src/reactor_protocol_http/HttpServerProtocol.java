package reactor_protocol_http;

import message.*;
import reactor_protocol.*;

/**
 * Created by airbag on 1/12/15.
 */
public class HttpServerProtocol implements AsyncServerProtocol<HttpMessage> {


    @Override
    public HttpMessage processMessage(HttpMessage msg) {

        HttpMessage responseMessage = null;

        if ((msg instanceof HttpRequestMessage) &&
                AvailableURIs.getURI(
                        ((HttpRequestMessage) msg).getHttpRequestURI()) != AvailableURIs.NA) {

        }
        else {
            responseMessage = new HttpResponseMessage(HttpStatusCode.S404);

        }

        return responseMessage;
    }

    @Override
    public boolean isEnd(HttpMessage msg) {
        return false;
    }

    @Override
    public boolean shouldClose() {
        return false;
    }

    @Override
    public void connectionTerminated() {

    }
}
