package Spring.Sistema_Caps.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "tb_Consulta")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Paciente pacienteConsultado;
    @ManyToOne
    private Profissional profissionalAtendente;
    private LocalDate dataConsulta;
    private String obs;
}
