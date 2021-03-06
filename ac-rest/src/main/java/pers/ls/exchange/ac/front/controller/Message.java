package pers.ls.exchange.ac.front.controller;

public class Message {
    private String data;
    private String sender;
    private MessageType type;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public MessageType getType() {
        return type;
    }

    public void setType(MessageType type) {
        this.type = type;
    }

    public enum MessageType{
        CHAT,LEAVE,JOIN
    }

}
