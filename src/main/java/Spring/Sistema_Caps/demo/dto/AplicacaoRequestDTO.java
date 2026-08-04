package Spring.Sistema_Caps.demo.dto;


import java.time.LocalDate;

public record AplicacaoRequestDTO (

     String paciente,
     String profissional,
     String medicamento,

     LocalDate dataAplicacao,
     Integer qtdAplicada,
     String obs
){}
