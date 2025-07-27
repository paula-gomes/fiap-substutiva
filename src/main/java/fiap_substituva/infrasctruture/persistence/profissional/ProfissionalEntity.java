package fiap_substituva.infrasctruture.persistence.profissional;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

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

    @ElementCollection
    @CollectionTable(name = "profissional_horarios", joinColumns = @JoinColumn(name = "profissional_id"))
    @Column(name = "horario")
    private List<String> horariosDisponiveis;

    private BigDecimal tarifa;
}