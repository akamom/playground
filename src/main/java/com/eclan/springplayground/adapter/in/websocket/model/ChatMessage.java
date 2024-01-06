package com.eclan.springplayground.adapter.in.websocket.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ChatMessage(
        @NotNull
        MetaData metaData,
        @NotNull
        int chatId,
        @NotBlank
        String content) {

}