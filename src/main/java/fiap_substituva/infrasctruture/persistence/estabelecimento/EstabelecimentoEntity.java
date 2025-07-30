package fiap_substituva.infrasctruture.persistence.estabelecimento;

import fiap_substituva.infrasctruture.persistence.horario.HorarioEntity;
import fiap_substituva.infrasctruture.persistence.profissional.ProfissionalEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "estabelecimento_entity")
public class EstabelecimentoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nome;

    private String cnpj;
    private String endereco;
    private String telefone;
    private List<String> servicos;
    private List<String> profissionais;
    private List<String> fotos;
}