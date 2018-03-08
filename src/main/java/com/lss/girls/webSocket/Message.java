package com.lss.girls.webSocket;

/**
 * @author Magic
 * @date 11:06 2018/3/7
 * @description
 */
public class Message {

    private String from;

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private String to;

    private String message;
}
