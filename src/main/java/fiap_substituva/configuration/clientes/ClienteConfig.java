package fiap_substituva.configuration.clientes;

import fiap_substituva.application.gateways.ClienteGateway;

import fiap_substituva.application.usecases.clientes.ClienteUseCase;

import fiap_substituva.infrasctruture.gateways.clientes.ClienteRepositoryGateway;
import fiap_substituva.infrasctruture.persistence.clientes.ClienteRepository;
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