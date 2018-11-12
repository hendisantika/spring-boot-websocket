package com.hendisantika.springbootwebsocket.repository;

import com.hendisantika.springbootwebsocket.entity.Echo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-websocket
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 13/11/18
 * Time: 06.30
 */
public interface EchoRepository extends JpaRepository<Echo, Integer> {
}
