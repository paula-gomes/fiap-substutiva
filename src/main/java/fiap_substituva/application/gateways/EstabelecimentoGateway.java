package fiap_substituva.application.gateways;

import fiap_substituva.domain.Estabelecimento;

public interface EstabelecimentoGateway {
    Estabelecimento criarEstabelecimento(Estabelecimento estabelecimento);
    Estabelecimento buscarEstabelecimentoPorId(Long id);
    Estabelecimento buscarEstabelecimentoPorNome(String nome);

   Estabelecimento editarEstabelecimento (Estabelecimento estabelecimento);



}
