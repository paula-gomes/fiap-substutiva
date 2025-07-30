package fiap_substituva.configuration.servico;

import fiap_substituva.application.gateways.EstabelecimentoGateway;
import fiap_substituva.application.gateways.ServicoGateway;
import fiap_substituva.application.usecases.servico.ServicoUseCase;
import fiap_substituva.infrasctruture.gateways.servico.ServicoRepositoryGateway;
import fiap_substituva.infrasctruture.persistence.servico.ServicoRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServicoConfig {
    @Bean
    ServicoUseCase servicoUseCase(ServicoGateway servicoGateway) {
        return new ServicoUseCase(servicoGateway);
    }

    @Bean
    ServicoGateway servicoGateway(ServicoRepository servicoRepository, EstabelecimentoGateway estabelecimentoGateway) {
        return new ServicoRepositoryGateway(servicoRepository, estabelecimentoGateway);
    }
}
