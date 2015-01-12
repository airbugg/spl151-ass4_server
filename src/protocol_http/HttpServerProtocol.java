package protocol_http;

import protocol.AsyncServerProtocol;
import tokenizer_http.HttpMessage;
import tokenizer_http.HttpRequestMessage;
import tokenizer_http.HttpResponseMessage;
import tokenizer_http.HttpStatusCode;

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
