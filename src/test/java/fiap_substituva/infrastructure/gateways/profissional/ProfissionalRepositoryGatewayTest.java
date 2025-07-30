package fiap_substituva.infrastructure.gateways.profissional;
import fiap_substituva.domain.Profissional;
import fiap_substituva.infrasctruture.gateways.profissional.ProfissionalRepositoryGateway;
import fiap_substituva.infrasctruture.persistence.profissional.ProfissionalEntity;
import fiap_substituva.infrasctruture.persistence.profissional.ProfissionalRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ProfissionalRepositoryGatewayTest {

    @Mock
    private ProfissionalRepository profissionalRepository;

    @InjectMocks
    private ProfissionalRepositoryGateway profissionalRepositoryGateway;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void criarProfissional_DeveCriarProfissionalComSucesso() {
        // Arrange
        Profissional profissional = new Profissional("João", "Dentista", BigDecimal.valueOf(200.00), 1L);
        ProfissionalEntity profissionalEntity = new ProfissionalEntity(null, "João", "Dentista", BigDecimal.valueOf(200.00), 1L);
        ProfissionalEntity savedEntity = new ProfissionalEntity(1L, "João", "Dentista", BigDecimal.valueOf(200.00), 1L);

        when(profissionalRepository.save(any(ProfissionalEntity.class))).thenReturn(savedEntity);

        // Act
        Profissional result = profissionalRepositoryGateway.criarProfissional(profissional);

        // Assert
        assertNotNull(result);
        assertEquals("João", result.getNome());
        assertEquals("Dentista", result.getEspecialidade());
        assertEquals(BigDecimal.valueOf(200.00), result.getTarifa());
        assertEquals(1L, result.getEstabelecimentoId());
        verify(profissionalRepository, times(1)).save(any(ProfissionalEntity.class));
    }
}