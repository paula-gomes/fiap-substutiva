package fiap_substituva.application.usecases.estabelecimento;
import fiap_substituva.application.gateways.EstabelecimentoGateway;
import fiap_substituva.domain.Estabelecimento;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class EstabelecimentoUseCaseTest {

    @Mock
    private EstabelecimentoGateway estabelecimentoGateway;

    @InjectMocks
    private EstabelecimentoUseCase estabelecimentoUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldCreateEstabelecimentoSuccessfully() {

        Estabelecimento estabelecimento = createEstabelecimento();
        when(estabelecimentoGateway.criarEstabelecimento(estabelecimento)).thenReturn(estabelecimento);

        Estabelecimento result = estabelecimentoUseCase.criarEstabelecimento(estabelecimento);

        assertNotNull(result);
        assertEquals("Estabelecimento A", result.getNome());
        verify(estabelecimentoGateway, times(1)).criarEstabelecimento(estabelecimento);
    }

    @Test
    void shouldFindEstabelecimentoByNameSuccessfully() {

        String nome = "Estabelecimento A";
        Estabelecimento estabelecimento = createEstabelecimento();
        when(estabelecimentoGateway.buscarEstabelecimentoPorNome(nome)).thenReturn(estabelecimento);

        Estabelecimento result = estabelecimentoUseCase.buscarEstabelecimentoPorNome(nome);

        assertNotNull(result);
        assertEquals(nome, result.getNome());
        verify(estabelecimentoGateway, times(1)).buscarEstabelecimentoPorNome(nome);
    }

    @Test
    void shouldEditEstabelecimentoSuccessfully() {

        Estabelecimento estabelecimento = createEstabelecimento();
        when(estabelecimentoGateway.editarEstabelecimento(estabelecimento)).thenReturn(estabelecimento);

        Estabelecimento result = estabelecimentoUseCase.editarEstabelecimento(estabelecimento);

        assertNotNull(result);
        assertEquals("Estabelecimento A", result.getNome());
        verify(estabelecimentoGateway, times(1)).editarEstabelecimento(estabelecimento);
    }


    private Estabelecimento createEstabelecimento() {
        return new Estabelecimento(
                "Estabelecimento A",
                "12345678000100",
                "Rua Exemplo, 123",
                "11999999999",
                List.of("Serviço 1", "Serviço 2"),
                List.of("Profissional 1", "Profissional 2"),
                List.of("foto1.jpg", "foto2.jpg")
        );
    }
}