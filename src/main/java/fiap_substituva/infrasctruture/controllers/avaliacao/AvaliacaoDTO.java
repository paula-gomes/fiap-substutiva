package fiap_substituva.infrasctruture.controllers.avaliacao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AvaliacaoDTO {
    private Long id;
    private Long idCliente;
    private int estrelas;
    private String comentario;
    private Long idEstabelecimento;
    private Long idProfissional;
}
