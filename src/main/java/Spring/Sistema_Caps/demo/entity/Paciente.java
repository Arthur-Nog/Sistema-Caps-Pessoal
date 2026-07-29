package Spring.Sistema_Caps.demo.entity;

import Spring.Sistema_Caps.demo.model.enums.StatusPaciente;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
    private String idade;
    private String cns;
    private String cpf;
    private String contato;
    private String contatoEmergencia;
    private LocalDate dataNascimento;
    private LocalDate dataAdmissao;
    @OneToMany
    private List<Aplicacao> aplicacoes;
    private LocalDate ultimaConsulta;


}
