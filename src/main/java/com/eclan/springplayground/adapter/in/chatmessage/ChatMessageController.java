package com.eclan.springplayground.adapter.in.chatmessage;

import java.security.Principal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.eclan.springplayground.adapter.in.chatmessage.model.ChatMessage;
import com.eclan.springplayground.adapter.in.chatmessage.model.MetaData;

import jakarta.validation.Valid;

@Controller
public class ChatMessageController {

    private static final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ISO_INSTANT;

    @MessageMapping("/message")
    @SendTo("/topic/message")
    public ChatMessage greeting(@Valid ChatMessage messageIn, Principal principal) {
        // TODO validate input.
        String username = principal.getName();
        return buildOutMessage(messageIn, username);
    }

    // TODO validate that receivedAt is later as createdAt
    private ChatMessage buildOutMessage(ChatMessage messageIn, String username) {
        var receivedAt = LocalDateTime.now().atZone(ZoneId.systemDefault()).format(DATE_PATTERN);
        // TODO temp solution. has to be improved with validator
        var metaIn = messageIn.metaData() == null ? new MetaData(receivedAt, receivedAt, null, "no-user")
                : messageIn.metaData();
        var metaOut = new MetaData(metaIn.createdAt(), receivedAt, null, metaIn.createdBy());
        return new ChatMessage(metaOut, messageIn.chatId(), messageIn.content(), username);
    }
}
