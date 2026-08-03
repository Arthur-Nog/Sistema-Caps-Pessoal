package Spring.Sistema_Caps.demo.repository;

import Spring.Sistema_Caps.demo.entity.Profissional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProfissionalRepository extends JpaRepository<Profissional,Long> {

    Optional <Profissional> findByNome(String nome);
}
