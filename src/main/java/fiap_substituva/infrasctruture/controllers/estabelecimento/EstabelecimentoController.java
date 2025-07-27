package fiap_substituva.infrasctruture.controllers.estabelecimento;

import fiap_substituva.application.usecases.estabelecimento.EstabelecimentoUseCase;

import fiap_substituva.domain.Cliente;
import fiap_substituva.domain.Estabelecimento;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("estabelecimentos")
public class EstabelecimentoController {
    private final EstabelecimentoUseCase estabelecimentoUseCase;

    public EstabelecimentoController(EstabelecimentoUseCase estabelecimentoUseCase) {
        this.estabelecimentoUseCase = estabelecimentoUseCase;
    }

    @PostMapping
    public EstabelecimentoDTO criarEstabelecimento(@RequestBody EstabelecimentoDTO request) {
        Estabelecimento estabelecimento = new Estabelecimento(
                request.getNome(),
                request.getCnpj(),
                request.getEndereco(),
                request.getTelefone(),
                request.getServicos(),
                request.getProfissionais(),
                request.getHorariosFuncionamento(),
                request.getFotos()
        );
        Estabelecimento savedEstabelecimento = estabelecimentoUseCase.criarEstabelecimento(estabelecimento);
        return new EstabelecimentoDTO(
                savedEstabelecimento.getNome(),
                savedEstabelecimento.getCnpj(),
                savedEstabelecimento.getEndereco(),
                savedEstabelecimento.getTelefone(),
                savedEstabelecimento.getServicos(),
                savedEstabelecimento.getProfissionais(),
                savedEstabelecimento.getHorariosFuncionamento(),
                savedEstabelecimento.getFotos()
        );
    }
}
