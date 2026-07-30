package Spring.Sistema_Caps.demo.controller;

import Spring.Sistema_Caps.demo.dto.PacienteRequestDTO;
import Spring.Sistema_Caps.demo.dto.PacienteResponseDTO;
import Spring.Sistema_Caps.demo.service.PacienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/paciente")
public class PacienteController {

    private final PacienteService pacienteService;

    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @PostMapping("/cadastro")
    public ResponseEntity<PacienteResponseDTO> cadastrarPaciente(@RequestBody PacienteRequestDTO dto){
        PacienteResponseDTO novoPaciente = pacienteService.cadastrarPaciente(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoPaciente);
    }

    @DeleteMapping("/remover/{id}")
    public ResponseEntity<Void> removerPaciente(@PathVariable Long id){
        pacienteService.removerPacienteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/alterar/{id}")
    public ResponseEntity<Void> alterarPaciente(@PathVariable Long id, @RequestBody PacienteRequestDTO paciente){
        pacienteService.alterarPaciente(id, paciente);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/listar")
    public List<PacienteResponseDTO> listarPacientes(){
        return pacienteService.listarPacientes();
    }




}
