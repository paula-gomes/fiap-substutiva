package fiap_substituva.application.usecases.agendamento;

import fiap_substituva.application.gateways.AgendamentoGateway;
import fiap_substituva.domain.Agendamento;
import fiap_substituva.domain.enums.StatusAgendamentoEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class AgendamentoUseCaseTest {

    @Mock
    private AgendamentoGateway agendamentoGateway;

    @InjectMocks
    private AgendamentoUseCase agendamentoUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldCreateAgendamentoSuccessfully() {

        Agendamento agendamento = createAgendamento();
        when(agendamentoGateway.criarAgendamento(agendamento)).thenReturn(agendamento);

        Agendamento result = agendamentoUseCase.criarAgendamento(agendamento);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals(StatusAgendamentoEnum.CONFIRMADO, result.getStatus());
        verify(agendamentoGateway, times(1)).criarAgendamento(agendamento);
    }

    @Test
    void shouldThrowExceptionWhenCreatingNullAgendamento() {

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            agendamentoUseCase.criarAgendamento(null);
        });
        assertEquals("Agendamento cannot be null", exception.getMessage());
    }

    @Test
    void shouldListAgendamentosSuccessfully() {

        List<Agendamento> agendamentos = List.of(createAgendamento());
        when(agendamentoGateway.listarAgendamentos()).thenReturn(agendamentos);

        List<Agendamento> result = agendamentoUseCase.listarAgendamentos();

        assertNotNull(result);
        assertEquals(1, result.size());
        verify(agendamentoGateway, times(1)).listarAgendamentos();
    }

    @Test
    void shouldUpdateAgendamentoSuccessfully() {

        Agendamento agendamento = createAgendamento();
        when(agendamentoGateway.atualizarAgendamento(1L, agendamento)).thenReturn(agendamento);

        Agendamento result = agendamentoUseCase.atualizarAgendamento(1L, agendamento);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals(StatusAgendamentoEnum.CONFIRMADO, result.getStatus());
        verify(agendamentoGateway, times(1)).atualizarAgendamento(1L, agendamento);
    }

    @Test
    void shouldThrowExceptionWhenUpdatingWithNullIdOrAgendamento() {

        IllegalArgumentException exception1 = assertThrows(IllegalArgumentException.class, () -> {
            agendamentoUseCase.atualizarAgendamento(null, createAgendamento());
        });
        assertEquals("ID or Agendamento cannot be null", exception1.getMessage());

        IllegalArgumentException exception2 = assertThrows(IllegalArgumentException.class, () -> {
            agendamentoUseCase.atualizarAgendamento(1L, null);
        });
        assertEquals("ID or Agendamento cannot be null", exception2.getMessage());
    }

    @Test
    void shouldDeleteAgendamentoSuccessfully() {

        doNothing().when(agendamentoGateway).excluirAgendamento(1L);

        agendamentoUseCase.excluirAgendamento(1L);

        verify(agendamentoGateway, times(1)).excluirAgendamento(1L);
    }

    @Test
    void shouldThrowExceptionWhenDeletingWithNullId() {

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            agendamentoUseCase.excluirAgendamento(null);
        });
        assertEquals("ID cannot be null", exception.getMessage());
    }


    private Agendamento createAgendamento() {
        return new Agendamento(
                1L,
                2L,
                3L,
                4L,
                5L,
                StatusAgendamentoEnum.CONFIRMADO,
                LocalDate.now(),
                LocalTime.of(10, 0),
                LocalTime.of(11, 0)
        );
    }
}