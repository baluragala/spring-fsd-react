package com.knowledgehut.chocostore.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.knowledgehut.chocostore.ChocolateStoreApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


@SpringBootTest(classes = ChocolateStoreApplication.class)
public class ChocolatesRestApiTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @BeforeClass
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testChocolatesApi() throws Exception {
        mockMvc.perform(get("/api/chocolates")).andExpect(status().isOk())
                .andExpect(content().contentType("application/hal+json"));


    }

    @Test
    public void testChocolates() throws Exception {
        mockMvc.perform(get("/api/chocolates"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/hal+json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$._embedded.chocolates").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$._embedded.chocolates[*].name").isNotEmpty());

    }

    @Test
    public void testChocolatesForLength() throws Exception {
        mockMvc.perform(get("/api/chocolates"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/hal+json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$._embedded.chocolates").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$._embedded.chocolates").isArray())
                .andExpect(MockMvcResultMatchers.jsonPath("$._embedded.chocolates.length()").value(3));

    }

}