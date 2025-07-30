package fiap_substituva.infrasctruture.gateways.profissional;

import fiap_substituva.application.gateways.EstabelecimentoGateway;
import fiap_substituva.application.gateways.ProfissionalGateway;
import fiap_substituva.domain.Profissional;
import fiap_substituva.infrasctruture.persistence.profissional.ProfissionalEntity;
import fiap_substituva.infrasctruture.persistence.profissional.ProfissionalRepository;

public class ProfissionalRepositoryGateway implements ProfissionalGateway {

    private final ProfissionalRepository profissionalRepository;
    private final EstabelecimentoGateway estabelecimentoGateway;

    public ProfissionalRepositoryGateway(ProfissionalRepository profissionalRepository, EstabelecimentoGateway estabelecimentoGateway) {
        this.profissionalRepository = profissionalRepository;
        this.estabelecimentoGateway = estabelecimentoGateway;
    }

    @Override
    public Profissional criarProfissional(Profissional profissional) {
        ProfissionalEntity profissionalEntity = ProfissionalMapper.toEntity(profissional);


        ProfissionalEntity savedEntity = profissionalRepository.save(profissionalEntity);

        return ProfissionalMapper.toDomain(savedEntity);

        }

}