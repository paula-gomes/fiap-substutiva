package fiap_substituva.infrasctruture.controllers.estabelecimento;

import fiap_substituva.application.usecases.estabelecimento.EstabelecimentoUseCase;

import fiap_substituva.domain.Cliente;
import fiap_substituva.domain.Estabelecimento;
import fiap_substituva.domain.Profissional;
import fiap_substituva.infrasctruture.controllers.profissional.ProfissionalDTO;
import fiap_substituva.infrasctruture.exception.CustomException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("estabelecimentos")
public class EstabelecimentoController {
    private final EstabelecimentoUseCase estabelecimentoUseCase;

    public EstabelecimentoController(EstabelecimentoUseCase estabelecimentoUseCase) {
        this.estabelecimentoUseCase = estabelecimentoUseCase;
    }

    @GetMapping("/{nome}")
    public EstabelecimentoDTO buscarEstabelecimentoPorNome(@PathVariable String nome) {

        Estabelecimento estabelecimento = estabelecimentoUseCase.buscarEstabelecimentoPorNome(nome);

        if (estabelecimento == null) {
            throw new CustomException(HttpStatus.NOT_FOUND,"Estabelecimento not found with nome: " + nome);
        }
        return new EstabelecimentoDTO(
                estabelecimento.getNome(),
                estabelecimento.getCnpj(),
                estabelecimento.getEndereco(),
                estabelecimento.getTelefone(),
                estabelecimento.getServicos(),
                estabelecimento.getProfissionais(),
                estabelecimento.getFotos()
        );
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
                savedEstabelecimento.getFotos()
        );
    }
    @PutMapping
    public EstabelecimentoDTO editarEstabelecimento(@RequestBody EstabelecimentoDTO estabelecimentoDTO) {

        Estabelecimento estabelecimento = new Estabelecimento(
                estabelecimentoDTO.getNome(),
                estabelecimentoDTO.getCnpj(),
                estabelecimentoDTO.getEndereco(),
                estabelecimentoDTO.getTelefone(),
                estabelecimentoDTO.getServicos(),
                estabelecimentoDTO.getProfissionais(),
                estabelecimentoDTO.getFotos()
        );


        Estabelecimento updatedEstabelecimento = estabelecimentoUseCase.editarEstabelecimento(estabelecimento);

        if (updatedEstabelecimento == null) {
            throw new CustomException(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to update Estabelecimento");
        }
        return new EstabelecimentoDTO(
                updatedEstabelecimento.getNome(),
                updatedEstabelecimento.getCnpj(),
                updatedEstabelecimento.getEndereco(),
                updatedEstabelecimento.getTelefone(),
                updatedEstabelecimento.getServicos(),
                updatedEstabelecimento.getProfissionais(),
                updatedEstabelecimento.getFotos()
        );
    }

}