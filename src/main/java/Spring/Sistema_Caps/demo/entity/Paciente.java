package Spring.Sistema_Caps.demo.entity;

import Spring.Sistema_Caps.demo.entity.enums.StatusPaciente;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "tb_Pacientes")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private StatusPaciente status;
    private String nome;
    private String endereco;
    private Integer idade;
    private String cns;
    private String cpf;
    private String contato;
    private String contatoEmergencia;
    private LocalDate dataNascimento;
    private LocalDate dataAdmissao;
    private LocalDate ultimaConsulta;

    @OneToMany(mappedBy = "pacienteAplicado")
    private List<Aplicacao> aplicacoes;

    @OneToMany(mappedBy = "pacienteConsultado")
    private List<Consulta> consultas;


}
