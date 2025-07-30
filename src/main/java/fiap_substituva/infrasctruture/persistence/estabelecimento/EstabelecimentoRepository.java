package fiap_substituva.infrasctruture.persistence.estabelecimento;


import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface EstabelecimentoRepository extends CrudRepository<EstabelecimentoEntity, Long> {

    Optional<EstabelecimentoEntity> findByNome(String nome);
}
