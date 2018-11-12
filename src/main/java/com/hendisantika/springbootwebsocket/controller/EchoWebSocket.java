package com.hendisantika.springbootwebsocket.controller;

import com.hendisantika.springbootwebsocket.config.SpringContext;
import com.hendisantika.springbootwebsocket.entity.Echo;
import com.hendisantika.springbootwebsocket.repository.EchoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-websocket
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 13/11/18
 * Time: 06.32
 */
@ServerEndpoint("/echo")
public class EchoWebSocket {

    private static final Logger LOGGER = LoggerFactory.getLogger(EchoWebSocket.class);

    private final EchoRepository echoRepository;

    public EchoWebSocket() {
        this.echoRepository = (EchoRepository) SpringContext.getApplicationContext().getBean("echoRepository");
    }

    @OnOpen
    public void onOpen(Session session) {
        LOGGER.info("onOpen " + session.getId());
    }

    @OnMessage
    public void onMessage(String message, Session session) {
        try {
            LOGGER.info("onMessage From=" + session.getId());
            LOGGER.info("onMessage Message=" + message);

            Echo echo = new Echo();
            echo.setText(message);
            echoRepository.saveAndFlush(echo);

            session.getBasicRemote().sendText(message.toUpperCase());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @OnClose
    public void onClose(Session session) {
        LOGGER.info("onClose " + session.getId());
    }

    @OnError
    public void onError(Throwable t) {
        LOGGER.error(t.getMessage(), t);
    }
}
