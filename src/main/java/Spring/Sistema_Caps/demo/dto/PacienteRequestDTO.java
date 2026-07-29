package Spring.Sistema_Caps.demo.dto;

import Spring.Sistema_Caps.demo.model.enums.StatusPaciente;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record PacienteRequestDTO (

     String nome,
     StatusPaciente status,
     String endereco,
     String idade,
     String cns,
     String cpf,
     String contato,
     String contatoEmergencia,
     LocalDate dataNascimento,
     LocalDate ultimaConsulta,
     LocalDate dataAdmissao
)
{}
