package fiap_substituva.configuration.horario;

import fiap_substituva.application.gateways.EstabelecimentoGateway;
import fiap_substituva.application.gateways.HorarioGateway;
import fiap_substituva.application.gateways.ProfissionalGateway;
import fiap_substituva.application.usecases.horario.HorarioUseCase;
import fiap_substituva.application.usecases.profissional.ProfissionalUseCase;
import fiap_substituva.infrasctruture.gateways.horario.HorarioRepositoryGateway;
import fiap_substituva.infrasctruture.gateways.profissional.ProfissionalRepositoryGateway;
import fiap_substituva.infrasctruture.persistence.horario.HorarioRepository;
import fiap_substituva.infrasctruture.persistence.profissional.ProfissionalRepository;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HorarioConfig {

    @Bean
    HorarioUseCase horarioUseCase(HorarioGateway horarioGateway) {
        return new HorarioUseCase(horarioGateway);
    }

    @Bean
    HorarioGateway horarioGateway(HorarioRepository horarioRepository, EstabelecimentoGateway estabelecimentoGateway) {
        return new HorarioRepositoryGateway(horarioRepository, estabelecimentoGateway);
    }

}
