package fiap_substituva.infrastructure.controllers.horario;

import fiap_substituva.application.usecases.horario.HorarioUseCase;
import fiap_substituva.domain.Horario;
import fiap_substituva.domain.enums.DiasDaSemanaEnum;
import fiap_substituva.infrasctruture.controllers.horario.HorarioController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalTime;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class HorarioControllerTest {

    private MockMvc mockMvc;

    @Mock
    private HorarioUseCase horarioUseCase;

    @InjectMocks
    private HorarioController horarioController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(horarioController).build();
    }

    @Test
    void testBuscarPorEstabelecimento() throws Exception {
        Horario horario = new Horario(1L, DiasDaSemanaEnum.SEGUNDA, LocalTime.of(9, 0), LocalTime.of(18, 0), 2L);
        when(horarioUseCase.buscarHorariosPorIdEstabelecimento(2L)).thenReturn(List.of(horario));

        mockMvc.perform(get("/horarios/estabelecimentos/2"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].diaDaSemana").value("SEGUNDA"));


        verify(horarioUseCase, times(1)).buscarHorariosPorIdEstabelecimento(2L);
    }

    @Test
    void testCadastrar() throws Exception {
        Horario horario = new Horario(1L, DiasDaSemanaEnum.SEGUNDA, LocalTime.of(9, 0), LocalTime.of(18, 0), 2L);
        when(horarioUseCase.cadastraHorario(any(Horario.class))).thenReturn(horario);

        String requestBody = """
            {
                "id": 1,
                "diaDaSemana": "SEGUNDA",
                "inicio": "09:00:00",
                "fim": "18:00:00",
                "idEstabelecimento": 2
            }
            """;

        mockMvc.perform(post("/horarios")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.diaDaSemana").value("SEGUNDA"))
                .andExpect(jsonPath("$.idEstabelecimento").value(2));

        verify(horarioUseCase, times(1)).cadastraHorario(any(Horario.class));
    }

    @Test
    void testDeletarHorario() throws Exception {
        doNothing().when(horarioUseCase).excluirHorario(1L);

        mockMvc.perform(delete("/horarios/1"))
                .andExpect(status().isOk());

        verify(horarioUseCase, times(1)).excluirHorario(1L);
    }
}
