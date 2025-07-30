package fiap_substituva.infrastructure.controllers.agendamento;
import fiap_substituva.application.usecases.agendamento.AgendamentoUseCase;
import fiap_substituva.domain.Agendamento;
import fiap_substituva.domain.enums.StatusAgendamentoEnum;
import fiap_substituva.infrasctruture.controllers.agendamento.AgendamentoController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class AgendamentoControllerTest {

    private MockMvc mockMvc;

    @Mock
    private AgendamentoUseCase agendamentoUseCase;

    @InjectMocks
    private AgendamentoController agendamentoController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(agendamentoController).build();
    }

    @Test
    void testCriarAgendamento() throws Exception {
        Agendamento agendamento = new Agendamento(1L, 2L, 3L, 4L, 5L, StatusAgendamentoEnum.CONFIRMADO, LocalDate.now(), LocalTime.of(10, 0), LocalTime.of(11, 0));
        when(agendamentoUseCase.criarAgendamento(any(Agendamento.class))).thenReturn(agendamento);

        String requestBody = """
            {
                "id": 1,
                "idProfissional": 2,
                "idEstabelecimento": 3,
                "idCliente": 4,
                "idServico": 5,
                "status": "CONFIRMADO",
                "data": "2023-10-01",
                "horaInicio": "10:00:00",
                "horaTermino": "11:00:00"
            }
            """;

        mockMvc.perform(post("/agendamentos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.idProfissional").value(2))
                .andExpect(jsonPath("$.idEstabelecimento").value(3))
                .andExpect(jsonPath("$.idCliente").value(4))
                .andExpect(jsonPath("$.idServico").value(5))
                .andExpect(jsonPath("$.status").value("CONFIRMADO"));

        verify(agendamentoUseCase, times(1)).criarAgendamento(any(Agendamento.class));
    }

    @Test
    void testListarAgendamentos() throws Exception {
        Agendamento agendamento = new Agendamento(1L, 2L, 3L, 4L, 5L, StatusAgendamentoEnum.CONFIRMADO, LocalDate.now(), LocalTime.of(10, 0), LocalTime.of(11, 0));
        when(agendamentoUseCase.listarAgendamentos()).thenReturn(List.of(agendamento));

        mockMvc.perform(get("/agendamentos"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].idProfissional").value(2))
                .andExpect(jsonPath("$[0].idEstabelecimento").value(3))
                .andExpect(jsonPath("$[0].idCliente").value(4))
                .andExpect(jsonPath("$[0].idServico").value(5))
                .andExpect(jsonPath("$[0].status").value("CONFIRMADO"));

        verify(agendamentoUseCase, times(1)).listarAgendamentos();
    }

    @Test
    void testAtualizarAgendamento() throws Exception {
        Agendamento agendamento = new Agendamento(1L, 2L, 3L, 4L, 5L, StatusAgendamentoEnum.CANCELADO, LocalDate.now(), LocalTime.of(10, 0), LocalTime.of(11, 0));
        when(agendamentoUseCase.atualizarAgendamento(eq(1L), any(Agendamento.class))).thenReturn(agendamento);

        String requestBody = """
            {
                "id": 1,
                "idProfissional": 2,
                "idEstabelecimento": 3,
                "idCliente": 4,
                "idServico": 5,
                "status": "CANCELADO",
                "data": "2023-10-01",
                "horaInicio": "10:00:00",
                "horaTermino": "11:00:00"
            }
            """;

        mockMvc.perform(put("/agendamentos/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.status").value("CANCELADO"));

        verify(agendamentoUseCase, times(1)).atualizarAgendamento(eq(1L), any(Agendamento.class));
    }

    @Test
    void testExcluirAgendamento() throws Exception {
        doNothing().when(agendamentoUseCase).excluirAgendamento(1L);

        mockMvc.perform(delete("/agendamentos/1"))
                .andExpect(status().isOk());

        verify(agendamentoUseCase, times(1)).excluirAgendamento(1L);
    }
}