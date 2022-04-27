package br.com.solutis.voto_api.voto_api.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.net.URI;
import java.net.URISyntaxException;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SessaoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturn400() throws URISyntaxException {
        URI uri = new URI("/sessao/6");
    }
}
