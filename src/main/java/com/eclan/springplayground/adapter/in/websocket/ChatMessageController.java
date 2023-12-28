package com.eclan.springplayground.adapter.in.websocket;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

import com.eclan.springplayground.adapter.in.websocket.model.ChatMessageIn;
import com.eclan.springplayground.adapter.in.websocket.model.ChatMessageOut;

@Controller
public class ChatMessageController {

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public ChatMessageOut greeting(ChatMessageIn messageIn) throws InterruptedException {
        Thread.sleep(500); // simulated delay
        var text = messageIn.text();
        var escapedText =HtmlUtils.htmlEscape(text);
        return new ChatMessageOut("Hello, %s!".formatted(escapedText));
    }
}
