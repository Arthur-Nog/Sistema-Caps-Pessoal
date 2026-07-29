package Spring.Sistema_Caps.demo.dto;

public record ProfissionalResponseDTO (

     Long id,
     String tipoProfissional,
     String cadastroRegional,
     String nome,
     String endereco,
     String contato,
     String cpf,
     String login
)
{}
