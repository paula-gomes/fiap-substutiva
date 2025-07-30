package fiap_substituva.configuration.cliente;

import fiap_substituva.application.gateways.ClienteGateway;

import fiap_substituva.application.usecases.cliente.ClienteUseCase;

import fiap_substituva.infrasctruture.gateways.cliente.ClienteRepositoryGateway;
import fiap_substituva.infrasctruture.persistence.cliente.ClienteRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClienteConfig {

    @Bean
    ClienteUseCase clienteUseCase(ClienteGateway clienteGateway) {
        return new ClienteUseCase(clienteGateway);
    }

    @Bean
    ClienteGateway clienteGateway(ClienteRepository clienteRepository) {
        return new ClienteRepositoryGateway(clienteRepository);
    }
}