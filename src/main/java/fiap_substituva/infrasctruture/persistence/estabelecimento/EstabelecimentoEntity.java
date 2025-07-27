package fiap_substituva.infrasctruture.persistence.estabelecimento;

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
    private String nome;
    private String cnpj;
    private String endereco;
    private String telefone;

    @ElementCollection
    @CollectionTable(name = "estabelecimento_servicos", joinColumns = @JoinColumn(name = "estabelecimento_id"))
    @Column(name = "servico")
    private List<String> servicos;

    @ElementCollection
    @CollectionTable(name = "estabelecimento_profissionais", joinColumns = @JoinColumn(name = "estabelecimento_id"))
    @Column(name = "profissional")
    private List<String> profissionais;

    private String horariosFuncionamento;

    @ElementCollection
    @CollectionTable(name = "estabelecimento_fotos", joinColumns = @JoinColumn(name = "estabelecimento_id"))
    @Column(name = "foto_url")
    private List<String> fotos;
}
