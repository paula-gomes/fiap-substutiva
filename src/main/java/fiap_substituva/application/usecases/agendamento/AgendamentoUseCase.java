package fiap_substituva.application.usecases.agendamento;

import fiap_substituva.application.gateways.AgendamentoGateway;
import fiap_substituva.domain.Agendamento;

import java.util.List;

public class AgendamentoUseCase {
    private final AgendamentoGateway agendamentoGateway;

    public AgendamentoUseCase(AgendamentoGateway agendamentoGateway) {
        this.agendamentoGateway = agendamentoGateway;
    }


    public Agendamento criarAgendamento(Agendamento agendamento) {
        if (agendamento == null) {
            throw new IllegalArgumentException("Agendamento cannot be null");
        }
        return agendamentoGateway.criarAgendamento(agendamento);
    }

    public List<Agendamento> listarAgendamentos() {
        return agendamentoGateway.listarAgendamentos();
    }

    public Agendamento atualizarAgendamento(Long id, Agendamento agendamento) {
        if (id == null || agendamento == null) {
            throw new IllegalArgumentException("ID or Agendamento cannot be null");
        }
        return agendamentoGateway.atualizarAgendamento(id, agendamento);
    }

    public void excluirAgendamento(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("ID cannot be null");
        }
        agendamentoGateway.excluirAgendamento(id);
    }
}

