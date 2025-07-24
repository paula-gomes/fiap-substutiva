package fiap_substituva.application.usecases.clientes;

import fiap_substituva.application.gateways.ClienteGateway;
import fiap_substituva.application.gateways.UserGateway;
import fiap_substituva.domain.Cliente;
import fiap_substituva.domain.User;

public class ClienteUseCase {
    private final ClienteGateway clienteGateway;

    public ClienteUseCase(ClienteGateway clienteGateway) {
        this.clienteGateway = clienteGateway;
    }


    public Cliente criarCliente(Cliente cliente){
        return clienteGateway.criarCliente(cliente);
    }

    public Cliente buscarClientePorNome(String nome) {
        if (nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("Nome must not be null or empty");
        }
        return clienteGateway.buscarClientePorNome(nome)
                .orElseThrow(() -> new RuntimeException("Cliente not found with Nome: " + nome));
    }
}
