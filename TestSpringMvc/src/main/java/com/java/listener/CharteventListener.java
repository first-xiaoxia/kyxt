package com.java.listener;/**
 * @author 倪军
 * @Date ${Date} 17:33
 */

import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.listener.DataListener;
import com.java.entity.ChatObject;

import java.util.UUID;

/**
 * @author 倪军
 * @version 0.1
 * @time 2018/7/23 17:33
 */
public class CharteventListener implements DataListener<ChatObject> {

    SocketIOServer server;

    public void setServer() {
        this.server = App.getServer();
    }

    public void onData(SocketIOClient client, ChatObject data,
                       AckRequest ackSender) throws Exception {
        // chatevent为 事件的名称， data为发送的内容
        //this.server.getBroadcastOperations().sendEvent("chatevent",data);
        /*ChatObject object = new ChatObject();
        String userName = client.getHandshakeData().getSingleUrlParam("userName");
        object.setType("chatevent");
        object.setReceiver("");
        object.setUserName(userName);
        object.setMessage("你好"+userName);
        client.sendEvent("chatevent",object);*/
        data.setType("chatevent");
        sendMessage(data);
    }


    private void sendMessage(ChatObject chatObject){
        SocketIOClient client = ConnectionMap.getClient(chatObject.getReceiver());
        //如果该客户端不存在
        if(client == null){
            client = ConnectionMap.getClient(chatObject.getUserName());
            chatObject.setMessage("该用户已下线");
            client.sendEvent(chatObject.getType(),chatObject);
        }else{
            client.sendEvent(chatObject.getType(),chatObject);
        }

    }

}