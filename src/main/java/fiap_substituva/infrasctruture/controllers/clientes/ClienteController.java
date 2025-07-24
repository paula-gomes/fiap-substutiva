package fiap_substituva.infrasctruture.controllers.clientes;

import fiap_substituva.application.usecases.clientes.ClienteUseCase;
import fiap_substituva.domain.Cliente;
import fiap_substituva.domain.User;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("clientes")
public class ClienteController {

    private final ClienteUseCase clienteUseCase;

    public ClienteController(ClienteUseCase clienteUseCase) {
        this.clienteUseCase = clienteUseCase;
    }


    @GetMapping("/{nome}")
    public ClienteDTO getClientePorNome(@PathVariable String nome) {
        Cliente cliente = clienteUseCase.buscarClientePorNome(nome);
        return new ClienteDTO(
                cliente.getNome(),
                cliente.getEmail(),
                cliente.getTelefone()
        );
    }

    @PostMapping
    public ClienteDTO criaCliente(@RequestBody ClienteDTO request) {

        return new ClienteDTO(
                request.getNome(),
                request.getEmail(),
                request.getTelefone()

                );
    }
}