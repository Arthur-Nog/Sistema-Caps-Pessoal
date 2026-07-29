package Spring.Sistema_Caps.demo.controller;

import Spring.Sistema_Caps.demo.dto.ProfissionalRequestDTO;
import Spring.Sistema_Caps.demo.dto.ProfissionalResponseDTO;
import Spring.Sistema_Caps.demo.entity.Profissional;
import Spring.Sistema_Caps.demo.service.ProfissionalService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profissional")
public class ProfissionalController {

    public final ProfissionalService profissionalService;

    public ProfissionalController(ProfissionalService profissionalService){
        this.profissionalService = profissionalService;
    }

    @PostMapping
    public ResponseEntity<ProfissionalResponseDTO> cadastrarProfissional(@RequestBody ProfissionalRequestDTO dto){
        ProfissionalResponseDTO novoProfissional = profissionalService.cadastrarProfissional(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoProfissional);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerProfissional(@PathVariable Long id){
        profissionalService.removerProfissionalById(id);
        return ResponseEntity.noContent().build();
    }


    @GetMapping("/listaprofs")
    public List<ProfissionalResponseDTO> listarProfissionais(){
        return profissionalService.listarProfissionais();
    }
}
