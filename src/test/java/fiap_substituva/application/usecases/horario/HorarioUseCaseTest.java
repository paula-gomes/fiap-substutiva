package fiap_substituva.application.usecases.horario;

import fiap_substituva.application.gateways.HorarioGateway;
import fiap_substituva.domain.Horario;
import fiap_substituva.domain.enums.DiasDaSemanaEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class HorarioUseCaseTest {

    @Mock
    private HorarioGateway horarioGateway;

    @InjectMocks
    private HorarioUseCase horarioUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldFetchHorariosByEstabelecimentoIdSuccessfully() {

        Long idEstabelecimento = 1L;
        List<Horario> horarios = List.of(createHorario());
        when(horarioGateway.buscarHorariosPorIdEstabelecimento(idEstabelecimento)).thenReturn(horarios);

        List<Horario> result = horarioUseCase.buscarHorariosPorIdEstabelecimento(idEstabelecimento);

        assertNotNull(result);
        assertEquals(1, result.size());
        verify(horarioGateway, times(1)).buscarHorariosPorIdEstabelecimento(idEstabelecimento);
    }

    @Test
    void shouldRegisterHorarioSuccessfully() {

        Horario horario = createHorario();
        when(horarioGateway.cadastraHorario(horario)).thenReturn(horario);

        Horario result = horarioUseCase.cadastraHorario(horario);


        assertNotNull(result);
        assertEquals(DiasDaSemanaEnum.SEGUNDA, result.getDiaDaSemana());
        verify(horarioGateway, times(1)).cadastraHorario(horario);
    }

    @Test
    void shouldDeleteHorarioSuccessfully() {

        Long horarioId = 1L;
        doNothing().when(horarioGateway).excluirHorario(horarioId);


        horarioUseCase.excluirHorario(horarioId);

        verify(horarioGateway, times(1)).excluirHorario(horarioId);
    }


    private Horario createHorario() {
        return new Horario(
                1L,
                DiasDaSemanaEnum.SEGUNDA,
                LocalTime.of(9, 0),
                LocalTime.of(17, 0),
                1L
        );
    }
}