package net.gramenz.jrpa.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import net.gramenz.jrpa.lib.ws.Greeting;
import net.gramenz.jrpa.lib.ws.HelloMessage;

@Controller
public class WebSocket {

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message) {
        return new Greeting("Hello, " + message.getName() + "!");
    }
}
