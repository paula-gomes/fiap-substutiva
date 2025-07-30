package fiap_substituva.infrasctruture.controllers.agendamento;

import fiap_substituva.application.usecases.agendamento.AgendamentoUseCase;
import fiap_substituva.domain.Agendamento;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agendamentos")
public class AgendamentoController {
    private final AgendamentoUseCase agendamentoUseCase;

    public AgendamentoController(AgendamentoUseCase agendamentoUseCase) {
        this.agendamentoUseCase = agendamentoUseCase;
    }

    @PostMapping
    public AgendamentoDTO criarAgendamento(@RequestBody AgendamentoDTO agendamentoDTO) {
        Agendamento agendamento = new Agendamento(
                agendamentoDTO.getId(),
                agendamentoDTO.getIdProfissional(),
                agendamentoDTO.getIdEstabelecimento(),
                agendamentoDTO.getIdCliente(),
                agendamentoDTO.getIdServico(),
                agendamentoDTO.getStatus(),
                agendamentoDTO.getData(),
                agendamentoDTO.getHoraInicio(),
                agendamentoDTO.getHoraTermino()
        );

        Agendamento createdAgendamento = agendamentoUseCase.criarAgendamento(agendamento);

        return new AgendamentoDTO(
                createdAgendamento.getId(),
                createdAgendamento.getIdProfissional(),
                createdAgendamento.getIdEstabelecimento(),
                createdAgendamento.getIdCliente(),
                createdAgendamento.getIdServico(),
                createdAgendamento.getStatus(),
                createdAgendamento.getData(),
                createdAgendamento.getHoraInicio(),
                createdAgendamento.getHoraTermino()
        );
    }
    @GetMapping
    public List<AgendamentoDTO> listarAgendamentos() {
        List<Agendamento> agendamentos = agendamentoUseCase.listarAgendamentos();
        return agendamentos.stream()
                .map(agendamento -> new AgendamentoDTO(
                        agendamento.getId(),
                        agendamento.getIdProfissional(),
                        agendamento.getIdEstabelecimento(),
                        agendamento.getIdCliente(),
                        agendamento.getIdServico(),
                        agendamento.getStatus(),
                        agendamento.getData(),
                        agendamento.getHoraInicio(),
                        agendamento.getHoraTermino()
                ))
                .toList();
    }

    @PutMapping("/{id}")
    public AgendamentoDTO atualizarAgendamento(
            @PathVariable Long id,
            @RequestBody AgendamentoDTO agendamentoDTO) {
        Agendamento agendamento = new Agendamento(
                agendamentoDTO.getId(),
                agendamentoDTO.getIdProfissional(),
                agendamentoDTO.getIdEstabelecimento(),
                agendamentoDTO.getIdCliente(),
                agendamentoDTO.getIdServico(),
                agendamentoDTO.getStatus(),
                agendamentoDTO.getData(),
                agendamentoDTO.getHoraInicio(),
                agendamentoDTO.getHoraTermino()
        );

        Agendamento updatedAgendamento = agendamentoUseCase.atualizarAgendamento(id, agendamento);

        return new AgendamentoDTO(
                updatedAgendamento.getId(),
                updatedAgendamento.getIdProfissional(),
                updatedAgendamento.getIdEstabelecimento(),
                updatedAgendamento.getIdCliente(),
                updatedAgendamento.getIdServico(),
                updatedAgendamento.getStatus(),
                updatedAgendamento.getData(),
                updatedAgendamento.getHoraInicio(),
                updatedAgendamento.getHoraTermino()
        );
    }

    @DeleteMapping("/{id}")
    public void excluirAgendamento(@PathVariable Long id) {
        agendamentoUseCase.excluirAgendamento(id);
    }
}
