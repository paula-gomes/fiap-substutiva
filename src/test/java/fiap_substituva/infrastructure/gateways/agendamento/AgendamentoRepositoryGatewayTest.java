package fiap_substituva.infrastructure.gateways.agendamento;
import fiap_substituva.domain.Agendamento;
import fiap_substituva.domain.enums.StatusAgendamentoEnum;
import fiap_substituva.infrasctruture.gateways.agendamento.AgendamentoRepositoryGateway;
import fiap_substituva.infrasctruture.persistence.agendamento.AgendamentoEntity;
import fiap_substituva.infrasctruture.persistence.agendamento.AgendamentoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class AgendamentoRepositoryGatewayTest {

    @Mock
    private AgendamentoRepository agendamentoRepository;

    private AgendamentoRepositoryGateway agendamentoRepositoryGateway;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        agendamentoRepositoryGateway = new AgendamentoRepositoryGateway(agendamentoRepository);
    }

    @Test
    void testCriarAgendamento() {

         Agendamento agendamento = new Agendamento(
                1L, // id
                2L, // idProfissional
                3L, // idEstabelecimento
                4L, // idCliente
                5L, // idServico
                StatusAgendamentoEnum.CONFIRMADO, // status
                LocalDate.of(2023, 10, 1), // data
                LocalTime.of(9, 0), // horaInicio
                LocalTime.of(10, 0) // horaTermino
        );
        AgendamentoEntity savedEntity = new AgendamentoEntity(
                1L, // id
                2L, // idProfissional
                3L, // idEstabelecimento
                4L, // idCliente
                5L, // idServico
                StatusAgendamentoEnum.CONFIRMADO, // status
                LocalDate.of(2023, 10, 1), // data
                LocalTime.of(9, 0), // horaInicio
                LocalTime.of(10, 0) // horaTermino
        );

        when(agendamentoRepository.save(any(AgendamentoEntity.class))).thenReturn(savedEntity);

        Agendamento result = agendamentoRepositoryGateway.criarAgendamento(agendamento);


        assertNotNull(result);
        assertEquals(4L, result.getIdCliente());
        verify(agendamentoRepository, times(1)).save(any(AgendamentoEntity.class));
    }

    @Test
    void testListarAgendamentos() {

        List<AgendamentoEntity> agendamentoEntities = List.of(
                new AgendamentoEntity(
                        1L, // id
                        2L, // idProfissional
                        3L, // idEstabelecimento
                        4L, // idCliente
                        5L, // idServico
                        StatusAgendamentoEnum.CONFIRMADO, // status
                        LocalDate.of(2023, 10, 1), // data
                        LocalTime.of(9, 0), // horaInicio
                        LocalTime.of(10, 0) // horaTermino
                ),
                new AgendamentoEntity(
                        2L, // id
                        3L, // idProfissional
                        3L, // idEstabelecimento
                        4L, // idCliente
                        5L, // idServico
                        StatusAgendamentoEnum.CONFIRMADO, // status
                        LocalDate.of(2023, 10, 1), // data
                        LocalTime.of(9, 0), // horaInicio
                        LocalTime.of(10, 0) // horaTermino
                )
        );
        when(agendamentoRepository.findAll()).thenReturn(agendamentoEntities);


        List<Agendamento> result = agendamentoRepositoryGateway.listarAgendamentos();

        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals(4L, result.get(0).getIdCliente());
        verify(agendamentoRepository, times(1)).findAll();
    }

    @Test
    void testAtualizarAgendamento() {

        Long id = 1L;
        Agendamento agendamento = new Agendamento(
                id, // id
                2L, // idProfissional
                3L, // idEstabelecimento
                4L, // idCliente
                5L, // idServico
                StatusAgendamentoEnum.CONFIRMADO, // status
                LocalDate.of(2023, 10, 1), // data
                LocalTime.of(11, 0), // horaInicio
                LocalTime.of(12, 0) // horaTermino
        );
        AgendamentoEntity existingEntity = new AgendamentoEntity(
                id, // id
                2L, // idProfissional
                3L, // idEstabelecimento
                4L, // idCliente
                5L, // idServico
                StatusAgendamentoEnum.PENDENTE, // status
                LocalDate.of(2023, 10, 1), // data
                LocalTime.of(10, 0), // horaInicio
                LocalTime.of(11, 0) // horaTermino
        );
        AgendamentoEntity updatedEntity = new AgendamentoEntity(
                id, // id
                2L, // idProfissional
                3L, // idEstabelecimento
                4L, // idCliente
                5L, // idServico
                StatusAgendamentoEnum.CONFIRMADO, // status
                LocalDate.of(2023, 10, 1), // data
                LocalTime.of(11, 0), // horaInicio
                LocalTime.of(12, 0) // horaTermino
        );

        when(agendamentoRepository.findById(id)).thenReturn(Optional.of(existingEntity));
        when(agendamentoRepository.save(any(AgendamentoEntity.class))).thenReturn(updatedEntity);


        Agendamento result = agendamentoRepositoryGateway.atualizarAgendamento(id, agendamento);


        assertNotNull(result);
        assertEquals(StatusAgendamentoEnum.CONFIRMADO, result.getStatus());
        assertEquals(LocalTime.of(11, 0), result.getHoraInicio());
        assertEquals(LocalTime.of(12, 0), result.getHoraTermino());
        verify(agendamentoRepository, times(1)).findById(id);
        verify(agendamentoRepository, times(1)).save(any(AgendamentoEntity.class));
    }

    @Test
    void testExcluirAgendamentoNotFound() {
        // Arrange
        Long id = 1L;
        when(agendamentoRepository.existsById(id)).thenReturn(false);

        // Act & Assert
        RuntimeException exception = assertThrows(RuntimeException.class, () -> agendamentoRepositoryGateway.excluirAgendamento(id));
        assertEquals("Agendamento not found with id: " + id, exception.getMessage());
        verify(agendamentoRepository, times(1)).existsById(id);
        verify(agendamentoRepository, never()).deleteById(id);
    }
}
