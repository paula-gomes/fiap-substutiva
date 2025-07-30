package fiap_substituva.application.usecases.cliente;


import fiap_substituva.application.gateways.ClienteGateway;
import fiap_substituva.application.usecases.cliente.ClienteUseCase;
import fiap_substituva.domain.Cliente;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ClienteUseCaseTest {

    @Mock
    private ClienteGateway clienteGateway;

    private ClienteUseCase clienteUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        clienteUseCase = new ClienteUseCase(clienteGateway);
    }

    @Test
    void testCriarCliente() {
        Cliente cliente = new Cliente("John Doe", "johndoe@example.com", "123456789", "12345678900");

        when(clienteGateway.criarCliente(cliente)).thenReturn(cliente);

        Cliente result = clienteUseCase.criarCliente(cliente);

        assertNotNull(result);
        assertEquals("John Doe", result.getNome());
        verify(clienteGateway, times(1)).criarCliente(cliente);
    }

    @Test
    void testBuscarTodosClientes() {

        List<Cliente> clientes = List.of(
                new Cliente("John Doe", "johndoe@example.com", "123456789", "12345678900"),
                new Cliente("Jane Doe", "janedoe@example.com", "987654321", "98765432100")
        );
        when(clienteGateway.buscarTodosClientes()).thenReturn(clientes);


        List<Cliente> result = clienteUseCase.buscarTodosClientes();


        assertNotNull(result);
        assertEquals(2, result.size());
        verify(clienteGateway, times(1)).buscarTodosClientes();
    }

    @Test
    void testBuscarClientePorCpf() {

        String cpf = "123456789";
        Cliente cliente = new Cliente("John Doe", "johndoe@example.com", "123456789", cpf);
        when(clienteGateway.buscarClientePorCpf(cpf)).thenReturn(Optional.of(cliente));

        Cliente result = clienteUseCase.buscarClientePorCpf(cpf);


        assertNotNull(result);
        assertEquals(cpf, result.getCpf());
        verify(clienteGateway, times(1)).buscarClientePorCpf(cpf);
    }

    @Test
    void testBuscarClientePorCpfThrowsExceptionForInvalidCpf() {

        String invalidCpf = "";

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            clienteUseCase.buscarClientePorCpf(invalidCpf);
        });
        assertEquals("CPF invalido ou vazio: ", exception.getMessage());
    }

    @Test
    void testBuscarClientePorCpfThrowsExceptionWhenNotFound() {

        String cpf = "12345678900";
        when(clienteGateway.buscarClientePorCpf(cpf)).thenReturn(Optional.empty());

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            clienteUseCase.buscarClientePorCpf(cpf);
        });
        assertEquals("Cliente nao encontrado com cpf: " + cpf, exception.getMessage());
    }
}