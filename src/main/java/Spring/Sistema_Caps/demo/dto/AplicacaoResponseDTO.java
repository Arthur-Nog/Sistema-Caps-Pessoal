package Spring.Sistema_Caps.demo.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class AplicacaoResponseDTO {

    private Long id;
    private String nomePaciente;
    private String nomeProfissional;
    private String nomeMedicamento;
    private LocalDateTime dataAplicacao;
    private Integer qtdAplicada;
    private String obs;
}
