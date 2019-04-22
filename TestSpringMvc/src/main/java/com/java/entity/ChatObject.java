package com.java.entity;/**
 * @author 倪军
 * @Date ${Date} 17:31
 */

/**
 * @author 倪军
 * @version 0.1
 * @time 2018/7/23 17:31
 */
public class ChatObject {
    private String userName;
    private String receiver;
    private String message;
    private String type;

    public ChatObject() {
    }

    public ChatObject(String userName, String message) {
        super();
        this.userName = userName;
        this.message = message;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
