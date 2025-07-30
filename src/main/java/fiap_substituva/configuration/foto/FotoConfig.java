package fiap_substituva.configuration.foto;

import fiap_substituva.application.gateways.ClienteGateway;
import fiap_substituva.application.gateways.EstabelecimentoGateway;
import fiap_substituva.application.gateways.FotoGateway;
import fiap_substituva.application.usecases.foto.FotoUseCase;
import fiap_substituva.infrasctruture.gateways.foto.FotoRepositoryGateway;
import fiap_substituva.infrasctruture.persistence.foto.FotoRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FotoConfig {
    @Bean
    public FotoUseCase fotoUseCase(FotoGateway fotoGateway) {
        return new FotoUseCase(fotoGateway);

    }
    @Bean
    FotoGateway fotoGateway(FotoRepository fotoRepository, EstabelecimentoGateway estabelecimentoGateway) {
        return new FotoRepositoryGateway(fotoRepository, estabelecimentoGateway);
    }
}
