package com.sydowma.unitextension;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.net.URI;

@WebMvcTest
public class FooControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testGetFoo() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get(URI.create("/api/foo")))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("foo"))
        ;

    }

}
