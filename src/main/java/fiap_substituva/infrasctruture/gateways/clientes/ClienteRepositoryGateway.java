package fiap_substituva.infrasctruture.gateways.clientes;

import fiap_substituva.application.gateways.ClienteGateway;
import fiap_substituva.domain.Cliente;

import fiap_substituva.infrasctruture.controllers.clientes.ClienteDTO;

import fiap_substituva.infrasctruture.persistence.clientes.ClienteEntity;
import fiap_substituva.infrasctruture.persistence.clientes.ClienteRepository;

import java.util.Optional;

public class ClienteRepositoryGateway implements ClienteGateway {

    private final ClienteRepository clienteRepository;

    public ClienteRepositoryGateway(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public Cliente criarCliente(Cliente cliente) {
        ClienteEntity clienteEntity = new ClienteEntity();
        clienteEntity.setNome(cliente.getNome());
        clienteEntity.setEmail(cliente.getEmail());
        clienteEntity.setTelefone(cliente.getTelefone());

        ClienteEntity savedEntity = clienteRepository.save(clienteEntity);

        return new Cliente(
                savedEntity.getNome(),
                savedEntity.getEmail(),
                savedEntity.getTelefone()
        );
    }

    @Override
    public Optional<Cliente> buscarClientePorNome(String nome) {
        return clienteRepository.findByNome(nome)
                .map(clienteEntity -> new Cliente(
                        clienteEntity.getNome(),
                        clienteEntity.getEmail(),
                        clienteEntity.getTelefone()
                ));
    }
}
