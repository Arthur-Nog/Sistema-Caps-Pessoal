package Spring.Sistema_Caps.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_medicamento")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Medicamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeMedicamento;
    private String principioAtivo;
    private String dosagem;
    private Integer quantidadeInEstoque;

}
