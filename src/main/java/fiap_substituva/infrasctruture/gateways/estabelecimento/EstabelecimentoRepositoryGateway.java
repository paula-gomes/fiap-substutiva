package fiap_substituva.infrasctruture.gateways.estabelecimento;

import fiap_substituva.application.gateways.EstabelecimentoGateway;

import fiap_substituva.domain.Estabelecimento;

import fiap_substituva.infrasctruture.persistence.estabelecimento.EstabelecimentoEntity;
import fiap_substituva.infrasctruture.persistence.estabelecimento.EstabelecimentoRepository;

public class EstabelecimentoRepositoryGateway implements EstabelecimentoGateway {

    private final EstabelecimentoRepository estabelecimentoRepository;

    public EstabelecimentoRepositoryGateway(EstabelecimentoRepository estabelecimentoRepository) {
        this.estabelecimentoRepository = estabelecimentoRepository;
    }

    @Override
    public Estabelecimento criarEstabelecimento(Estabelecimento estabelecimento) {
        EstabelecimentoEntity estabelecimentoEntity = new EstabelecimentoEntity();
        estabelecimentoEntity.setNome(estabelecimento.getNome());
        estabelecimentoEntity.setEndereco(estabelecimento.getEndereco());
        estabelecimentoEntity.setTelefone(estabelecimento.getTelefone());
        estabelecimentoEntity.setCnpj(estabelecimento.getCnpj());
        estabelecimentoEntity.setServicos(estabelecimento.getServicos());
        estabelecimentoEntity.setProfissionais(estabelecimento.getProfissionais());
        estabelecimentoEntity.setHorariosFuncionamento(estabelecimento.getHorariosFuncionamento());
        estabelecimentoEntity.setFotos(estabelecimento.getFotos());

        EstabelecimentoEntity savedEntity = estabelecimentoRepository.save(estabelecimentoEntity);

        return new Estabelecimento(
                savedEntity.getNome(),
                savedEntity.getCnpj(),
                savedEntity.getEndereco(),
                savedEntity.getTelefone(),
                savedEntity.getServicos(),
                savedEntity.getProfissionais(),
                savedEntity.getHorariosFuncionamento(),
                savedEntity.getFotos()
        );
    }
}
