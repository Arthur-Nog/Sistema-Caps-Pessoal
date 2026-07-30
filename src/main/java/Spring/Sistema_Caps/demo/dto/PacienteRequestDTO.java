package Spring.Sistema_Caps.demo.dto;

import Spring.Sistema_Caps.demo.entity.enums.StatusPaciente;

import java.time.LocalDate;

public record PacienteRequestDTO (

     String nome,
     StatusPaciente status,
     String endereco,
     Integer idade,
     String cns,
     String cpf,
     String contato,
     String contatoEmergencia,
     LocalDate dataNascimento,
     LocalDate ultimaConsulta,
     LocalDate dataAdmissao
)
{}
