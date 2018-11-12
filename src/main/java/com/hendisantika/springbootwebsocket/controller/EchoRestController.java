package com.hendisantika.springbootwebsocket.controller;

import com.hendisantika.springbootwebsocket.entity.Echo;
import com.hendisantika.springbootwebsocket.repository.EchoRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-websocket
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 13/11/18
 * Time: 06.33
 */
@RequestMapping("/api/echo")
@RestController
public class EchoRestController {

    private final EchoRepository echoRepository;

    public EchoRestController(EchoRepository echoRepository) {
        this.echoRepository = echoRepository;
    }

    @GetMapping
    public List<Echo> get() {
        return echoRepository.findAll();
    }
}