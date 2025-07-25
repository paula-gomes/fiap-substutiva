package fiap_substituva.application.gateways;

import fiap_substituva.domain.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteGateway {
    Cliente criarCliente(Cliente cliente);
    List<Cliente> buscarTodosClientes();
    Optional<Cliente> buscarClientePorCpf(String cpf);

}
