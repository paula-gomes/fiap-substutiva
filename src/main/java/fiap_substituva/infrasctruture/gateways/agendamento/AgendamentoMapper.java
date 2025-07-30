package fiap_substituva.infrasctruture.gateways.agendamento;

import fiap_substituva.domain.Agendamento;
import fiap_substituva.infrasctruture.persistence.agendamento.AgendamentoEntity;

public class AgendamentoMapper {

    // Converts Agendamento (domain) to AgendamentoEntity
    public static AgendamentoEntity toEntity(Agendamento agendamento) {
        if (agendamento == null) {
            return null;
        }
        return new AgendamentoEntity(
                agendamento.getId(),
                agendamento.getIdProfissional(),
                agendamento.getIdEstabelecimento(),
                agendamento.getIdCliente(),
                agendamento.getIdServico(),
                agendamento.getStatus(),
                agendamento.getData(),
                agendamento.getHoraInicio(),
                agendamento.getHoraTermino()
        );
    }

    // Converts AgendamentoEntity to Agendamento (domain)
    public static Agendamento toDomain(AgendamentoEntity entity) {
        if (entity == null) {
            return null;
        }
        return new Agendamento(
                entity.getId(),
                entity.getIdProfissional(),
                entity.getIdEstabelecimento(),
                entity.getIdCliente(),
                entity.getIdServico(),
                entity.getStatus(),
                entity.getData(),
                entity.getHoraInicio(),
                entity.getHoraTermino()
        );
    }
}