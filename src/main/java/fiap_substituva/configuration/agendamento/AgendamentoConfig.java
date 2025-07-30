package fiap_substituva.configuration.agendamento;

import fiap_substituva.application.gateways.AgendamentoGateway;
import fiap_substituva.application.gateways.ClienteGateway;
import fiap_substituva.application.usecases.agendamento.AgendamentoUseCase;
import fiap_substituva.infrasctruture.gateways.agendamento.AgendamentoRepositoryGateway;
import fiap_substituva.infrasctruture.gateways.cliente.ClienteRepositoryGateway;
import fiap_substituva.infrasctruture.persistence.agendamento.AgendamentoRepository;
import fiap_substituva.infrasctruture.persistence.cliente.ClienteRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AgendamentoConfig {
    @Bean
    public AgendamentoUseCase agendamentoUseCase(AgendamentoGateway agendamentoGateway) {
        return new AgendamentoUseCase(agendamentoGateway);
    }
    @Bean
    AgendamentoGateway agendamentoGateway(AgendamentoRepository agendamentoRepository) {
        return new AgendamentoRepositoryGateway(agendamentoRepository);
    }
}
