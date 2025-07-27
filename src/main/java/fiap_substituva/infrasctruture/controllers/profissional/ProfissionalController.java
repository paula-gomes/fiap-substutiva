package fiap_substituva.infrasctruture.controllers.profissional;

import fiap_substituva.application.usecases.profissional.ProfissionalUseCase;
import fiap_substituva.domain.Profissional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("profissionais")
public class ProfissionalController {
    private final ProfissionalUseCase profissionalUseCase;

    public ProfissionalController(ProfissionalUseCase profissionalUseCase) {
        this.profissionalUseCase = profissionalUseCase;
    }

    @PostMapping
    public ProfissionalDTO criarProfissional(@RequestBody ProfissionalDTO request) {
        Profissional profissional = new Profissional(
                request.getNome(),
                request.getEspecialidade(),
                request.getHorariosDisponiveis(),
                request.getTarifa()
        );
        Profissional savedProfissional = profissionalUseCase.criarProfissional(profissional);
        return new ProfissionalDTO(
                savedProfissional.getNome(),
                savedProfissional.getEspecialidade(),
                savedProfissional.getHorariosDisponiveis(),
                savedProfissional.getTarifa()
        );
    }
}