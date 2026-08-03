package Spring.Sistema_Caps.demo.dto;


import java.time.LocalDate;

public record ConsultaResponseDTO (
        Long id,
        String pacienteConsultado,
        String profissionalAtendente,
        LocalDate dataConsulta,
        String obs
){}
