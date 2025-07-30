package fiap_substituva.application.gateways;

import fiap_substituva.domain.Avaliacao;

import java.util.List;

public interface AvaliacaoGateway {
    Avaliacao criarAvaliacaoProfissional(Avaliacao avaliacao);

    Avaliacao criarAvaliacaoEstabelecimento(Avaliacao avaliacao);



    List<Avaliacao> listarAvaliacoesProfissionais(Long id);



    List<Avaliacao> listarAvaliacoesEstabelecimentos(Long id);
}
