package fiap_substituva.infrasctruture.gateways.servico;

import fiap_substituva.domain.Servico;
import fiap_substituva.infrasctruture.persistence.servico.ServicoEntity;

public class SerivcoMapper {

    public static Servico toDomain(ServicoEntity entity) {
        if (entity == null) {
            return null;
        }
        return new Servico(
                entity.getNome(),
                entity.getDescricao(),
                entity.getPreco(),
                entity.getEstabelecimentoId()
        );
    }

    public static ServicoEntity toEntity(Servico servico) {
        if (servico == null) {
            return null;
        }
        ServicoEntity entity = new ServicoEntity();
        entity.setNome(servico.getNome());
        entity.setDescricao(servico.getDescricao());
        entity.setPreco(servico.getPreco());
        entity.setEstabelecimentoId(servico.getEstabelecimentoId());
        return entity;
    }
}