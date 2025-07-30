package fiap_substituva.application.usecases.servico;

import fiap_substituva.application.gateways.ServicoGateway;
import fiap_substituva.domain.Servico;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ServicoUseCaseTest {

    @Mock
    private ServicoGateway servicoGateway;

    @InjectMocks
    private ServicoUseCase servicoUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldCreateServicoSuccessfully() {

        Servico servico = createServico();
        when(servicoGateway.criarServico(servico)).thenReturn(servico);

        Servico result = servicoUseCase.criarServico(servico);

        assertNotNull(result);
        assertEquals("Corte de Cabelo", result.getNome());
        assertEquals("Corte masculino", result.getDescricao());
        assertEquals(BigDecimal.valueOf(50.00), result.getPreco());
        assertEquals(1L, result.getEstabelecimentoId());
        verify(servicoGateway, times(1)).criarServico(servico);
    }

    private Servico createServico() {
        return new Servico(
                "Corte de Cabelo",
                "Corte masculino",
                BigDecimal.valueOf(50.00),
                1L
        );
    }
}