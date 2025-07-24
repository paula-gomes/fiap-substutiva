package fiap_substituva.infrasctruture.persistence.estabelecimento;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface EstabelecimentoRepository extends CrudRepository<EstabelecimentoEntity, Long> {

}
