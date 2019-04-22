package com.java.listener;/**
 * @author 倪军
 * @Date ${Date} 9:08
 */

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @author 倪军
 * @version 0.1
 * @time 2018/7/25 9:08
 */
public class AppStartListener implements HttpSessionListener {
    static {
        new Thread(new Runnable() {
            public void run() {
                try {
                   App.appStart();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        System.out.println("app start");
    }
    public void sessionCreated(HttpSessionEvent se) {

    }

    public void sessionDestroyed(HttpSessionEvent se) {

    }
}
