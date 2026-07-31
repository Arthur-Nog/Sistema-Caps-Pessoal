package Spring.Sistema_Caps.demo.service;

import Spring.Sistema_Caps.demo.dto.EstoqueRequestDTO;
import Spring.Sistema_Caps.demo.dto.EstoqueResponseDTO;
import Spring.Sistema_Caps.demo.dto.MedicamentoRequestDTO;
import Spring.Sistema_Caps.demo.dto.MedicamentoResponseDTO;
import Spring.Sistema_Caps.demo.entity.Medicamento;
import Spring.Sistema_Caps.demo.repository.MedicamentoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MedicamentoService {

    private final MedicamentoRepository medicamentoRepository;

    public MedicamentoService(MedicamentoRepository medicamentoRepository) {
        this.medicamentoRepository = medicamentoRepository;
    }

    //Adicionar medicamento

    public MedicamentoResponseDTO cadastrarMedicamento(MedicamentoRequestDTO dto){

        Medicamento medicamento = new Medicamento();

        medicamento.setNomeMedicamento(dto.nomeMedicamento());
        medicamento.setDosagem(dto.dosagem());
        medicamento.setPrincipioAtivo(dto.principioAtivo());
        medicamento.setQuantidadeInEstoque(dto.quantidadeInEstoque());

        Medicamento novoMedicamento = medicamentoRepository.save(medicamento);

        return new MedicamentoResponseDTO(novoMedicamento.getId(),
                novoMedicamento.getNomeMedicamento(),novoMedicamento.getPrincipioAtivo(),
                novoMedicamento.getDosagem(),novoMedicamento.getQuantidadeInEstoque());
    }

    //Excluir medicamento

    public void excluirMedicamento(Long id){
        if (!medicamentoRepository.existsById(id)){
            throw new RuntimeException("Esse medicamento não existe na nossa base de dados!");
        }
        medicamentoRepository.deleteById(id);
    }
    //Alterar medicamento

    public MedicamentoResponseDTO alterarMedicamento(Long id, MedicamentoRequestDTO medicamento){
        Medicamento medicamentoAntigo = medicamentoRepository.findById(id).orElseThrow(()->
                new RuntimeException("Esse medicamento não consta na nossa base de dados!"));

        medicamentoAntigo.setNomeMedicamento(medicamento.nomeMedicamento());
        medicamentoAntigo.setDosagem(medicamento.dosagem());
        medicamentoAntigo.setPrincipioAtivo(medicamento.principioAtivo());
        medicamentoAntigo.setQuantidadeInEstoque(medicamento.quantidadeInEstoque());

        Medicamento medicamentoAtualizado = medicamentoRepository.save(medicamentoAntigo);

        return new MedicamentoResponseDTO(medicamentoAtualizado.getId(), medicamentoAtualizado.getNomeMedicamento(),
                medicamentoAtualizado.getPrincipioAtivo(), medicamentoAtualizado.getDosagem(),
                medicamentoAtualizado.getQuantidadeInEstoque());
    }

    public EstoqueResponseDTO adicionarEstoqueMedicamento(Long id, EstoqueRequestDTO request){
        Integer qtd = request.qtd();

        if (qtd <= 0){
            throw new RuntimeException("Digite um valor de quantidade válido !");
        } else if (medicamentoRepository.incrementarEstoque(id,qtd) == 0) {
            throw new RuntimeException("Esse medicamento não consta na nossa base de dados!");
        }

        Medicamento medicamentoAtualizado = medicamentoRepository.findById(id).orElseThrow(()->
                 new RuntimeException("O medicamento não consta"));

        return new EstoqueResponseDTO(medicamentoAtualizado.getQuantidadeInEstoque());

    }

    //Listar medicamentos

    public List<MedicamentoResponseDTO> listarMedicamentos(){

        List <Medicamento> medicamentos = medicamentoRepository.findAll();
        if (medicamentos.isEmpty()){
            throw new RuntimeException("Não existe medicamentos salvos na base de dados!");
        }

        List<MedicamentoResponseDTO> responseList = new ArrayList<>();
        for(Medicamento m: medicamentos){
            MedicamentoResponseDTO dto = new MedicamentoResponseDTO(m.getId(),m.getNomeMedicamento(),
                    m.getPrincipioAtivo(),m.getDosagem(),m.getQuantidadeInEstoque());
            responseList.add(dto);
        }
        return responseList;
    }
}
