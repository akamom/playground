package com.eclan.springplayground.adapter.in.websocket;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.eclan.springplayground.adapter.in.websocket.model.ChatMessage;
import com.eclan.springplayground.adapter.in.websocket.model.MetaData;

import jakarta.validation.Valid;

@Controller
public class ChatMessageController {

    private static final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ISO_INSTANT;

    @MessageMapping("/message")
    @SendTo("/topic/message")
    public ChatMessage greeting(@Valid ChatMessage messageIn) {
        // TODO validate input.
        return buildOutMessage(messageIn);
    }

    // TODO validate that receivedAt is later as createdAt
    private ChatMessage buildOutMessage(ChatMessage messageIn) {
        var receivedAt = LocalDateTime.now().atZone(ZoneId.systemDefault()).format(DATE_PATTERN);
        var metaIn = messageIn.metaData();
        var metaOut = new MetaData(metaIn.createdAt(), receivedAt, null, metaIn.createdBy());
        return new ChatMessage(metaOut, messageIn.chatId(), messageIn.content());
    }
}
