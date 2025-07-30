package fiap_substituva.infrastructure.controllers.servico;
import fiap_substituva.application.usecases.servico.ServicoUseCase;
import fiap_substituva.domain.Servico;
import fiap_substituva.infrasctruture.controllers.servico.ServicoController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.math.BigDecimal;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class ServicoControllerTest {

    private MockMvc mockMvc;

    @Mock
    private ServicoUseCase servicoUseCase;

    @InjectMocks
    private ServicoController servicoController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(servicoController).build();
    }

    @Test
    void testCriarServico() throws Exception {
        Servico servico = new Servico("Corte de Cabelo", "Corte masculino", new BigDecimal("50"), 1L);
        when(servicoUseCase.criarServico(any(Servico.class))).thenReturn(servico);

        String requestBody = """
            {
                "nome": "Corte de Cabelo",
                "descricao": "Corte masculino",
                "preco": 50.0,
                "estabelecimentoId": 1
            }
            """;

        mockMvc.perform(post("/servicos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nome").value("Corte de Cabelo"))
                .andExpect(jsonPath("$.descricao").value("Corte masculino"))
                .andExpect(jsonPath("$.preco").value(50.0))
                .andExpect(jsonPath("$.estabelecimentoId").value(1));

        verify(servicoUseCase, times(1)).criarServico(any(Servico.class));
    }
}