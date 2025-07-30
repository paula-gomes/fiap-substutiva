package fiap_substituva.infrasctruture.persistence.agendamento;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AgendamentoRepository extends CrudRepository<AgendamentoEntity, Long> {

}
