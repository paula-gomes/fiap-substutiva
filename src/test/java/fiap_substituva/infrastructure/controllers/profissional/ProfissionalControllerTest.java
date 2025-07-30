package fiap_substituva.infrastructure.controllers.profissional;

import fiap_substituva.application.usecases.profissional.ProfissionalUseCase;
import fiap_substituva.domain.Profissional;
import fiap_substituva.infrasctruture.controllers.profissional.ProfissionalController;
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

public class ProfissionalControllerTest {

    private MockMvc mockMvc;

    @Mock
    private ProfissionalUseCase profissionalUseCase;

    @InjectMocks
    private ProfissionalController profissionalController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(profissionalController).build();
    }

    @Test
    void testCriarProfissional() throws Exception {
        Profissional profissional = new Profissional("João", "Dentista", new BigDecimal("150"), 1L);
        when(profissionalUseCase.criarProfissional(any(Profissional.class))).thenReturn(profissional);

        String requestBody = """
            {
                "nome": "João",
                "especialidade": "Dentista",
                "tarifa": 150.0,
                "estabelecimentoId": 1
            }
            """;

        mockMvc.perform(post("/profissionais")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nome").value("João"))
                .andExpect(jsonPath("$.especialidade").value("Dentista"))
                .andExpect(jsonPath("$.tarifa").value(150.0))
                .andExpect(jsonPath("$.estabelecimentoId").value(1));

        verify(profissionalUseCase, times(1)).criarProfissional(any(Profissional.class));
    }
}
