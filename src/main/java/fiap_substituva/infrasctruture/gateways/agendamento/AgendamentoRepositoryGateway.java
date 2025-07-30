package fiap_substituva.infrasctruture.gateways.agendamento;

import fiap_substituva.application.gateways.AgendamentoGateway;

import fiap_substituva.domain.Agendamento;
import fiap_substituva.infrasctruture.persistence.agendamento.AgendamentoEntity;
import fiap_substituva.infrasctruture.persistence.agendamento.AgendamentoRepository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


public class AgendamentoRepositoryGateway implements AgendamentoGateway {

    private final AgendamentoRepository agendamentoRepository;

    public AgendamentoRepositoryGateway(AgendamentoRepository agendamentoRepository) {
        this.agendamentoRepository = agendamentoRepository;
    }


    @Override
    public Agendamento criarAgendamento(Agendamento agendamento) {
        AgendamentoEntity entity = AgendamentoMapper.toEntity(agendamento);
        AgendamentoEntity savedEntity = agendamentoRepository.save(entity);
        return AgendamentoMapper.toDomain(savedEntity);
    }

    @Override
    public List<Agendamento> listarAgendamentos() {
        return StreamSupport.stream(agendamentoRepository.findAll().spliterator(), false)
                .map(AgendamentoMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Agendamento atualizarAgendamento(Long id, Agendamento agendamento) {
        AgendamentoEntity existingEntity = agendamentoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Agendamento not found with id: " + id));
        AgendamentoEntity updatedEntity = AgendamentoMapper.toEntity(agendamento);
        updatedEntity.setId(existingEntity.getId());
        AgendamentoEntity savedEntity = agendamentoRepository.save(updatedEntity);
        return AgendamentoMapper.toDomain(savedEntity);
    }

    @Override
    public void excluirAgendamento(Long id) {
        if (!agendamentoRepository.existsById(id)) {
            throw new RuntimeException("Agendamento not found with id: " + id);
        }
        agendamentoRepository.deleteById(id);
    }
}