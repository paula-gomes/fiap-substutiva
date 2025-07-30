package fiap_substituva.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Foto {
    private Long id;
    private String url;
    private Long idEstabelecimento;
}
