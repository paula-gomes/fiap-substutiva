package fiap_substituva.application.usecases.horario;

import fiap_substituva.application.gateways.HorarioGateway;
import fiap_substituva.domain.Horario;


import java.util.List;

public class HorarioUseCase {
    private final HorarioGateway horarioGateway;

    public HorarioUseCase(HorarioGateway horarioGateway) {
        this.horarioGateway = horarioGateway;
    }

    public List<Horario> buscarHorariosPorIdEstabelecimento(Long id) {
        return horarioGateway.buscarHorariosPorIdEstabelecimento(id);
    }

    public Horario cadastraHorario(Horario horario) {
        return horarioGateway.cadastraHorario(horario);
    }

    public void excluirHorario(Long id) {
        horarioGateway.excluirHorario(id);
    }
}
