package fiap_substituva.infrastructure.controllers.avaliacao;


import fiap_substituva.application.usecases.avaliacao.AvaliacaoUseCase;
import fiap_substituva.domain.Avaliacao;
import fiap_substituva.infrasctruture.controllers.avaliacao.AvaliacaoController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class AvaliacaoControllerTest {

    private MockMvc mockMvc;

    @Mock
    private AvaliacaoUseCase avaliacaoUseCase;

    @InjectMocks
    private AvaliacaoController avaliacaoController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(avaliacaoController).build();
    }

    @Test
    void testCriarAvaliacaoProfissional() throws Exception {
        Avaliacao avaliacao = new Avaliacao(1L, 2L, 5, "Great service", 3L, 4L);
        when(avaliacaoUseCase.criarAvaliacaoProfissional(any(Avaliacao.class))).thenReturn(avaliacao);

        String requestBody = """
            {
                "id": 1,
                "idCliente": 2,
                "estrelas": 5,
                "comentario": "Great service",
                "idEstabelecimento": 3,
                "idProfissional": 4
            }
            """;

        mockMvc.perform(post("/avaliacoes/profissionais")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.idCliente").value(2))
                .andExpect(jsonPath("$.estrelas").value(5))
                .andExpect(jsonPath("$.comentario").value("Great service"))
                .andExpect(jsonPath("$.idEstabelecimento").value(3))
                .andExpect(jsonPath("$.idProfissional").value(4));

        verify(avaliacaoUseCase, times(1)).criarAvaliacaoProfissional(any(Avaliacao.class));
    }

    @Test
    void testListarAvaliacoesProfissionais() throws Exception {
        Avaliacao avaliacao = new Avaliacao(1L, 2L, 5, "Great service", 3L, 4L);
        when(avaliacaoUseCase.listarAvaliacoesProfissionais(4L)).thenReturn(List.of(avaliacao));

        mockMvc.perform(get("/avaliacoes/profissionais/4"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].idCliente").value(2))
                .andExpect(jsonPath("$[0].estrelas").value(5))
                .andExpect(jsonPath("$[0].comentario").value("Great service"))
                .andExpect(jsonPath("$[0].idEstabelecimento").value(3))
                .andExpect(jsonPath("$[0].idProfissional").value(4));

        verify(avaliacaoUseCase, times(1)).listarAvaliacoesProfissionais(4L);
    }
}