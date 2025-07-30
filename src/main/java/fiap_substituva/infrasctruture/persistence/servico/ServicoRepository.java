package fiap_substituva.infrasctruture.persistence.servico;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ServicoRepository extends CrudRepository<ServicoEntity, Long> {

    /**
     * Busca um serviço pelo nome.
     *
     * @param nome o nome do serviço a ser buscado
     * @return um Optional contendo o ServicoEntity se encontrado, ou vazio se não encontrado
     */
    Optional<ServicoEntity> findByNome(@Param("nome") String nome);
}
