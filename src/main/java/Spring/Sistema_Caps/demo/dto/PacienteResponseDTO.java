package Spring.Sistema_Caps.demo.dto;


import Spring.Sistema_Caps.demo.entity.enums.StatusPaciente;

import java.time.LocalDate;

public record PacienteResponseDTO(

        Long id,
        String nome,
        StatusPaciente status,
        String endereco,
        Integer idade,
        String cns,
        String cpf,
        String prontuario,
        String contato,
        String contatoEmergencia,
        LocalDate dataNascimento,
        LocalDate ultimaConsulta,
        LocalDate dataAdmissao
){}
