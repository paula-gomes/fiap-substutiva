package fiap_substituva.infrasctruture.gateways.profissional;

import fiap_substituva.domain.Profissional;
import fiap_substituva.infrasctruture.persistence.profissional.ProfissionalEntity;

public class ProfissionalMapper {

    public static Profissional toDomain(ProfissionalEntity entity) {
        if (entity == null) {
            return null;
        }
        return new Profissional(
                entity.getNome(),
                entity.getEspecialidade(),
                entity.getPreco(),
                entity.getEstabelecimentoId()
        );
    }

    public static ProfissionalEntity toEntity(Profissional profissional) {
        if (profissional == null) {
            return null;
        }
        ProfissionalEntity entity = new ProfissionalEntity();
        entity.setNome(profissional.getNome());
        entity.setEspecialidade(profissional.getEspecialidade());
        entity.setPreco(profissional.getTarifa());
        entity.setEstabelecimentoId(profissional.getEstabelecimentoId());
        return entity;
    }
}