package fiap_substituva.application.configuration.avaliacao;

import fiap_substituva.application.gateways.AvaliacaoGateway;
import fiap_substituva.application.usecases.avaliacao.AvaliacaoUseCase;
import fiap_substituva.infrasctruture.gateways.avaliacao.AvaliacaoRepositoryGateway;
import fiap_substituva.infrasctruture.persistence.avaliacao.AvaliacaoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class AvaliacaoConfigTest {

    @Autowired
    private AvaliacaoUseCase avaliacaoUseCase;

    @Autowired
    private AvaliacaoGateway avaliacaoGateway;

    @Autowired
    private AvaliacaoRepository avaliacaoRepository;

    @Test
    void testBeansAreLoaded() {

        assertThat(avaliacaoUseCase).isNotNull();
        assertThat(avaliacaoGateway).isNotNull();
        assertThat(avaliacaoGateway).isInstanceOf(AvaliacaoRepositoryGateway.class);
        assertThat(avaliacaoRepository).isNotNull();
    }
}