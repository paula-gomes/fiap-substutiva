package fiap_substituva.configuration.avaliacao;

import fiap_substituva.application.gateways.AvaliacaoGateway;
import fiap_substituva.application.usecases.avaliacao.AvaliacaoUseCase;
import fiap_substituva.infrasctruture.gateways.avaliacao.AvaliacaoRepositoryGateway;
import fiap_substituva.infrasctruture.persistence.avaliacao.AvaliacaoRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AvaliacaoConfig {
    @Bean
    public AvaliacaoUseCase avaliacaoUseCase(AvaliacaoGateway avaliacaoGateway) {
        return new AvaliacaoUseCase(avaliacaoGateway);
    }
    @Bean
    AvaliacaoGateway avaliacaoGateway(AvaliacaoRepository avaliacaoRepository) {
        return new AvaliacaoRepositoryGateway(avaliacaoRepository);
    }
}
