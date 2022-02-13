package com.tom107.springwebsocket;

import com.tom107.springwebsocket.payload.MessagePayload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;

import java.util.UUID;

@org.springframework.stereotype.Controller
public class ChatController {

    @Autowired
    ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @MessageMapping("/message")
    @SendTo("/response/message")
    public MessagePayload clientLogin(MessagePayload payload) {
        return payload;
    }

}
