package fiap_substituva.application.usecases.profissional;

import fiap_substituva.application.gateways.EstabelecimentoGateway;
import fiap_substituva.application.gateways.ProfissionalGateway;
import fiap_substituva.domain.Estabelecimento;
import fiap_substituva.domain.Profissional;

public class ProfissionalUseCase {
    private final ProfissionalGateway profissionalGateway;

    public ProfissionalUseCase(ProfissionalGateway profissionalGateway) {
        this.profissionalGateway = profissionalGateway;
    }
    public Profissional criarProfissional(Profissional profissional) {
        return profissionalGateway.criarProfissional(profissional);
    }
}

