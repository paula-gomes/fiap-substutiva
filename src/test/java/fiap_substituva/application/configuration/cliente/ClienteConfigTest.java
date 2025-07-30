package fiap_substituva.application.configuration.cliente;


import fiap_substituva.application.gateways.ClienteGateway;
import fiap_substituva.application.usecases.cliente.ClienteUseCase;
import fiap_substituva.infrasctruture.gateways.cliente.ClienteRepositoryGateway;
import fiap_substituva.infrasctruture.persistence.cliente.ClienteRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class ClienteConfigTest {

    @Autowired
    private ClienteUseCase clienteUseCase;

    @Autowired
    private ClienteGateway clienteGateway;

    @Autowired
    private ClienteRepository clienteRepository;

    @Test
    void testBeansAreLoaded() {

        assertThat(clienteUseCase).isNotNull();
        assertThat(clienteGateway).isNotNull();
        assertThat(clienteGateway).isInstanceOf(ClienteRepositoryGateway.class);
        assertThat(clienteRepository).isNotNull();
    }
}
