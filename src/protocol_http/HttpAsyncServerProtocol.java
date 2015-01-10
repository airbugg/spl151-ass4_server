package protocol_http;

import protocol.AsyncServerProtocol;
import tokenizer_http.HttpMessage;

/**
 * Created by Eugene on 09/01/2015.
 */
public class HttpAsyncServerProtocol implements AsyncServerProtocol<HttpMessage> {
    @Override
    public HttpMessage processMessage(HttpMessage msg) {
        return null;
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
