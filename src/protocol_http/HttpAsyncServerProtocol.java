package protocol_http;

import protocol.AsyncServerProtocol;
import tokenizer_http.HttpMessage;
import tokenizer_http.HttpRequestMessage;

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
        return (msg instanceof HttpRequestMessage) &&
                ((HttpRequestMessage) msg).getHttpRequestURI().equals("logout.jsp");
    }

    @Override
    public boolean shouldClose() {
        return false;
    }

    @Override
    public void connectionTerminated() {

    }
}
