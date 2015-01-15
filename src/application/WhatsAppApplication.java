package application;

import tokenizer_whatsapp.WhatsappRequestMessage;
import tokenizer_whatsapp.WhatsappResponseMessage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by gal on 1/13/2015.
 */
public class WhatsAppApplication {

    private ArrayList<String> _cookiesContainer;
    private Vector<User> _usersContainer;
    private Vector<Group> _groupContainer;
    private AtomicInteger _cookieCounter;
    private Object loginDummy;


    public WhatsAppApplication(){
        _cookiesContainer = new ArrayList<String>();
        _usersContainer = new Vector<User>();
        _groupContainer = new Vector<Group>();
        _cookieCounter = new AtomicInteger(1);
        loginDummy = new Object();
    }


    public boolean checkCookie(String cookie) {
        return _cookiesContainer.contains(cookie);
    }

    public WhatsappResponseMessage executeURI(WhatsappRequestMessage msg) {

        WhatsappResponseMessage response = null;
        String requestURI = msg.getRequestURI();

        if (requestURI.equals("login.jsp")) {
            response.addCookie(getACookie());
            response.addReply(login(msg));

        }
        if (requestURI.equals("logout.jsp")) {
            response.addReply(logout(msg));

        }
        if (requestURI.equals("list.jsp")) {
            response.addReply(list(msg));

        }
        if (requestURI.equals("create_group.jsp")) {
            response.addReply(create_group(msg));

        }
        if (requestURI.equals("send.jsp")) {
            response.addReply(send(msg));

        }
        if (requestURI.equals("add_user.jsp")) {
            response.addReply(add_user(msg));

        }
        if (requestURI.equals("remove_user.jsp")) {
            response.addReply(remove_user(msg));

        }
        if (requestURI.equals("queue.jsp")) {
            response.addReply(queue(msg));

        }

        return response;
    }

    private String queue(WhatsappRequestMessage msg) {
        return null;
    }

    private String remove_user(WhatsappRequestMessage msg) {
        return null;
    }

    private String add_user(WhatsappRequestMessage msg) {
        return null;
    }

    private String send(WhatsappRequestMessage msg) {
        return null;
    }

    private String list(WhatsappRequestMessage msg) {
        return null;
    }

    private String create_group(WhatsappRequestMessage msg) {
        return null;
    }

    private String logout(WhatsappRequestMessage msg) {
        return null;
    }

    private String login(WhatsappRequestMessage msg) {
            StringBuilder responseMessege = new StringBuilder();
            HashMap<String,String> messageBody = new HashMap<String,String>(msg.getURIParameters());
            _usersContainer.add(new User(messageBody.get("UserName"),messageBody.get("Phone")));
        responseMessege.append("Welcome ");
        responseMessege.append(messageBody.get("UserName"));
        responseMessege.append("@");
        responseMessege.append(messageBody.get("Phone"));

        return new String(responseMessege);
    }

    private String getACookie(){
        String Cookie;
        // synchronize so we won't give the same cookie twice (and someone will be left hungry...)
        synchronized (loginDummy) {
            Cookie = new String("Cookie" + _cookieCounter.get());
            _cookiesContainer.add(Cookie);
            _cookieCounter.incrementAndGet();
        }
        return Cookie;
    }

}
