package fiap_substituva.application.usecases.servico;

import fiap_substituva.application.gateways.ServicoGateway;
import fiap_substituva.domain.Cliente;
import fiap_substituva.domain.Servico;

import java.util.List;

public class ServicoUseCase {
    private final ServicoGateway servicoGateway;


    public ServicoUseCase(ServicoGateway servicoGateway) {
        this.servicoGateway = servicoGateway;
    }

    public Servico criarServico(Servico servico){
        return servicoGateway.criarServico(servico);
    }



}
