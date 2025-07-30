package fiap_substituva.infrasctruture.controllers.cliente;

import fiap_substituva.application.usecases.cliente.ClienteUseCase;
import fiap_substituva.domain.Cliente;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("clientes")
public class ClienteController {

    private final ClienteUseCase clienteUseCase;

    public ClienteController(ClienteUseCase clienteUseCase) {
        this.clienteUseCase = clienteUseCase;
    }


    @GetMapping("/{cpf}")
    public ClienteDTO getClientePorCpf(@PathVariable String cpf) {
        Cliente cliente = clienteUseCase.buscarClientePorCpf(cpf);
        return new ClienteDTO(
                cliente.getNome(),
                cliente.getEmail(),
                cliente.getCpf(),
                cliente.getTelefone()
        );
    }
    @GetMapping
    public List<ClienteDTO> getTodosClientes() {
        return clienteUseCase.buscarTodosClientes()
                .stream()
                .map(cliente -> new ClienteDTO(
                        cliente.getNome(),
                        cliente.getEmail(),
                        cliente.getCpf(),
                        cliente.getTelefone()
                ))
                .toList();
    }

    @PostMapping
    public ClienteDTO criaCliente(@RequestBody ClienteDTO request) {
        Cliente cliente = new Cliente(
                request.getNome(),
                request.getEmail(),
                request.getTelefone(),
                request.getCpf()
        );
        Cliente savedCliente = clienteUseCase.criarCliente(cliente);
        return new ClienteDTO(
                savedCliente.getNome(),
                savedCliente.getEmail(),
                savedCliente.getCpf(),
                savedCliente.getTelefone()
        );
    }
}