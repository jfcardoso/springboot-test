package com.dio.springboot.springboottest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;

@WebMvcTest
@ExtendWith(SpringExtension.class)
public class TestIntegrationController {

    @Autowired
    private MockMvc mvc;

    @Test
    public void testIntegrationDefault() throws Exception{
        RequestBuilder requisicao = get("/test");
        MvcResult result = mvc.perform(requisicao).andReturn();
        assertEquals("Bem-vindo, Spring Boot!", result.getResponse().getContentAsString());
    }

    @Test
    public void testIntegrationWithParam() throws Exception{
        mvc.perform(get("/test?nome=Peter"))
                .andExpect(content().string("Bem-vindo, Peter!"));

    }


}
