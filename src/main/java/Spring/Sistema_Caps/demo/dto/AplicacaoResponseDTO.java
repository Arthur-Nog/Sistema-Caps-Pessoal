package Spring.Sistema_Caps.demo.dto;

import java.time.LocalDate;

public record AplicacaoResponseDTO (

        Long id,
     String nomePaciente,
     String nomeProfissional,
     String nomeMedicamento,
     LocalDate dataAplicacao,
     Integer qtdAplicada,
     String obs
)
{}
