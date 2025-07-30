package fiap_substituva.infrasctruture.gateways.avaliacao;

import fiap_substituva.domain.Avaliacao;
import fiap_substituva.infrasctruture.persistence.avaliacao.AvaliacaoEntity;

public class AvaliacaoMapper {

    public static AvaliacaoEntity toEntity(Avaliacao avaliacao) {
        if (avaliacao == null) {
            return null;
        }
        return new AvaliacaoEntity(
                avaliacao.getId(),
                avaliacao.getIdCliente(),
                avaliacao.getEstrelas(),
                avaliacao.getComentario(),
                avaliacao.getIdEstabelecimento(),
                avaliacao.getIdProfissional()
        );
    }

    public static Avaliacao toDomain(AvaliacaoEntity entity) {
        if (entity == null) {
            return null;
        }
        return new Avaliacao(
                entity.getId(),
                entity.getIdCliente(),
                entity.getEstrelas(),
                entity.getComentario(),
                entity.getIdEstabelecimento(),
                entity.getIdProfissional()
        );
    }
}
