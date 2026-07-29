package Spring.Sistema_Caps.demo.repository;

import Spring.Sistema_Caps.demo.entity.Aplicacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AplicacaoRepository extends JpaRepository<Aplicacao,Long> {
}
