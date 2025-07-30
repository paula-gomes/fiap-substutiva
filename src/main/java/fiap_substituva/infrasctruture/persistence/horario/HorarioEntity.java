package fiap_substituva.infrasctruture.persistence.horario;

import fiap_substituva.domain.enums.DiasDaSemanaEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "horario_entity")
public class HorarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private DiasDaSemanaEnum diaDaSemana;


    private LocalTime inicio;


    private LocalTime fim;

    private Long estabelecimentoId;
}