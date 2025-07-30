package fiap_substituva.infrastructure.gateways.cliente;
import fiap_substituva.domain.Cliente;
import fiap_substituva.infrasctruture.gateways.cliente.ClienteRepositoryGateway;
import fiap_substituva.infrasctruture.persistence.cliente.ClienteEntity;
import fiap_substituva.infrasctruture.persistence.cliente.ClienteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ClienteRepositoryGatewayTest {

    @Mock
    private ClienteRepository clienteRepository;

    private ClienteRepositoryGateway clienteRepositoryGateway;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        clienteRepositoryGateway = new ClienteRepositoryGateway(clienteRepository);
    }

    @Test
    void testCriarCliente() {
        // Arrange
        Cliente cliente = new Cliente("John Doe", "johndoe@example.com", "12345678900", "123456789");
        ClienteEntity savedEntity = new ClienteEntity(1L, "12345678900", "John Doe", "johndoe@example.com", "123456789");

        when(clienteRepository.save(any(ClienteEntity.class))).thenReturn(savedEntity);

        // Act
        Cliente result = clienteRepositoryGateway.criarCliente(cliente);

        // Assert
        assertNotNull(result);
        assertEquals("John Doe", result.getNome());
        assertEquals("12345678900", result.getCpf());
        verify(clienteRepository, times(1)).save(any(ClienteEntity.class));
    }
    @Test
    void testBuscarTodosClientes() {
        // Arrange
        List<ClienteEntity> clienteEntities = List.of(
                new ClienteEntity(1L, "12345678900", "John Doe", "johndoe@example.com", "123456789"),
                new ClienteEntity(2L, "98765432100", "Jane Doe", "janedoe@example.com", "987654321")
        );
        when(clienteRepository.findAll()).thenReturn(clienteEntities);

        // Act
        List<Cliente> result = clienteRepositoryGateway.buscarTodosClientes();

        // Assert
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("John Doe", result.get(0).getNome());
        verify(clienteRepository, times(1)).findAll();
    }

    @Test
    void testBuscarClientePorCpf() {
        // Arrange
        String cpf = "12345678900";
        ClienteEntity clienteEntity = new ClienteEntity(1L, cpf, "John Doe", "johndoe@example.com", "12345678900");
        when(clienteRepository.findByCpf(cpf)).thenReturn(Optional.of(clienteEntity));

        // Act
        Optional<Cliente> result = clienteRepositoryGateway.buscarClientePorCpf(cpf);

        // Assert
        assertTrue(result.isPresent());
        assertEquals(cpf, result.get().getCpf());
        verify(clienteRepository, times(1)).findByCpf(cpf);
    }

    @Test
    void testBuscarClientePorCpfNotFound() {
        // Arrange
        String cpf = "12345678900";
        when(clienteRepository.findByCpf(cpf)).thenReturn(Optional.empty());

        // Act
        Optional<Cliente> result = clienteRepositoryGateway.buscarClientePorCpf(cpf);

        // Assert
        assertFalse(result.isPresent());
        verify(clienteRepository, times(1)).findByCpf(cpf);
    }
}