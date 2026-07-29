package Spring.Sistema_Caps.demo.dto;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
public class AplicacaoRequestDTO {

    private Long pacienteId;
    private Long profissionalId;
    private Long medicamentoId;

    private LocalDateTime dataAplicacao;
    private Integer qtdAplicada;
    private String obs;
}
