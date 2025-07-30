package fiap_substituva.infrastructure.gateways.horario;
import fiap_substituva.application.gateways.EstabelecimentoGateway;
import fiap_substituva.domain.Estabelecimento;
import fiap_substituva.domain.Horario;
import fiap_substituva.domain.enums.DiasDaSemanaEnum;
import fiap_substituva.infrasctruture.exception.CustomException;
import fiap_substituva.infrasctruture.gateways.horario.HorarioRepositoryGateway;
import fiap_substituva.infrasctruture.persistence.horario.HorarioEntity;
import fiap_substituva.infrasctruture.persistence.horario.HorarioRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class HorarioRepositoryGatewayTest {

    @Mock
    private HorarioRepository horarioRepository;

    @Mock
    private EstabelecimentoGateway estabelecimentoGateway;

    @InjectMocks
    private HorarioRepositoryGateway horarioRepositoryGateway;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void buscarHorariosPorIdEstabelecimento_DeveRetornarListaDeHorarios() {
        HorarioEntity horarioEntity = new HorarioEntity(1L, DiasDaSemanaEnum.SEGUNDA, LocalTime.of(9, 0), LocalTime.of(18, 0), 1L);
        when(horarioRepository.findByEstabelecimentoId(1L)).thenReturn(List.of(horarioEntity));

        List<Horario> horarios = horarioRepositoryGateway.buscarHorariosPorIdEstabelecimento(1L);

        assertNotNull(horarios);
        assertEquals(1, horarios.size());
        assertEquals(1L, horarios.get(0).getId());
        verify(horarioRepository, times(1)).findByEstabelecimentoId(1L);
    }

    @Test
    void cadastraHorario_DeveCadastrarHorarioComSucesso() {
        Horario horario = new Horario(null, DiasDaSemanaEnum.SEGUNDA, LocalTime.of(9, 0), LocalTime.of(18, 0), 1L);
        Estabelecimento estabelecimento = new Estabelecimento("Nome", "123456789", "Endereco", "123456789", List.of("Servico1"), List.of("Profissional1"), List.of("Foto1"));
        HorarioEntity horarioEntity = new HorarioEntity(null, DiasDaSemanaEnum.SEGUNDA, LocalTime.of(9, 0), LocalTime.of(18, 0), 1L);
        HorarioEntity savedEntity = new HorarioEntity(1L, DiasDaSemanaEnum.SEGUNDA, LocalTime.of(9, 0), LocalTime.of(18, 0), 1L);

        when(estabelecimentoGateway.buscarEstabelecimentoPorId(1L)).thenReturn(estabelecimento);
        when(horarioRepository.save(any(HorarioEntity.class))).thenReturn(savedEntity);

        Horario result = horarioRepositoryGateway.cadastraHorario(horario);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        verify(horarioRepository, times(1)).save(any(HorarioEntity.class));
    }

    @Test
    void cadastraHorario_DeveLancarExcecaoQuandoHorarioForNulo() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            horarioRepositoryGateway.cadastraHorario(null);
        });

        assertEquals("Horario or Estabelecimento ID cannot be null", exception.getMessage());
    }

    @Test
    void cadastraHorario_DeveLancarExcecaoQuandoEstabelecimentoNaoExistir() {
        Horario horario = new Horario(null, DiasDaSemanaEnum.SEGUNDA, LocalTime.of(9, 0), LocalTime.of(18, 0), 1L);

        when(estabelecimentoGateway.buscarEstabelecimentoPorId(1L)).thenReturn(null);

        CustomException exception = assertThrows(CustomException.class, () -> {
            horarioRepositoryGateway.cadastraHorario(horario);
        });

        assertEquals(HttpStatus.NOT_FOUND, exception.getStatus());
        assertEquals("Estabelecimento not found", exception.getMessage());
    }

    @Test
    void excluirHorario_DeveExcluirHorarioComSucesso() {
        when(horarioRepository.existsById(1L)).thenReturn(true);

        horarioRepositoryGateway.excluirHorario(1L);

        verify(horarioRepository, times(1)).deleteById(1L);
    }

    @Test
    void excluirHorario_DeveLancarExcecaoQuandoIdForNulo() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            horarioRepositoryGateway.excluirHorario(null);
        });

        assertEquals("ID cannot be null", exception.getMessage());
    }

    @Test
    void excluirHorario_DeveLancarExcecaoQuandoHorarioNaoExistir() {
        when(horarioRepository.existsById(1L)).thenReturn(false);

        CustomException exception = assertThrows(CustomException.class, () -> {
            horarioRepositoryGateway.excluirHorario(1L);
        });

        assertEquals(HttpStatus.NOT_FOUND, exception.getStatus());
        assertEquals("Horario not found", exception.getMessage());
    }
}