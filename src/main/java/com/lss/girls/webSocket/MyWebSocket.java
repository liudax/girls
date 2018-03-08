package com.lss.girls.webSocket;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Magic
 * @date 10:22 2018/3/7
 * @description
 */
@Component
@ServerEndpoint(value = "/webSocket/{username}")
public class MyWebSocket {

    private final Logger logger = LoggerFactory.getLogger(MyWebSocket.class);
    private static Map<String,MyWebSocket> clients = new ConcurrentHashMap<>();
    private Session session;
    private String userName;
    private String test1;
    private String test;

    public static Map<String, MyWebSocket> getClients() {
        return clients;
    }

    public static void setClients(Map<String, MyWebSocket> clients) {
        MyWebSocket.clients = clients;
    }

    public static void sendText(String userName,String message) throws Exception{
        MyWebSocket myWebSocket = clients.get(userName);
        myWebSocket.getSession().getAsyncRemote().sendText(message);
    }

    @OnOpen
    public void onOpen(@PathParam("username") String userName,Session session) throws Exception{
        this.userName = userName;
        this.session = session;
        clients.put(userName,this);
        logger.info("客户端:"+userName+" 连接开启了");
    }

    @OnClose
    public void onClose() throws Exception{
        clients.remove(userName);
        logger.info("客户端:"+userName+" 连接关闭了");
    }

    @OnMessage
    public void onMessage(String messageJson) throws Exception{

        logger.info(messageJson);
        ObjectMapper mapper = new ObjectMapper();
        Message msg = mapper.readValue(messageJson,Message.class);
        sendMessage(msg);

    }


    public void sendMessage(Message message){
        for(MyWebSocket socket: clients.values()){
            if(socket.getUserName().equals(message.getTo()) || "all".equals(message.getTo())){
                socket.getSession().getAsyncRemote().sendText(message.getFrom()+"说："+message.getMessage());
            }
        }
    }



    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
