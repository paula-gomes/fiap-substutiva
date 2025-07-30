package fiap_substituva.infrasctruture.controllers.estabelecimento;

import fiap_substituva.infrasctruture.controllers.horario.HorarioDTO;
import fiap_substituva.infrasctruture.controllers.profissional.ProfissionalDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EstabelecimentoDTO {
    private String nome;
    private String cnpj;
    private String endereco;
    private String telefone;
    private List<String> servicos;
    private List<String> profissionais;
    private List<String> fotos;
}