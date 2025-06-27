package fiap_substituva.configuration;

import fiap_substituva.application.gateways.UserGateway;
import fiap_substituva.application.usecases.CriarUsuarioUseCase;
import fiap_substituva.infrasctruture.controllers.UserDTOMapper;
import fiap_substituva.infrasctruture.gateways.UserEntityMapper;
import fiap_substituva.infrasctruture.gateways.UserRepositoryGateway;
import fiap_substituva.infrasctruture.persistence.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {
    @Bean
    CriarUsuarioUseCase createUserCase(UserGateway userGateway) {
        return new CriarUsuarioUseCase(userGateway);
    }

    @Bean
    UserGateway userGateway(UserRepository userRepository, UserEntityMapper userEntityMapper) {
        return new UserRepositoryGateway(userRepository, userEntityMapper);
    }

    @Bean
    UserEntityMapper userEntityMapper() {
        return new UserEntityMapper();
    }

    @Bean
    UserDTOMapper userDTOMapper() {
        return new UserDTOMapper();
    }
}