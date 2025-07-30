package fiap_substituva.infrasctruture.controllers.foto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FotoDTO {
    private Long id;
    private String url;
    private Long idEstabelecimento;
}
