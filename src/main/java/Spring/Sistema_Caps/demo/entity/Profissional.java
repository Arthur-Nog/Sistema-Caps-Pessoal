package Spring.Sistema_Caps.demo.entity;

import Spring.Sistema_Caps.demo.entity.enums.TipoProfissional;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_Profissionais")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Profissional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private TipoProfissional tipoProfissional;
    private String cadastroRegional;
    private String nome;
    private String endereco;
    private String contato;
    private String cpf;
    private String login;
    private String senha;

}

