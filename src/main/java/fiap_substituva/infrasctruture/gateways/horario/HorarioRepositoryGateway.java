package fiap_substituva.infrasctruture.gateways.horario;

import fiap_substituva.application.gateways.EstabelecimentoGateway;
import fiap_substituva.application.gateways.HorarioGateway;
import fiap_substituva.domain.Estabelecimento;
import fiap_substituva.domain.Horario;
import fiap_substituva.infrasctruture.exception.CustomException;
import fiap_substituva.infrasctruture.persistence.horario.HorarioEntity;
import fiap_substituva.infrasctruture.persistence.horario.HorarioRepository;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.stream.Collectors;

public class HorarioRepositoryGateway implements HorarioGateway {
    private final HorarioRepository horarioRepository;
    private final EstabelecimentoGateway estabelecimentoGateway;

    public HorarioRepositoryGateway(HorarioRepository horarioRepository, EstabelecimentoGateway estabelecimentoGateway) {
        this.horarioRepository = horarioRepository;
        this.estabelecimentoGateway = estabelecimentoGateway;
    }
    @Override
    public List<Horario> buscarHorariosPorIdEstabelecimento(Long id) {
        List<HorarioEntity> entities = horarioRepository.findByEstabelecimentoId(id);
        return entities.stream()
                .map(HorarioMapper::toDomain)
                .collect(Collectors.toList());
    }


    @Override
    public Horario cadastraHorario(Horario horario) {
        if (horario == null || horario.getIdEstabelecimento() == null) {
            throw new IllegalArgumentException("Horario or Estabelecimento ID cannot be null");
        }

        Estabelecimento estabelecimento = estabelecimentoGateway.buscarEstabelecimentoPorId(horario.getIdEstabelecimento());
        if (estabelecimento == null) {
            throw new CustomException(HttpStatus.NOT_FOUND, "Estabelecimento not found");
        }
        HorarioEntity horarioEntity = HorarioMapper.toEntity(horario);
        HorarioEntity savedEntity = horarioRepository.save(horarioEntity);

        return HorarioMapper.toDomain(savedEntity);
    }

    @Override
    public void excluirHorario(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("ID cannot be null");
        }

        if (!horarioRepository.existsById(id)) {
            throw new CustomException(HttpStatus.NOT_FOUND, "Horario not found");
        }

        horarioRepository.deleteById(id);
    }
}

