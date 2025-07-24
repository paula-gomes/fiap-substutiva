package fiap_substituva.infrasctruture.controllers.estabelecimento;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EstabelecimentoDTO {

    private String nome;
    private String cnpj;
    private String endereco;
    private String telefone;
}
