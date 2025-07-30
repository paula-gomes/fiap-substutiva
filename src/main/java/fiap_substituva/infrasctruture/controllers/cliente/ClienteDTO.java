package fiap_substituva.infrasctruture.controllers.cliente;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDTO {
    private String nome;
    private String email;
    private String cpf;
    private String telefone;

}
