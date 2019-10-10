package br.com.gabriels.dadsort.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.util.NestedServletException;

import java.net.URI;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TeamGeneratorTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldTestGeneratorControllerWhenParametersAreOK() throws Exception {
        String players = "- Gabriel " +
                "- Veronica " +
                "- Yuri " +
                "- Matheus";

        mockMvc.perform(MockMvcRequestBuilders.post("/").param("players", players))
                .andExpect(status().isOk());
    }

    @Test(expected = NestedServletException.class)
    public void shouldTestGeneratorControllerWhenParametersAreNotOK() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/"));
    }
}
