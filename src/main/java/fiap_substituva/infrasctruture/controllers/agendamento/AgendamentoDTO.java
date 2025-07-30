package fiap_substituva.infrasctruture.controllers.agendamento;

import fiap_substituva.domain.enums.StatusAgendamentoEnum;
import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AgendamentoDTO {
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
