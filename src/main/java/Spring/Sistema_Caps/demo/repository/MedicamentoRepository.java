package Spring.Sistema_Caps.demo.repository;

import Spring.Sistema_Caps.demo.dto.EstoqueRequestDTO;
import Spring.Sistema_Caps.demo.entity.Medicamento;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.beans.Transient;
import java.util.Optional;

@Repository
public interface MedicamentoRepository extends JpaRepository<Medicamento,Long> {

    @Transactional
    @Modifying
    @Query("Update Medicamento m SET m.quantidadeInEstoque = m.quantidadeInEstoque+ :qtd WHERE m.id = :id")
     int incrementarEstoque(@Param("id") Long id, @Param("qtd") Integer qtd);

    @Transactional
    @Modifying
    @Query("Update Medicamento m SET m.quantidadeInEstoque = m.quantidadeInEstoque - :qtd WHERE m.id = :id")
    int decrementarEstoque(@Param("id") Long id, @Param("qtd") Integer qtd);

    Optional<Medicamento> findByNomeMedicamento(String nome);
}
