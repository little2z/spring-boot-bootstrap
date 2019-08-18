package com.xyl.web;


import com.xyl.SpringBootBootstrapApplication;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.nio.charset.Charset;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = { SpringBootBootstrapApplication.class })
@WebAppConfiguration
public class BookControllerMockTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @Before
    public void setupMockMvc() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }


    @Test
    public void createBookTest() throws Exception {
        MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(), MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));

//        mockMvc.perform(MockMvcRequestBuilders.post("/api/books").content("{\"title\":\"test\", \"author\":\"testAuthor\"")).andExpect(MockMvcResultMatchers.status().isOk()).andExpect(MockMvcResultMatchers.content().contentType(contentType)).andExpect(jsonPath("$.id", equalTo(1)));

        String requestBody = "{\"title\":\"test\", \"author\":\"testAuthor\"}";
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/api/books").contentType(MediaType.APPLICATION_JSON).content(requestBody)).andDo(MockMvcResultHandlers.print()).andReturn();

    }


}
