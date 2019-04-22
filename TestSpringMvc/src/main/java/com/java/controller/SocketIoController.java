package com.java.controller;/**
 * @author 倪军
 * @Date ${Date} 10:50
 */

import com.java.service.SocketIoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.WebUtils;
import sun.plugin.javascript.ReflectUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Map;

/**
 * @author 倪军
 * @version 0.1
 * @time 2018/7/23 10:50
 */
@RestController
@RequestMapping("/socketController")
public class SocketIoController {
    @Autowired
    private SocketIoService service;

    //启动socket 服务
    @RequestMapping("startServer")
    public void startServer(HttpServletRequest request,HttpServletResponse response) throws Exception{
        Map<String,Object> params = WebUtils.getParametersStartingWith(request,null);
        try {
            if(service.getServer() == null){
                /*new Thread(new Runnable() {
                    public void run() {
                        // TODO Auto-generated method stub
                        try {
                            service.startServer();
                        } catch (InterruptedException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                }).start();*/

            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        service.startServer();
    }

    //停止socket服务
    @RequestMapping("stopServer")
    public void stopServer(HttpServletRequest request,HttpServletResponse response) throws Exception{
        Map<String,Object> params = WebUtils.getParametersStartingWith(request,null);
        try {
            if(service.getServer() == null){
                service.stopServer();
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    //给指定的客户端推送消息
    @RequestMapping("sendAdvertInfoMsg")
    public void sendAdvertInfoMsg(HttpServletRequest request, HttpServletResponse response) throws Exception{
        Map<String,Object> params = WebUtils.getParametersStartingWith(request,null);
        String uuid = (String) params.get("uuid");
        try {
            if(!"".equals(uuid) && service.getServer() != null){
                service.sendMessageToOneClient(uuid, "advert_info", "推送的内容");
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
