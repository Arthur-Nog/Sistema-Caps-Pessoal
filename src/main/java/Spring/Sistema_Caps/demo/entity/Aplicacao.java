package Spring.Sistema_Caps.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_Aplicacao")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Aplicacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Paciente paciente;

    @ManyToOne
    private Profissional profissional;
    @ManyToOne
    private Medicamento medicamento;

    private LocalDateTime dataAplicacao;
    private Integer qtdAplicada;
    private String obs;
}
