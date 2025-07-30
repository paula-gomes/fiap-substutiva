package fiap_substituva.application.usecases.avaliacao;

import fiap_substituva.application.gateways.AvaliacaoGateway;
import fiap_substituva.domain.Avaliacao;

import java.util.List;

public class AvaliacaoUseCase {
    private final AvaliacaoGateway avaliacaoGateway;

    public AvaliacaoUseCase(AvaliacaoGateway avaliacaoGateway) {
        this.avaliacaoGateway = avaliacaoGateway;
    }


    public Avaliacao criarAvaliacaoProfissional(Avaliacao avaliacao) {

        if (avaliacao == null) {
            throw new IllegalArgumentException("Avaliacao cannot be null");
        }
        return avaliacaoGateway.criarAvaliacaoProfissional(avaliacao);
    }

    public Avaliacao criarAvaliacaoEstabelecimento(Avaliacao avaliacao) {
        if (avaliacao == null) {
            throw new IllegalArgumentException("Avaliacao cannot be null");
        }
        return avaliacaoGateway.criarAvaliacaoEstabelecimento(avaliacao);
    }

    public List<Avaliacao> listarAvaliacoesProfissionais(Long id){
        return avaliacaoGateway.listarAvaliacoesProfissionais(id);
    }

    public List<Avaliacao> listarAvaliacoesEstabelecimentos(Long id) {
        return avaliacaoGateway.listarAvaliacoesEstabelecimentos(id);
    }
}
