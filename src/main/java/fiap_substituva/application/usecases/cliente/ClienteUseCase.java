package fiap_substituva.application.usecases.cliente;

import fiap_substituva.application.gateways.ClienteGateway;
import fiap_substituva.domain.Cliente;

import java.util.List;

public class ClienteUseCase {
    private final ClienteGateway clienteGateway;

    public ClienteUseCase(ClienteGateway clienteGateway) {
        this.clienteGateway = clienteGateway;
    }


    public Cliente criarCliente(Cliente cliente){
        return clienteGateway.criarCliente(cliente);
    }
    public List<Cliente> buscarTodosClientes() {
        return clienteGateway.buscarTodosClientes();
    }

    public Cliente buscarClientePorCpf(String cpf) {
        if (cpf == null || cpf.isEmpty()) {
            throw new IllegalArgumentException("CPF invalido ou vazio: " + cpf);
        }
        return clienteGateway.buscarClientePorCpf(cpf)
                .orElseThrow(() -> new RuntimeException("Cliente nao encontrado com cpf: " + cpf));
    }
}
