package Spring.Sistema_Caps.demo.service;

import Spring.Sistema_Caps.demo.dto.AplicacaoRequestDTO;
import Spring.Sistema_Caps.demo.dto.AplicacaoResponseDTO;
import Spring.Sistema_Caps.demo.repository.AplicacaoRepository;
import org.springframework.stereotype.Service;

@Service
public class AplicacaoService {

    private final AplicacaoRepository aplicacaoRepository;

    public AplicacaoService(AplicacaoRepository aplicacaoRepository) {
        this.aplicacaoRepository = aplicacaoRepository;
    }

    //Aplicar medicamento

    //Listar Aplicações
}
