package fiap_substituva.application.gateways;

import fiap_substituva.domain.Foto;

import java.util.List;

public interface FotoGateway {

    Foto adicionarFoto(Foto foto);

    void excluirFoto(Long id);

    List<Foto> buscarFotosPorEstabelecimento(Long idEstabelecimento);
}
