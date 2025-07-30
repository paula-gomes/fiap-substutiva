package fiap_substituva.infrasctruture.controllers.avaliacao;

import fiap_substituva.application.usecases.avaliacao.AvaliacaoUseCase;
import fiap_substituva.domain.Avaliacao;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/avaliacoes")
public class AvaliacaoController {
    private final AvaliacaoUseCase avaliacaoUseCase;

    public AvaliacaoController(AvaliacaoUseCase avaliacaoUseCase) {
        this.avaliacaoUseCase = avaliacaoUseCase;
    }


    @PostMapping("/profissionais")
    public AvaliacaoDTO criarAvaliacaoProfissional(@RequestBody AvaliacaoDTO avaliacaoProfissional) {
        Avaliacao createdAvaliacao = avaliacaoUseCase.criarAvaliacaoProfissional(
                new Avaliacao(
                        avaliacaoProfissional.getId(),
                        avaliacaoProfissional.getIdCliente(),
                        avaliacaoProfissional.getEstrelas(),
                        avaliacaoProfissional.getComentario(),
                        avaliacaoProfissional.getIdEstabelecimento(),
                        avaliacaoProfissional.getIdProfissional()
                )
        );

        return new AvaliacaoDTO(
                createdAvaliacao.getId(),
                createdAvaliacao.getIdCliente(),
                createdAvaliacao.getEstrelas(),
                createdAvaliacao.getComentario(),
                createdAvaliacao.getIdEstabelecimento(),
                createdAvaliacao.getIdProfissional()
        );
    }

    @PostMapping("/estabelecimentos")
    public AvaliacaoDTO criarAvaliacaoEstabelecimento(@RequestBody AvaliacaoDTO avaliacaoEstabelecimento) {
        Avaliacao createdAvaliacao = avaliacaoUseCase.criarAvaliacaoEstabelecimento(
                new Avaliacao(
                        avaliacaoEstabelecimento.getId(),
                        avaliacaoEstabelecimento.getIdCliente(),
                        avaliacaoEstabelecimento.getEstrelas(),
                        avaliacaoEstabelecimento.getComentario(),
                        avaliacaoEstabelecimento.getIdEstabelecimento(),
                        avaliacaoEstabelecimento.getIdProfissional()
                )
        );

        return new AvaliacaoDTO(
                createdAvaliacao.getId(),
                createdAvaliacao.getIdCliente(),
                createdAvaliacao.getEstrelas(),
                createdAvaliacao.getComentario(),
                createdAvaliacao.getIdEstabelecimento(),
                createdAvaliacao.getIdProfissional()
        );
    }

    @GetMapping("/profissionais/{id}")
    public List<AvaliacaoDTO> listarAvaliacoesProfissionais(@PathVariable Long id) {
        List<Avaliacao> avaliacoes = avaliacaoUseCase.listarAvaliacoesProfissionais(id);
        return avaliacoes.stream()
                .map(avaliacao -> new AvaliacaoDTO(
                        avaliacao.getId(),
                        avaliacao.getIdCliente(),
                        avaliacao.getEstrelas(),
                        avaliacao.getComentario(),
                        avaliacao.getIdEstabelecimento(),
                        avaliacao.getIdProfissional()
                ))
                .toList();
    }
    @GetMapping("/estabelecimentos/{id}")
    public List<AvaliacaoDTO> listarAvaliacoesEstabelecimentos(@PathVariable Long id) {
        List<Avaliacao> avaliacoes = avaliacaoUseCase.listarAvaliacoesEstabelecimentos(id);
        return avaliacoes.stream()
                .map(avaliacao -> new AvaliacaoDTO(
                        avaliacao.getId(),
                        avaliacao.getIdCliente(),
                        avaliacao.getEstrelas(),
                        avaliacao.getComentario(),
                        avaliacao.getIdEstabelecimento(),
                        avaliacao.getIdProfissional()
                ))
                .toList();
    }
}

