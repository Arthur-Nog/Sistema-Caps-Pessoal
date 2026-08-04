package Spring.Sistema_Caps.demo.repository;

import Spring.Sistema_Caps.demo.entity.Aplicacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AplicacaoRepository extends JpaRepository<Aplicacao,Long> {

    List<Aplicacao> findByDataAplicacao(LocalDate data);
    List<Aplicacao> findByPacienteAplicadoId(Long id);
}
