package com.coderman.cardatabase.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CarRestTest {

    //->by using this, the server is not started, but the tests are performed in the layer where Spring handles HTTP requests, and therefore it mocks the real situation
    //MockMvc provides perform method to send these request.
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testAuthentication() throws Exception{
        //Testing authentication with correct credentials
            this.mockMvc.perform(MockMvcRequestBuilders.post("/login")
                .content("{\"username\": \"user\",\"password\": \"user\"}")).andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().isOk());

        //Testing authentication with wrong credentials
        this.mockMvc.perform(MockMvcRequestBuilders.post("/login")
                .content("{\"username\": \"user\",\"password\": \"wrong password\"}")).andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().is4xxClientError());
    }
}
