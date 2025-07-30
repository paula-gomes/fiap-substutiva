package fiap_substituva.application.usecases.profissional;


import fiap_substituva.application.gateways.ProfissionalGateway;
import fiap_substituva.domain.Profissional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ProfissionalUseCaseTest {

    @Mock
    private ProfissionalGateway profissionalGateway;

    @InjectMocks
    private ProfissionalUseCase profissionalUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldCreateProfissionalSuccessfully() {

        Profissional profissional = createProfissional();
        when(profissionalGateway.criarProfissional(profissional)).thenReturn(profissional);

        Profissional result = profissionalUseCase.criarProfissional(profissional);

        assertNotNull(result);
        assertEquals("John Doe", result.getNome());
        assertEquals("Hair Stylist", result.getEspecialidade());
        assertEquals(BigDecimal.valueOf(100.00), result.getTarifa());
        assertEquals(1L, result.getEstabelecimentoId());
        verify(profissionalGateway, times(1)).criarProfissional(profissional);
    }

    private Profissional createProfissional() {
        return new Profissional(
                "John Doe",
                "Hair Stylist",
                BigDecimal.valueOf(100.00),
                1L
        );
    }
}