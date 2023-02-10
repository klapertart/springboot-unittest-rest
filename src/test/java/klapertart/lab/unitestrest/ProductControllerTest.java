package klapertart.lab.unitestrest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MockMvcResultHandlersDsl;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * @author kurakuraninja
 * @since 10/02/23
 */

@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testWelcomeStatusOK() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/welcome"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void testWelcomeBody() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/welcome"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.content().string("API Central 0.0"));
    }

    @Test
    void testMessagesStatusOK() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/messages"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void testMessagesJsonBody() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/messages"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("{'message':'Greeting from API'}"));
    }

    @Test
    void testMessagesJsonPath() throws Exception {
        String expectedMessage = "Greeting from API";

        mockMvc.perform(MockMvcRequestBuilders.get("/api/messages"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value(expectedMessage));
    }

    @Test
    void testProduct() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/product"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Snack"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.price").value("5500"));
    }

}
