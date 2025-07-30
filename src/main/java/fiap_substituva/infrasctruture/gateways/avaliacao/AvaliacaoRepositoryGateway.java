package fiap_substituva.infrasctruture.gateways.avaliacao;

import fiap_substituva.application.gateways.AvaliacaoGateway;
import fiap_substituva.domain.Avaliacao;
import fiap_substituva.infrasctruture.persistence.avaliacao.AvaliacaoEntity;
import fiap_substituva.infrasctruture.persistence.avaliacao.AvaliacaoRepository;

import java.util.List;
import java.util.stream.Collectors;

public class AvaliacaoRepositoryGateway implements AvaliacaoGateway {
    private final AvaliacaoRepository avaliacaoRepository;

    public AvaliacaoRepositoryGateway(AvaliacaoRepository avaliacaoRepository) {
        this.avaliacaoRepository = avaliacaoRepository;
    }

    @Override
    public Avaliacao criarAvaliacaoProfissional(Avaliacao avaliacao) {
        AvaliacaoEntity entity = AvaliacaoMapper.toEntity(avaliacao);
        AvaliacaoEntity savedEntity = avaliacaoRepository.save(entity);
        return AvaliacaoMapper.toDomain(savedEntity);
    }

    @Override
    public Avaliacao criarAvaliacaoEstabelecimento(Avaliacao avaliacao) {
        AvaliacaoEntity entity = AvaliacaoMapper.toEntity(avaliacao);
        AvaliacaoEntity savedEntity = avaliacaoRepository.save(entity);
        return AvaliacaoMapper.toDomain(savedEntity);
    }

    @Override
    public List<Avaliacao> listarAvaliacoesProfissionais(Long id) {
        List<AvaliacaoEntity> entities = avaliacaoRepository.findByIdProfissional(id);
        return entities.stream()
                .map(AvaliacaoMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Avaliacao> listarAvaliacoesEstabelecimentos(Long id) {
        List<AvaliacaoEntity> entities = avaliacaoRepository.findByIdEstabelecimento(id);
        return entities.stream()
                .map(AvaliacaoMapper::toDomain)
                .collect(Collectors.toList());

    }
}
