package Spring.Sistema_Caps.demo.dto;

import Spring.Sistema_Caps.demo.entity.enums.TipoProfissional;

public record ProfissionalResponseDTO (

     Long id,
     TipoProfissional tipoProfissional,
     String cadastroRegional,
     String nome,
     String endereco,
     String contato,
     String cpf,
     String login
)
{}
