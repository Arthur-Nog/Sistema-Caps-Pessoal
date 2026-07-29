package Spring.Sistema_Caps.demo.service;

import Spring.Sistema_Caps.demo.dto.MedicamentoRequestDTO;
import Spring.Sistema_Caps.demo.dto.MedicamentoResponseDTO;
import Spring.Sistema_Caps.demo.entity.Medicamento;
import Spring.Sistema_Caps.demo.repository.MedicamentoRepository;
import org.springframework.stereotype.Service;

@Service
public class MedicamentoService {

    private final MedicamentoRepository medicamentoRepository;

    public MedicamentoService(MedicamentoRepository medicamentoRepository) {
        this.medicamentoRepository = medicamentoRepository;
    }

    //Adicionar medicamento

    public MedicamentoResponseDTO cadastrarMedicamento(MedicamentoRequestDTO dto){

        Medicamento medicamento = new Medicamento();

        medicamento.setNomeMedicamento(dto.getNomeMedicamento());
        medicamento.setDosagem(dto.getDosagem());
        medicamento.setPrincipioAtivo(dto.getPrincipioAtivo());
        medicamento.setQuantidadeInEstoque(dto.getQuantidadeInEstoque());

        Medicamento novoMedicamento = medicamentoRepository.save(medicamento);

        MedicamentoResponseDTO response = new MedicamentoResponseDTO();
        response.setNomeMedicamento(novoMedicamento.getNomeMedicamento());
        response.setDosagem(novoMedicamento.getDosagem());
        response.setPrincipioAtivo(novoMedicamento.getPrincipioAtivo());
        response.setQuantidadeInEstoque(novoMedicamento.getQuantidadeInEstoque());

        return response;
    }

    //Excluir medicamento

    public void excluirMedicamento(Long id){
        if (!medicamentoRepository.existsById(id)){
            throw new RuntimeException("Esse medicamento não existe na nossa base de dados!");
        }

        medicamentoRepository.deleteById(id);
    }
    //Alterar medicamento


    //Listar medicamentos
}
