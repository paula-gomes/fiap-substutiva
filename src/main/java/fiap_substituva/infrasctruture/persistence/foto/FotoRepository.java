package fiap_substituva.infrasctruture.persistence.foto;


import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FotoRepository extends CrudRepository<FotoEntity, Long> {
        List<FotoEntity> findByEstabelecimentoId(Long idEstabelecimento);
}

