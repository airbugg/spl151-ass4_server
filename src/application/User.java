package application;

import java.util.LinkedList;

/**
 * Created by gal on 1/14/2015.
 */
public class User {

    private String _name;
    private LinkedList<String> _messages;

    public User(String name, String number) {
        _name = name;
        String _phoneNumber = number;
        _messages = new LinkedList<>();
    }

    public String getName(){ return _name; }

    public void addMessage(String message){
        _messages.addLast(message);
    }

    public void getMessages(){

    }
}