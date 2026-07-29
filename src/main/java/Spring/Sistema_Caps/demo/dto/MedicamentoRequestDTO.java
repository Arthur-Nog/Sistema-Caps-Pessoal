package Spring.Sistema_Caps.demo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MedicamentoRequestDTO {

    private String nomeMedicamento;
    private String principioAtivo;
    private String dosagem;
    private Integer quantidadeInEstoque;
}
