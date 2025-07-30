package fiap_substituva.infrastructure.controllers.estabelecimento;
import fiap_substituva.application.usecases.estabelecimento.EstabelecimentoUseCase;
import fiap_substituva.domain.Estabelecimento;
import fiap_substituva.infrasctruture.controllers.estabelecimento.EstabelecimentoController;
import fiap_substituva.infrasctruture.exception.CustomException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class EstabelecimentoControllerTest {

    private MockMvc mockMvc;

    @Mock
    private EstabelecimentoUseCase estabelecimentoUseCase;

    @InjectMocks
    private EstabelecimentoController estabelecimentoController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(estabelecimentoController).build();
    }

    @Test
    void testBuscarEstabelecimentoPorNome() throws Exception {
        Estabelecimento estabelecimento = new Estabelecimento("Nome", "123456789", "Endereco", "1234567890", null, null, null);
        when(estabelecimentoUseCase.buscarEstabelecimentoPorNome("Nome")).thenReturn(estabelecimento);

        mockMvc.perform(get("/estabelecimentos/Nome"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nome").value("Nome"))
                .andExpect(jsonPath("$.cnpj").value("123456789"))
                .andExpect(jsonPath("$.endereco").value("Endereco"))
                .andExpect(jsonPath("$.telefone").value("1234567890"));

        verify(estabelecimentoUseCase, times(1)).buscarEstabelecimentoPorNome("Nome");
    }

    @Test
    void testCriarEstabelecimento() throws Exception {
        Estabelecimento estabelecimento = new Estabelecimento("Nome", "123456789", "Endereco", "1234567890", null, null, null);
        when(estabelecimentoUseCase.criarEstabelecimento(any(Estabelecimento.class))).thenReturn(estabelecimento);

        String requestBody = """
            {
                "nome": "Nome",
                "cnpj": "123456789",
                "endereco": "Endereco",
                "telefone": "1234567890",
                "servicos": null,
                "profissionais": null,
                "fotos": null
            }
            """;

        mockMvc.perform(post("/estabelecimentos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nome").value("Nome"))
                .andExpect(jsonPath("$.cnpj").value("123456789"))
                .andExpect(jsonPath("$.endereco").value("Endereco"))
                .andExpect(jsonPath("$.telefone").value("1234567890"));

        verify(estabelecimentoUseCase, times(1)).criarEstabelecimento(any(Estabelecimento.class));
    }

    @Test
    void testEditarEstabelecimento() throws Exception {
        Estabelecimento estabelecimento = new Estabelecimento("Nome", "123456789", "Endereco", "1234567890", null, null, null);
        when(estabelecimentoUseCase.editarEstabelecimento(any(Estabelecimento.class))).thenReturn(estabelecimento);

        String requestBody = """
            {
                "nome": "Nome",
                "cnpj": "123456789",
                "endereco": "Endereco",
                "telefone": "1234567890",
                "servicos": null,
                "profissionais": null,
                "fotos": null
            }
            """;

        mockMvc.perform(put("/estabelecimentos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nome").value("Nome"))
                .andExpect(jsonPath("$.cnpj").value("123456789"))
                .andExpect(jsonPath("$.endereco").value("Endereco"))
                .andExpect(jsonPath("$.telefone").value("1234567890"));

        verify(estabelecimentoUseCase, times(1)).editarEstabelecimento(any(Estabelecimento.class));
    }
}