package fiap_substituva.application.gateways;

import fiap_substituva.domain.Cliente;

import java.util.Optional;

public interface ClienteGateway {
    Cliente criarCliente(Cliente cliente);
    Optional<Cliente> buscarClientePorNome(String nome);

}
