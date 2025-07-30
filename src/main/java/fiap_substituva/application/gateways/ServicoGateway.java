package fiap_substituva.application.gateways;

import fiap_substituva.domain.Cliente;
import fiap_substituva.domain.Servico;

import java.util.Optional;

public interface ServicoGateway {
    Servico criarServico(Servico servico);

}
