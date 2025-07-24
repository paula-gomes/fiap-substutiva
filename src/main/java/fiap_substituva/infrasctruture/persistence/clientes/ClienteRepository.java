package fiap_substituva.infrasctruture.persistence.clientes;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ClienteRepository  extends CrudRepository<ClienteEntity, Long> {

    Optional<ClienteEntity> findByNome(@Param("nome") String nome);
}
