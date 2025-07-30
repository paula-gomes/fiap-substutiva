package fiap_substituva.infrasctruture.persistence.cliente;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ClienteRepository  extends CrudRepository<ClienteEntity, Long> {
    /**
     * Busca um cliente pelo CPF.
     *
     * @param cpf o CPF do cliente a ser buscado
     * @return um Optional contendo o ClienteEntity se encontrado, ou vazio se não encontrado
     */
    Optional<ClienteEntity> findByCpf(@Param("cpf") String cpf);
}
