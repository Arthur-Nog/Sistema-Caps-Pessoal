package Spring.Sistema_Caps.demo.service;

import Spring.Sistema_Caps.demo.dto.ProfissionalRequestDTO;
import Spring.Sistema_Caps.demo.dto.ProfissionalResponseDTO;
import Spring.Sistema_Caps.demo.entity.Profissional;
import Spring.Sistema_Caps.demo.repository.ProfissionalRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProfissionalService {

    private final ProfissionalRepository profissionalRepository;

    public ProfissionalService(ProfissionalRepository profissionalRepository){
        this.profissionalRepository = profissionalRepository;
    }

    public ProfissionalResponseDTO cadastrarProfissional(ProfissionalRequestDTO dto){
        Profissional profissional = new Profissional();

        profissional.setNome(dto.nome());
        profissional.setTipoProfissional(dto.tipoProfissional());
        profissional.setContato(dto.contato());
        profissional.setCadastroRegional(dto.cadastroRegional());
        profissional.setCpf(dto.cpf());
        profissional.setLogin(dto.login());
        profissional.setSenha(dto.senha());
        profissional.setEndereco(dto.endereco());

        Profissional profissionalSalvo = profissionalRepository.save(profissional);

        ProfissionalResponseDTO response = new ProfissionalResponseDTO(profissionalSalvo.getId(), profissionalSalvo.getTipoProfissional(),
                profissionalSalvo.getCadastroRegional(), profissionalSalvo.getNome(), profissionalSalvo.getEndereco(),
                profissionalSalvo.getContato(), profissionalSalvo.getCpf(), profissionalSalvo.getLogin());

        return response;

    }
    public void removerProfissionalById(Long id){
        if (!profissionalRepository.existsById(id)){
            throw new RuntimeException("Esse id não existe !");
        }
            profissionalRepository.deleteById(id);
    }

    public List<ProfissionalResponseDTO> listarProfissionais(){

        List<Profissional> listaProfissionais = profissionalRepository.findAll();

        List<ProfissionalResponseDTO> responseList = new ArrayList<>();

        for(Profissional p :listaProfissionais){
            ProfissionalResponseDTO dto =  new ProfissionalResponseDTO(p.getId(),p.getTipoProfissional(),
                    p.getCadastroRegional(), p.getNome(), p.getEndereco(), p.getContato(), p.getCpf(), p.getLogin());

            responseList.add(dto);
        }

        return responseList;
    }
}
