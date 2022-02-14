package com.taskmanagement.web.controller;

import com.taskmanagement.core.model.EmployeeDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration
@AutoConfigureMockMvc
public class EmployeeControllerSpec {

    @LocalServerPort
    private int port;

    @Autowired
    private WebApplicationContext context;

    @Autowired
    private MockMvc mvc;

    @Test
    void save() throws Exception{
        String data = "{\"name\":\"Dhiraj\"}";

        String baseUrl = "http://localhost:" + port + "/employee/save";
        this.mvc.perform(post(baseUrl)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(data)
                .characterEncoding("utf-8")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string("{\"id\":1,\"name\":\"Dhiraj\"}"));
    }

    @Test
    void list() throws Exception{
        String baseUrl = "http://localhost:" + port + "/employee/list";
        this.mvc.perform(get(baseUrl)).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string("[]"));
    }

}
