package Spring.Sistema_Caps.demo.dto;


public record MedicamentoRequestDTO (

     String nomeMedicamento,
     String principioAtivo,
     String dosagem,
     Integer quantidadeInEstoque
)
{}
