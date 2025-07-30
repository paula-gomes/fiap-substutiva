package fiap_substituva.application.gateways;

import fiap_substituva.domain.Agendamento;

import java.util.List;

public interface AgendamentoGateway {
    Agendamento criarAgendamento(Agendamento agendamento);

    List<Agendamento> listarAgendamentos();

    Agendamento atualizarAgendamento(Long id, Agendamento agendamento);

    void excluirAgendamento(Long id);
}
