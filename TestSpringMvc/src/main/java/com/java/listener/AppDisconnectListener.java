package com.java.listener;/**
 * @author 倪军
 * @Date ${Date} 9:02
 */

import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.listener.ConnectListener;
import com.corundumstudio.socketio.listener.DisconnectListener;
import com.java.entity.ChatObject;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 倪军
 * @version 0.1
 * @time 2018/7/24 9:02
 */

public class AppDisconnectListener implements DisconnectListener {

    public void onDisconnect(SocketIOClient client) {
        System.out.println("断开连接"+client.getSessionId());
        SocketIOServer server = App.getServer();
        String userName = client.getHandshakeData().getSingleUrlParam("userName");
        ConnectionMap.removeClient(userName);
        ChatObject object = new ChatObject();
        object.setUserName(String.valueOf(client.getNamespace()));
        object.setMessage("已经断开连接");
        client.sendEvent("chatevent",object);
    }

}
