package fiap_substituva.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Estabelecimento {

    private String nome;
    private String cnpj;
    private String endereco;
    private String telefone;

}
