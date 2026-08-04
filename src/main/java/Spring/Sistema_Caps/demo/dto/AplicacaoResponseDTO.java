package Spring.Sistema_Caps.demo.dto;

import java.time.LocalDate;

public record AplicacaoResponseDTO (

     Long id,
     String Paciente,
     String Profissional,
     String Medicamento,
     LocalDate dataAplicacao,
     Integer qtdAplicada,
     String obs
)
{}
