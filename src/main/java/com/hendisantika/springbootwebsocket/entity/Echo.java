package com.hendisantika.springbootwebsocket.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-websocket
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 13/11/18
 * Time: 06.28
 */
@Entity
@Data
public class Echo {
    @Id
    @GeneratedValue
    private Integer id;

    private String text;
}