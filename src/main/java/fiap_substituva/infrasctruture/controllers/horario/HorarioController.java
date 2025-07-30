package fiap_substituva.infrasctruture.controllers.horario;

import fiap_substituva.application.usecases.horario.HorarioUseCase;
import fiap_substituva.domain.Horario;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/horarios")
public class HorarioController {

    private final HorarioUseCase horarioUseCase;

    public HorarioController(HorarioUseCase horarioUseCase) {
        this.horarioUseCase = horarioUseCase;
    }


    @GetMapping("/estabelecimentos/{id}")
    public List<HorarioDTO> buscarPorEstabelecimento(@PathVariable Long id) {
        return horarioUseCase.buscarHorariosPorIdEstabelecimento(id)
                .stream()
                .map(horario -> new HorarioDTO(
                        horario.getId(),
                        horario.getDiaDaSemana(),
                        horario.getInicio(),
                        horario.getFim(),
                        horario.getIdEstabelecimento()
                ))
                .toList();
    }

    @PostMapping
    public HorarioDTO cadastrar(@RequestBody HorarioDTO horarioDTO) {


        if (horarioDTO.getIdEstabelecimento() == null) {
            throw new IllegalArgumentException("idEstabelecimento cannot be null");
        }

        Horario horario = horarioUseCase.cadastraHorario(
                new Horario(
                        horarioDTO.getId(),
                        horarioDTO.getDiaDaSemana(),
                        horarioDTO.getInicio(),
                        horarioDTO.getFim(),
                        horarioDTO.getIdEstabelecimento()
                )
        );

        return new HorarioDTO(
                horario.getId(),
                horario.getDiaDaSemana(),
                horario.getInicio(),
                horario.getFim(),
                horario.getIdEstabelecimento()
        );
    }
    @DeleteMapping("/{id}")
    public void deletarHorario(@PathVariable Long id) {
        horarioUseCase.excluirHorario(id);
    }
}

