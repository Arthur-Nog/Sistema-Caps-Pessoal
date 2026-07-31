package Spring.Sistema_Caps.demo.controller;

import Spring.Sistema_Caps.demo.dto.EstoqueRequestDTO;
import Spring.Sistema_Caps.demo.dto.EstoqueResponseDTO;
import Spring.Sistema_Caps.demo.dto.MedicamentoRequestDTO;
import Spring.Sistema_Caps.demo.dto.MedicamentoResponseDTO;
import Spring.Sistema_Caps.demo.service.MedicamentoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicamento")
public class MedicamentoController {

    private final MedicamentoService medicamentoService;

    public MedicamentoController(MedicamentoService medicamentoService){
        this.medicamentoService = medicamentoService;
    }


    @PostMapping("/cadastro")
    public ResponseEntity<MedicamentoResponseDTO> cadastroMedicamento(@RequestBody MedicamentoRequestDTO medicamento){
        MedicamentoResponseDTO novoMedicamento = medicamentoService.cadastrarMedicamento(medicamento);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoMedicamento);
    }

    @DeleteMapping("/remover/{id}")
    public ResponseEntity<Void> removerMedicamento(@PathVariable Long id){
        medicamentoService.excluirMedicamento(id);
        return ResponseEntity.noContent().build();
    }


    @PutMapping("/alterar/{id}")
    public ResponseEntity<MedicamentoResponseDTO> alterarMedicamento(@PathVariable Long id, @RequestBody MedicamentoRequestDTO medicamento){
        MedicamentoResponseDTO medicamentoAlterado = medicamentoService.alterarMedicamento(id,medicamento);
        return ResponseEntity.ok(medicamentoAlterado);
    }

    @PatchMapping("/alterar/estoque/{id}")
    public ResponseEntity<EstoqueResponseDTO> alterarEstoqueMedicamento(@PathVariable Long id, @RequestBody EstoqueRequestDTO request){
        EstoqueResponseDTO medicamentoAlterado = medicamentoService.adicionarEstoqueMedicamento(id,request);
        return ResponseEntity.ok(medicamentoAlterado);
    }


    @GetMapping("/listar")
    public List<MedicamentoResponseDTO> listarMedicamentos(){
        return medicamentoService.listarMedicamentos();
    }




}
