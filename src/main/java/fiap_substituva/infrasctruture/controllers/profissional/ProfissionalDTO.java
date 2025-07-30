package fiap_substituva.infrasctruture.controllers.profissional;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class ProfissionalDTO {
    private String nome;
    private String especialidade;
    private BigDecimal tarifa;
    private Long estabelecimentoId;
}


