package Spring.Sistema_Caps.demo.dto;


import java.time.LocalDate;

public record ConsultaRequestDTO(

        String pacienteConsultado,
        String profissionalAtendente,
        LocalDate dataConsulta,
        String obs
) {
}
