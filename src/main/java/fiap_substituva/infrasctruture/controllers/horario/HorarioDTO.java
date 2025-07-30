package fiap_substituva.infrasctruture.controllers.horario;


import fiap_substituva.domain.enums.DiasDaSemanaEnum;
import lombok.*;

import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HorarioDTO {
    private Long id;
    private DiasDaSemanaEnum diaDaSemana;
    private LocalTime inicio;
    private LocalTime fim;
    private Long idEstabelecimento;
}
