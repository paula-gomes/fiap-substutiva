package fiap_substituva.domain;


import fiap_substituva.domain.enums.DiasDaSemanaEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


import java.time.LocalTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Horario {
    private Long id;
    private DiasDaSemanaEnum diaDaSemana;
    private LocalTime inicio;
    private LocalTime fim;
    private Long idEstabelecimento;
}
