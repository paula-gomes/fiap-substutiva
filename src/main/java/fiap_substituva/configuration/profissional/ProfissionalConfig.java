package fiap_substituva.configuration.profissional;

import fiap_substituva.application.gateways.EstabelecimentoGateway;
import fiap_substituva.application.gateways.ProfissionalGateway;
import fiap_substituva.application.usecases.estabelecimento.EstabelecimentoUseCase;
import fiap_substituva.application.usecases.profissional.ProfissionalUseCase;
import fiap_substituva.infrasctruture.gateways.estabelecimento.EstabelecimentoRepositoryGateway;
import fiap_substituva.infrasctruture.gateways.profissional.ProfissionalRepositoryGateway;
import fiap_substituva.infrasctruture.persistence.estabelecimento.EstabelecimentoRepository;
import fiap_substituva.infrasctruture.persistence.profissional.ProfissionalRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProfissionalConfig {

    @Bean
    ProfissionalUseCase profissionalUseCase(ProfissionalGateway profissionalGateway) {
        return new ProfissionalUseCase(profissionalGateway);
    }

    @Bean
    ProfissionalGateway profissionalGateway(ProfissionalRepository profissionalRepository) {

        return new ProfissionalRepositoryGateway(profissionalRepository);
    }
}
