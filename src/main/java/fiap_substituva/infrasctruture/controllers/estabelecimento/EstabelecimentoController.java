package fiap_substituva.infrasctruture.controllers.estabelecimento;

import fiap_substituva.infrasctruture.controllers.clientes.ClienteDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("estabelecimentos")
public class EstabelecimentoController {

    @PostMapping
    public EstabelecimentoDTO criaEstabelecimento(@RequestBody EstabelecimentoDTO request) {

        return new EstabelecimentoDTO(
                request.getNome(),
                request.getCnpj(),
                request.getEndereco(),
                request.getTelefone()

        );
    }
}
