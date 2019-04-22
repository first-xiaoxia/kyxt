package com.java.entity.commons;
/**
 * @author 倪军
 * @version 0.1
 * @time 2017/3/16 11:28
 */
public class BaseMessage {
    /*
    编码
     */
    private String messcode;
    /*
    信息
     */
    private String message;

    public String getMesscode() {
        return messcode;
    }

    public void setMesscode(String messcode) {
        this.messcode = messcode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
