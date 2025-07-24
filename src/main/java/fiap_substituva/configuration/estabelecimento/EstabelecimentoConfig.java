package fiap_substituva.configuration.estabelecimento;

import fiap_substituva.application.gateways.ClienteGateway;
import fiap_substituva.application.gateways.EstabelecimentoGateway;
import fiap_substituva.application.usecases.clientes.ClienteUseCase;
import fiap_substituva.application.usecases.estabelecimento.EstabelecimentoUseCase;
import fiap_substituva.infrasctruture.gateways.clientes.ClienteRepositoryGateway;
import fiap_substituva.infrasctruture.gateways.estabelecimento.EstabelecimentoRepositoryGateway;
import fiap_substituva.infrasctruture.persistence.clientes.ClienteRepository;
import fiap_substituva.infrasctruture.persistence.estabelecimento.EstabelecimentoRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EstabelecimentoConfig {

    @Bean
    EstabelecimentoUseCase estabelecimentoUseCase(EstabelecimentoGateway estabelecimentoGateway) {
        return new EstabelecimentoUseCase(estabelecimentoGateway);
    }

    @Bean
    EstabelecimentoGateway estabelecimentoGateway(EstabelecimentoRepository estabelecimentoRepository) {

            return new EstabelecimentoRepositoryGateway(estabelecimentoRepository);
        }
}
