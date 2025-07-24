package fiap_substituva.infrasctruture.gateways.estabelecimento;

import fiap_substituva.application.gateways.EstabelecimentoGateway;
import fiap_substituva.domain.Cliente;
import fiap_substituva.domain.Estabelecimento;
import fiap_substituva.infrasctruture.persistence.clientes.ClienteEntity;
import fiap_substituva.infrasctruture.persistence.clientes.ClienteRepository;
import fiap_substituva.infrasctruture.persistence.estabelecimento.EstabelecimentoEntity;
import fiap_substituva.infrasctruture.persistence.estabelecimento.EstabelecimentoRepository;

public class EstabelecimentoRepositoryGateway implements EstabelecimentoGateway {

    private final EstabelecimentoRepository estabelecimentoRepository;

    public EstabelecimentoRepositoryGateway(EstabelecimentoRepository estabelecimentoRepository) {
        this.estabelecimentoRepository = estabelecimentoRepository;
    }

    @Override
    public Estabelecimento criarEstabelecimento(Estabelecimento cliente) {
        EstabelecimentoEntity estabelecimentoEntity = new EstabelecimentoEntity();
        estabelecimentoEntity.setNome(cliente.getNome());
        estabelecimentoEntity.setEndereco(cliente.getEndereco());
        estabelecimentoEntity.setTelefone(cliente.getTelefone());
        estabelecimentoEntity.setCnpj(cliente.getCnpj());

        EstabelecimentoEntity savedEntity = estabelecimentoRepository.save(estabelecimentoEntity);

        return new Estabelecimento(
                savedEntity.getNome(),
                savedEntity.getEndereco(),
                savedEntity.getTelefone(),
                savedEntity.getCnpj()
        );
    }
}
