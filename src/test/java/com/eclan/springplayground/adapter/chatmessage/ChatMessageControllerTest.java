package com.eclan.springplayground.adapter.chatmessage;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest
class ChatMessageControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void connectChat_unauthorized() throws Exception {
        mockMvc.perform(get("/chat"))
                .andDo(print())
                .andExpect(status().isUnauthorized());
    }

    @Test
    @WithMockUser(username = "moritz", password = "password")
    void connectChat_auhtorized() throws Exception {
        mockMvc.perform(get("/chat"))
                .andDo(print())
                .andExpect(status().isNotFound());
    }
}
