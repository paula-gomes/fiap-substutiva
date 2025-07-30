package fiap_substituva.infrasctruture.persistence.agendamento;

import fiap_substituva.domain.enums.StatusAgendamentoEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "agendamento_entity")
public class AgendamentoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long idProfissional;
    private Long idEstabelecimento;
    private Long idCliente;
    private Long idServico;
    private StatusAgendamentoEnum status;
    private LocalDate data;
    private LocalTime horaInicio;
    private LocalTime horaTermino;
}
