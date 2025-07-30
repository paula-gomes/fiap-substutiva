package fiap_substituva.domain;

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
public class Profissional {
    private String nome;
    private String especialidade;
    private BigDecimal tarifa;
    private Long estabelecimentoId;
}


