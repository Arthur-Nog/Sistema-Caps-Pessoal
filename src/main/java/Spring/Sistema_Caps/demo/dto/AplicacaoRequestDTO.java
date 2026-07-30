package Spring.Sistema_Caps.demo.dto;


import java.time.LocalDate;

public record AplicacaoRequestDTO (

     Long pacienteId,
     Long profissionalId,
     Long medicamentoId,

     LocalDate dataAplicacao,
     Integer qtdAplicada,
     String obs
){}
