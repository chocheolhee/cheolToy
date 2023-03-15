package com.cheol.toy.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class PostControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("/posts 요청 시 Hello World 를 출력")
    void test() throws Exception {
        // expected
        mockMvc.perform(MockMvcRequestBuilders.post("/posts")

                )
                .andExpect(status().isOk())
                .andExpect(content().string("Hello World"))
                .andDo(print());
    }

    @Test
    @DisplayName("/posts 요청 시 title 값은 필수")
    void test2() throws Exception {
        // expected
        mockMvc.perform(MockMvcRequestBuilders.post("/posts")

                )
                .andExpect(status().isOk())
                .andExpect(content().string("Hello World"))
                .andDo(print());
    }
}