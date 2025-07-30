package fiap_substituva.infrasctruture.controllers.servico;

import fiap_substituva.application.usecases.profissional.ProfissionalUseCase;
import fiap_substituva.application.usecases.servico.ServicoUseCase;
import fiap_substituva.domain.Profissional;
import fiap_substituva.domain.Servico;
import fiap_substituva.infrasctruture.controllers.profissional.ProfissionalDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("servicos")
public class ServicoController {

    private final ServicoUseCase servicoUseCase;

    public ServicoController(ServicoUseCase servicoUseCase) {
        this.servicoUseCase = servicoUseCase;
    }

    @PostMapping
    public ServicoDTO criarServico(@RequestBody ServicoDTO request) {
        Servico servico = new Servico(
                request.getNome(),
                request.getDescricao(),
                request.getPreco(),
                request.getEstabelecimentoId()
        );
        Servico savedServico = servicoUseCase.criarServico(servico);
        return new ServicoDTO(
                savedServico.getNome(),
                savedServico.getDescricao(),
                savedServico.getPreco(),
                savedServico.getEstabelecimentoId()
        );
    }

}
