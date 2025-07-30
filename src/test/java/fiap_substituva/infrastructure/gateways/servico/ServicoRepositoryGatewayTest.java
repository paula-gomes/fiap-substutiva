package fiap_substituva.infrastructure.gateways.servico;
import fiap_substituva.domain.Servico;
import fiap_substituva.infrasctruture.exception.CustomException;
import fiap_substituva.infrasctruture.gateways.servico.ServicoRepositoryGateway;
import fiap_substituva.infrasctruture.persistence.servico.ServicoEntity;
import fiap_substituva.infrasctruture.persistence.servico.ServicoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ServicoRepositoryGatewayTest {

    @Mock
    private ServicoRepository servicoRepository;

    @InjectMocks
    private ServicoRepositoryGateway servicoRepositoryGateway;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void criarServico_DeveCriarServicoComSucesso() {

        Servico servico = new Servico("Corte de Cabelo", "Corte masculino", BigDecimal.valueOf(50.00), 1L);
        ServicoEntity servicoEntity = new ServicoEntity(null, "Corte de Cabelo", "Corte masculino", BigDecimal.valueOf(50.00), 1L);
        ServicoEntity savedEntity = new ServicoEntity(1L, "Corte de Cabelo", "Corte masculino", BigDecimal.valueOf(50.00), 1L);

        when(servicoRepository.save(any(ServicoEntity.class))).thenReturn(savedEntity);

        Servico result = servicoRepositoryGateway.criarServico(servico);

        assertNotNull(result);
        assertEquals("Corte de Cabelo", result.getNome());
        assertEquals("Corte masculino", result.getDescricao());
        assertEquals(BigDecimal.valueOf(50.00), result.getPreco());
        assertEquals(1L, result.getEstabelecimentoId());
        verify(servicoRepository, times(1)).save(any(ServicoEntity.class));
    }

    @Test
    void criarServico_DeveLancarExcecaoQuandoFalhaAoSalvar() {

        Servico servico = new Servico("Corte de Cabelo", "Corte masculino", BigDecimal.valueOf(50.00), 1L);
        when(servicoRepository.save(any(ServicoEntity.class))).thenReturn(null);

        CustomException exception = assertThrows(CustomException.class, () -> {
            servicoRepositoryGateway.criarServico(servico);
        });

        assertEquals(HttpStatus.SERVICE_UNAVAILABLE, exception.getStatus());
        assertEquals("Failed to save Servico", exception.getMessage());
        verify(servicoRepository, times(1)).save(any(ServicoEntity.class));
    }
}