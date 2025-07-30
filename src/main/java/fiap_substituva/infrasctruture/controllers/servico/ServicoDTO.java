package fiap_substituva.infrasctruture.controllers.servico;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class ServicoDTO {
    private String nome;

    private String descricao;

    private BigDecimal preco;
    private Long estabelecimentoId;
}
