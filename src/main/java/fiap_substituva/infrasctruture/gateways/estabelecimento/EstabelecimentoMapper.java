package fiap_substituva.infrasctruture.gateways.estabelecimento;


import fiap_substituva.domain.Estabelecimento;
import fiap_substituva.infrasctruture.persistence.estabelecimento.EstabelecimentoEntity;

public class EstabelecimentoMapper {

    public static Estabelecimento toDomain(EstabelecimentoEntity entity) {
        if (entity == null) {
            return null;
        }

        return new Estabelecimento(
                entity.getNome(),
                entity.getCnpj(),
                entity.getEndereco(),
                entity.getTelefone(),
                entity.getServicos(),
                entity.getProfissionais(),
                entity.getFotos()
        );
    }

    public static EstabelecimentoEntity toEntity(Estabelecimento domain) {
        if (domain == null) {
            return null;
        }

        EstabelecimentoEntity entity = new EstabelecimentoEntity();
        entity.setNome(domain.getNome());
        entity.setCnpj(domain.getCnpj());
        entity.setEndereco(domain.getEndereco());
        entity.setTelefone(domain.getTelefone());
        entity.setServicos(domain.getServicos());
        entity.setProfissionais(domain.getProfissionais()); // Now directly mapped as List<String>
        entity.setFotos(domain.getFotos());
        return entity;
    }
}