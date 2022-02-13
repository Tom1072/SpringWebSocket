package com.tom107.springwebsocket;

import com.tom107.springwebsocket.model.Greeting;
import com.tom107.springwebsocket.model.HelloMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.util.HtmlUtils;

@Controller
public class GreetingController {

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage helloMessage) {
        return new Greeting("Hello: " + HtmlUtils.htmlEscape(helloMessage.getName()) + "!");
    }

}
