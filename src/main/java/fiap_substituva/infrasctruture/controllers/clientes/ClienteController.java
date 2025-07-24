package fiap_substituva.infrasctruture.controllers.clientes;

import fiap_substituva.domain.Cliente;
import fiap_substituva.domain.User;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("clientes")
public class ClienteController {

    @PostMapping
    public ClienteDTO criaCliente(@RequestBody ClienteDTO request) {

        return new ClienteDTO(
                request.getNome(),
                request.getEmail(),
                request.getTelefone()

                );
    }
}