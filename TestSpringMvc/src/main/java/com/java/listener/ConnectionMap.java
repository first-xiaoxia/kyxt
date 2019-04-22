package com.java.listener;/**
 * @author 倪军
 * @Date ${Date} 11:14
 */

import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 倪军
 * @version 0.1
 * @time 2018/7/24 11:14
 */
public class ConnectionMap {

    private static Map<String,Object> map = new HashMap<String,Object>();

    public static void addClient(String userName, SocketIOClient SocketIOClient){
        map.put(userName,SocketIOClient);
    }
    public static void removeClient(String userName){
        map.remove(userName);
    }

    public static SocketIOClient getClient(String userName){
        return (SocketIOClient) map.get(userName);
    }
}
