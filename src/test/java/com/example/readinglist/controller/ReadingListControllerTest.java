package com.example.readinglist.controller;


import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
@RunWith(SpringRunner.class)
@WebAppConfiguration
public class ReadingListControllerTest {

    @Autowired
    private WebApplicationContext webContext;   //注入webContext

    private MockMvc mockMvc;

    @Before
    public void steupMoc() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webContext).build();   //设置mockmvc
    }

    @Test
    public void readersBooks() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/readingList"))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.view().name("readingList"))
            .andExpect(MockMvcResultMatchers.model().attributeExists("books"))
            .andExpect(MockMvcResultMatchers.model().attribute("books", Matchers.is(Matchers.empty())));
    }

    @Test
    public void addToReadingList() {
    }
}