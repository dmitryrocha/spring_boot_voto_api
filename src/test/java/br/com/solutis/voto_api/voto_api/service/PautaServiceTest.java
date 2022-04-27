package br.com.solutis.voto_api.voto_api.service;

import br.com.solutis.voto_api.voto_api.model.Pauta;
import br.com.solutis.voto_api.voto_api.repository.PautaRepository;
import br.com.solutis.voto_api.voto_api.service.PautaService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(PautaService.class)
public class PautaServiceTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PautaRepository pautaRepository;

    @Test
    public void callingWithWrongParameterShouldReturnBadRequest() throws Exception {
        Pauta pauta = pautaRepository.getById(999L);
    }

    @Test
    public void shouldReturnJustOneFromResult() throws Exception {

    }
}
