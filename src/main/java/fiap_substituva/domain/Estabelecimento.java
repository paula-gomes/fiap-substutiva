package fiap_substituva.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Estabelecimento {

    private String nome;
    private String cnpj;
    private String endereco;
    private String telefone;
    private List<String> servicos;
    private List<String> profissionais;
    private String horariosFuncionamento;
    private List<String> fotos;
}
