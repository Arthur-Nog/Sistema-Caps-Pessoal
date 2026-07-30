package Spring.Sistema_Caps.demo.dto;

public record MedicamentoResponseDTO (

     Long id,
     String nomeMedicamento,
     String principioAtivo,
     String dosagem,
     Integer quantidadeInEstoque
)
{}
