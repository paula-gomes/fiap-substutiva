package fiap_substituva.infrastructure.persistence.cliente;

import fiap_substituva.infrasctruture.persistence.cliente.ClienteEntity;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ClienteEntityTest {
    @Test
    void testGettersAndSetters() {

        ClienteEntity cliente = new ClienteEntity();

        cliente.setId(1L);
        cliente.setCpf("12345678900");
        cliente.setNome("John Doe");
        cliente.setEmail("johndoe@example.com");
        cliente.setTelefone("123456789");

        assertThat(cliente.getId()).isEqualTo(1L);
        assertThat(cliente.getCpf()).isEqualTo("12345678900");
        assertThat(cliente.getNome()).isEqualTo("John Doe");
        assertThat(cliente.getEmail()).isEqualTo("johndoe@example.com");
        assertThat(cliente.getTelefone()).isEqualTo("123456789");
    }

    @Test
    void testAllArgsConstructor() {

        ClienteEntity cliente = new ClienteEntity(1L, "12345678900", "John Doe", "johndoe@example.com", "123456789");


        assertThat(cliente.getId()).isEqualTo(1L);
        assertThat(cliente.getCpf()).isEqualTo("12345678900");
        assertThat(cliente.getNome()).isEqualTo("John Doe");
        assertThat(cliente.getEmail()).isEqualTo("johndoe@example.com");
        assertThat(cliente.getTelefone()).isEqualTo("123456789");
    }

    @Test
    void testNoArgsConstructor() {

        ClienteEntity cliente = new ClienteEntity();

        assertThat(cliente).isNotNull();
        assertThat(cliente.getId()).isNull();
        assertThat(cliente.getCpf()).isNull();
        assertThat(cliente.getNome()).isNull();
        assertThat(cliente.getEmail()).isNull();
        assertThat(cliente.getTelefone()).isNull();
    }
}
