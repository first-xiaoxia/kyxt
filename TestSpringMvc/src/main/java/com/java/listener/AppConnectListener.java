package com.java.listener;/**
 * @author 倪军
 * @Date ${Date} 9:02
 */

import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.listener.ConnectListener;
import com.java.entity.ChatObject;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 倪军
 * @version 0.1
 * @time 2018/7/24 9:02
 */

public class AppConnectListener implements ConnectListener {

    public void onConnect(SocketIOClient client) {
        System.out.println("连接"+client.getSessionId());
        String clientId = client.getHandshakeData().getSingleUrlParam("userName");
        ConnectionMap.addClient(clientId,client);
        client = ConnectionMap.getClient(clientId);
        ChatObject object = new ChatObject();
        object.setUserName(String.valueOf(clientId));
        Collection<SocketIOClient> collection = App.getServer().getAllClients();
        object.setMessage("已经连接");
        client.sendEvent("chatevent",object);
    }

}
