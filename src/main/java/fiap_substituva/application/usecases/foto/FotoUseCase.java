package fiap_substituva.application.usecases.foto;

import fiap_substituva.application.gateways.FotoGateway;
import fiap_substituva.domain.Foto;
import io.micrometer.common.KeyValues;

import java.util.List;

public class FotoUseCase {
    private final FotoGateway fotoGateway;

    public FotoUseCase(FotoGateway fotoGateway) {
        this.fotoGateway = fotoGateway;
    }

    public Foto adicionarFoto(Foto foto) {
        return fotoGateway.adicionarFoto(foto);
    }

    public void excluirFoto(Long id) {
        fotoGateway.excluirFoto(id);
    }

    public List<Foto> buscarFotosPorEstabelecimento(Long idEstabelecimento) {
        return fotoGateway.buscarFotosPorEstabelecimento(idEstabelecimento);
    }

}
