package Spring.Sistema_Caps.demo.repository;

import Spring.Sistema_Caps.demo.entity.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;


@Repository
public interface ConsultaRepository extends JpaRepository<Consulta,Long> {

    List<Consulta> findByDataConsulta(LocalDate data);
    List<Consulta> findByPacienteConsultadoId(Long id);
    List<Consulta> findByProfissionalAtendenteId(Long id);
}
