package fiap_substituva.infrasctruture.gateways.profissional;

import fiap_substituva.application.gateways.EstabelecimentoGateway;
import fiap_substituva.application.gateways.ProfissionalGateway;
import fiap_substituva.domain.Profissional;
import fiap_substituva.infrasctruture.persistence.profissional.ProfissionalEntity;
import fiap_substituva.infrasctruture.persistence.profissional.ProfissionalRepository;

public class ProfissionalRepositoryGateway implements ProfissionalGateway {

    private final ProfissionalRepository profissionalRepository;

    public ProfissionalRepositoryGateway(ProfissionalRepository profissionalRepository) {
        this.profissionalRepository = profissionalRepository;
    }

    @Override
    public Profissional criarProfissional(Profissional profissional) {
        ProfissionalEntity profissionalEntity = new ProfissionalEntity();
        profissionalEntity.setNome(profissional.getNome());
        profissionalEntity.setEspecialidade(profissional.getEspecialidade());
        profissionalEntity.setHorariosDisponiveis(profissional.getHorariosDisponiveis());
        profissionalEntity.setTarifa(profissional.getTarifa()); // Map the tarifa field

        ProfissionalEntity savedEntity = profissionalRepository.save(profissionalEntity);

        return new Profissional(
                savedEntity.getNome(),
                savedEntity.getEspecialidade(),
                savedEntity.getHorariosDisponiveis(),
                savedEntity.getTarifa()
        );
    }
}
