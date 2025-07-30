package fiap_substituva.infrasctruture.gateways.horario;


import fiap_substituva.domain.Horario;
import fiap_substituva.infrasctruture.persistence.horario.HorarioEntity;

public class HorarioMapper {

    public static Horario toDomain(HorarioEntity entity) {
        if (entity == null) {
            return null;
        }
        return new Horario(
                entity.getId(),
                entity.getDiaDaSemana(),
                entity.getInicio(),
                entity.getFim(),
                entity.getEstabelecimentoId()
        );
    }


    public static HorarioEntity toEntity(Horario horario) {
        if (horario == null) {
            return null;
        }
        return new HorarioEntity(
                horario.getId(),
                horario.getDiaDaSemana(),
                horario.getInicio(),
                horario.getFim(),
                horario.getIdEstabelecimento()
        );
    }
}
