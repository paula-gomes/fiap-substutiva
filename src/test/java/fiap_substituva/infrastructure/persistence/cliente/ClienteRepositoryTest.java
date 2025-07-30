package fiap_substituva.infrastructure.persistence.cliente;

import fiap_substituva.infrasctruture.persistence.cliente.ClienteEntity;
import fiap_substituva.infrasctruture.persistence.cliente.ClienteRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
public class ClienteRepositoryTest {

    @Autowired
    private ClienteRepository clienteRepository;

    @Test
    @DisplayName("Should find a client by CPF")
    void testFindByCpf() {
        // Arrange: Create and save a ClienteEntity
        ClienteEntity cliente = new ClienteEntity();
        cliente.setCpf("12345678900");
        cliente.setNome("John Doe");
        cliente.setTelefone("123456789");
        clienteRepository.save(cliente);


        Optional<ClienteEntity> foundCliente = clienteRepository.findByCpf("12345678900");


        assertThat(foundCliente).isPresent();
        assertThat(foundCliente.get().getNome()).isEqualTo("John Doe");
    }

    @Test
    @DisplayName("Should return empty when CPF does not exist")
    void testFindByCpfNotFound() {
        // Act: Search for a non-existent CPF
        Optional<ClienteEntity> foundCliente = clienteRepository.findByCpf("00000000000");

        // Assert: Verify no client was found
        assertThat(foundCliente).isEmpty();
    }
}