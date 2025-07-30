package fiap_substituva.infrasctruture.persistence.horario;


import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface HorarioRepository extends CrudRepository<HorarioEntity, Long> {
    List<HorarioEntity> findByEstabelecimentoId(Long idEstabelecimento);
}