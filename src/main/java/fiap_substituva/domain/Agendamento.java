package fiap_substituva.domain;

import fiap_substituva.domain.enums.StatusAgendamentoEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Agendamento {
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
