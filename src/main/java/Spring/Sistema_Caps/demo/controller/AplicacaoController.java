package Spring.Sistema_Caps.demo.controller;

import Spring.Sistema_Caps.demo.dto.AplicacaoRequestDTO;
import Spring.Sistema_Caps.demo.dto.AplicacaoResponseDTO;
import Spring.Sistema_Caps.demo.service.AplicacaoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/aplicacao")
public class AplicacaoController {

    private final AplicacaoService aplicacaoService;

    public AplicacaoController(AplicacaoService aplicacaoService){
        this.aplicacaoService = aplicacaoService;
    }

    @PostMapping("/realizar")
    public ResponseEntity<AplicacaoResponseDTO> realizarAplicacao(@RequestBody AplicacaoRequestDTO request){
        AplicacaoResponseDTO novaAplicacao = aplicacaoService.realizarAplicacao(request);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(novaAplicacao);
    }

    @GetMapping("/buscar/data")
    public List<AplicacaoResponseDTO> listarAplicacoesData(@RequestParam LocalDate data){
        return aplicacaoService.listarAplicacaoData(data);
    }

    @GetMapping("/buscar/paciente")
    public List<AplicacaoResponseDTO> listarAplicacoesPaciente(@RequestParam Long id){
        return aplicacaoService.listarAplicacaoPaciente(id);
    }
}
