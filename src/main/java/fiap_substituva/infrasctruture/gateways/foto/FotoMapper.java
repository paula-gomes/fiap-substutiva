package fiap_substituva.infrasctruture.gateways.foto;

import fiap_substituva.domain.Foto;
import fiap_substituva.infrasctruture.persistence.foto.FotoEntity;

public class FotoMapper {

    public static Foto toDomain(FotoEntity entity) {
        if (entity == null) {
            return null;
        }
        return new Foto(
                entity.getId(),
                entity.getUrl(),
                entity.getEstabelecimentoId()
        );
    }

    public static FotoEntity toEntity(Foto foto) {
        if (foto == null) {
            return null;
        }
        return new FotoEntity(
                foto.getId(),
                foto.getUrl(),
                foto.getIdEstabelecimento()
        );
    }
}