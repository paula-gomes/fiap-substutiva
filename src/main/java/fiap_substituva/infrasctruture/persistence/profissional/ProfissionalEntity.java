package fiap_substituva.infrasctruture.persistence.profissional;

import fiap_substituva.infrasctruture.persistence.estabelecimento.EstabelecimentoEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "profissional_entity")
public class ProfissionalEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String especialidade;
    private BigDecimal preco;
    private Long estabelecimentoId; // Apenas o ID do estabelecimento

}