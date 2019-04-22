package com.java.listener;

/**
 * @author 倪军
 * @version 0.1
 * @time 2018/7/23 17:34
 */
import com.corundumstudio.socketio.Configuration;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.listener.ConnectListener;
import com.java.entity.ChatObject;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class App  {
    static  SocketIOServer server;
    public static void main(String[] args) throws InterruptedException
    {
        appStart();
    }

    public static SocketIOServer getServer() {
        return server;
    }

    public static void appStart() throws InterruptedException {
        Configuration config = new Configuration();
        config.setHostname("localhost");
        config.setPort(9092);
        server = new SocketIOServer(config);
        //添加监听类
        AppConnectListener ConnectListener = new AppConnectListener();





        
        server.addConnectListener(ConnectListener);
        AppDisconnectListener disconnectListener = new AppDisconnectListener();
        server.addDisconnectListener(disconnectListener);
        CharteventListener listner = new CharteventListener();
        //listner. setServer(server);
        // chatevent为事件名称
        server.addEventListener("chatevent", ChatObject.class, listner);
        //启动服务
        server.start();
        Thread.sleep(Integer.MAX_VALUE) ;
        server.stop();
    }
}