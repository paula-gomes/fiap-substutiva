package fiap_substituva.application.gateways;

import fiap_substituva.domain.Horario;

import java.util.List;

public interface HorarioGateway {
    List<Horario> buscarHorariosPorIdEstabelecimento(Long id);

    Horario cadastraHorario(Horario horario);

    void excluirHorario(Long id);
}
