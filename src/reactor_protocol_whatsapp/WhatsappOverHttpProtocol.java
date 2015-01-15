package reactor_protocol_whatsapp;

/**
 * WhatsappOverHttpProtocol
 */
public class WhatsappOverHttpProtocol implements AsyncServerProtocol<WhatsappMessage> {


    @Override
    public WhatsappMessage processMessage(WhatsappMessage msg) {

        WhatsappResponseMessage response = null;

        if (msg instanceof WhatsappRequestMessage) {

            if (((WhatsappRequestMessage) msg).getRequestType() == HttpRequestType.GET) {

                if (((WhatsappRequestMessage) msg).getAction().equals("logout.jsp")) {

                }
                if (((WhatsappRequestMessage) msg).getAction().equals("queue.jsp")) {

                }

            } else if (((WhatsappRequestMessage) msg).getRequestType() == HttpRequestType.POST) {

                if (((WhatsappRequestMessage) msg).getAction().equals("login.jsp")) {

                }
                if (((WhatsappRequestMessage) msg).getAction().equals("list.jsp")) {

                }
                if (((WhatsappRequestMessage) msg).getAction().equals("create_group.jsp")) {

                }
                if (((WhatsappRequestMessage) msg).getAction().equals("send.jsp")) {

                }
                if (((WhatsappRequestMessage) msg).getAction().equals("add_user.jsp")) {

                }
                if (((WhatsappRequestMessage) msg).getAction().equals("remove_user.jsp")) {

                }
            }

        }

        return response;
    }

    private boolean check_auth() {
        return false;
    }

    private void login() {

    }

    private void logout() {

    }

    private void create_group() {

    }

    private void list() {

    }

    private void add_user() {

    }

    private void remove_user() {

    }

    private void queue() {

    }


    @Override
    public boolean isEnd(WhatsappMessage msg) {
        return ((msg instanceof WhatsappResponseMessage) &&
                ((WhatsappResponseMessage) msg).isEnd());
    }

    @Override
    public boolean shouldClose() {
        return false;
    }

    @Override
    public void connectionTerminated() {

    }
}
