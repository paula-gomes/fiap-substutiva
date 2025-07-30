package fiap_substituva.application.usecases.estabelecimento;

import fiap_substituva.application.gateways.ClienteGateway;
import fiap_substituva.application.gateways.EstabelecimentoGateway;
import fiap_substituva.domain.Cliente;
import fiap_substituva.domain.Estabelecimento;

public class EstabelecimentoUseCase {
    private final EstabelecimentoGateway estabelecimentoGateway;

    public EstabelecimentoUseCase(EstabelecimentoGateway estabelecimentoGateway) {
        this.estabelecimentoGateway = estabelecimentoGateway;
    }

    public Estabelecimento criarEstabelecimento(Estabelecimento estabelecimento) {
        return estabelecimentoGateway.criarEstabelecimento(estabelecimento);
    }
    public Estabelecimento buscarEstabelecimentoPorNome(String nome) {
        return estabelecimentoGateway.buscarEstabelecimentoPorNome(nome);
    }
    public Estabelecimento editarEstabelecimento(Estabelecimento estabelecimento) {
        return estabelecimentoGateway.editarEstabelecimento(estabelecimento);
    }

}