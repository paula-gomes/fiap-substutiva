package fiap_substituva.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Avaliacao {
    private Long id;
    private Long idCliente;
    private int estrelas;
    private String comentario;
    private Long idEstabelecimento;
    private Long idProfissional;
}
