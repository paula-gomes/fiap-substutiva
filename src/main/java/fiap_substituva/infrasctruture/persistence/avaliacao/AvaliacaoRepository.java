package fiap_substituva.infrasctruture.persistence.avaliacao;

import io.micrometer.common.KeyValues;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface AvaliacaoRepository extends CrudRepository<AvaliacaoEntity, Long> {
    List<AvaliacaoEntity> findByIdEstabelecimento(Long id);

    List<AvaliacaoEntity> findByIdProfissional(Long id);
}
