package Spring.Sistema_Caps.demo.controller;

import Spring.Sistema_Caps.demo.dto.ConsultaRequestDTO;
import Spring.Sistema_Caps.demo.dto.ConsultaResponseDTO;
import Spring.Sistema_Caps.demo.service.ConsultaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/consulta")
public class ConsultaController {
    private final ConsultaService consultaService;

    public ConsultaController(ConsultaService consultaService) {
        this.consultaService = consultaService;
    }

    @PostMapping("/cadastro")
    public ResponseEntity<ConsultaResponseDTO> registrarConsulta(@RequestBody ConsultaRequestDTO dto){
        ConsultaResponseDTO consultaNova = consultaService.realizarConsulta(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(consultaNova);
    }

    @GetMapping("/listar")
    public List<ConsultaResponseDTO> listarConsultas(){
        return consultaService.listarConsultas();
    }

    @GetMapping("/listarData")
    public List<ConsultaResponseDTO> listarPorData(@RequestParam LocalDate data){
        return consultaService.listarPorData(data);
    }

    @GetMapping("/listarPaciente")
    public List<ConsultaResponseDTO> listarPorPaciente(@RequestParam Long id){
        return consultaService.listarPorPaciente(id);
    }

    @GetMapping("/listarProfissional")
    public List<ConsultaResponseDTO> listarPorProfissional(@RequestParam Long id){
        return consultaService.listarPorProfissional(id);
    }
}
