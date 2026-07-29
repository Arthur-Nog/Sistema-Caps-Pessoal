package Spring.Sistema_Caps.demo.service;

import Spring.Sistema_Caps.demo.dto.PacienteRequestDTO;
import Spring.Sistema_Caps.demo.dto.PacienteResponseDTO;
import Spring.Sistema_Caps.demo.entity.Paciente;
import Spring.Sistema_Caps.demo.repository.PacienteRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PacienteService {

    private final PacienteRepository pacienteRepository;

    public PacienteService (PacienteRepository pacienteRepository){
        this.pacienteRepository = pacienteRepository;
    }

    //Criar

    public PacienteResponseDTO cadastrarPaciente(PacienteRequestDTO dto){

        Paciente paciente = new Paciente();

        paciente.setNome(dto.nome());
        paciente.setStatus(dto.status());
        paciente.setIdade(dto.idade());
        paciente.setContato(dto.contato());
        paciente.setCns(dto.cns());
        paciente.setCpf(dto.cpf());
        paciente.setDataNascimento(dto.dataNascimento());
        paciente.setEndereco(dto.endereco());
        paciente.setContatoEmergencia(dto.contatoEmergencia());
        paciente.setUltimaConsulta(dto.ultimaConsulta());
        paciente.setDataAdmissao(dto.dataAdmissao());

        Paciente pacienteSalvo = pacienteRepository.save(paciente);

        PacienteResponseDTO response = new PacienteResponseDTO(pacienteSalvo.getId(),pacienteSalvo.getNome(), pacienteSalvo.getStatus(),pacienteSalvo.getEndereco(), pacienteSalvo.getIdade(), pacienteSalvo.getCns(), pacienteSalvo.getCpf(),
                pacienteSalvo.getContato(), pacienteSalvo.getContatoEmergencia(), pacienteSalvo.getDataNascimento(),
                pacienteSalvo.getUltimaConsulta(),pacienteSalvo.getDataAdmissao());

        return response;
    }
    //Remover

    public void removerPacienteById(Long id){
        if(!pacienteRepository.existsById(id)){
            throw new RuntimeException("Paciente não existe na nossa base de dados!");
        }

        pacienteRepository.deleteById(id);
    }

    //Listar

    public List<PacienteResponseDTO> listarPacientes(){

        List<Paciente> listaPacientes = pacienteRepository.findAll();
        if (listaPacientes.isEmpty()){
            throw new RuntimeException("Não existe nenhum paciente na base de dados!");
        }

        List<PacienteResponseDTO> responseList = new ArrayList<>();

        for(Paciente p:listaPacientes){
            PacienteResponseDTO dto = new PacienteResponseDTO(p.getId(),p.getNome(),p.getStatus(),p.getEndereco(),p.getIdade(), p.getCns(),
                    p.getCpf(),p.getContato(),p.getContatoEmergencia(),
                    p.getDataNascimento(),p.getUltimaConsulta(),p.getDataAdmissao());
            responseList.add(dto);
        }
        return responseList;
    }

    //ALterar dados

    public PacienteResponseDTO alterarPaciente(Long id,PacienteRequestDTO paciente){
        Paciente pacienteAntigo = pacienteRepository.findById(id).orElseThrow(() -> new RuntimeException("Paciente não encontrado!"));
        pacienteAntigo.setNome(paciente.nome());
        pacienteAntigo.setStatus(paciente.status());
        pacienteAntigo.setIdade(paciente.idade());
        pacienteAntigo.setCpf(paciente.cpf());
        pacienteAntigo.setCns(paciente.cns());
        pacienteAntigo.setEndereco(paciente.endereco());
        pacienteAntigo.setDataNascimento(paciente.dataNascimento());
        pacienteAntigo.setDataAdmissao(paciente.dataAdmissao());
        pacienteAntigo.setUltimaConsulta(paciente.ultimaConsulta());
        pacienteAntigo.setContato(paciente.contato());
        pacienteAntigo.setContatoEmergencia(paciente.contatoEmergencia());


        Paciente pacienteAtualizado = pacienteRepository.save(pacienteAntigo);

        PacienteResponseDTO response = new PacienteResponseDTO(pacienteAtualizado.getId(), pacienteAtualizado.getNome(),pacienteAtualizado.getStatus(), pacienteAtualizado.getEndereco(),
                pacienteAtualizado.getIdade(), pacienteAtualizado.getCns(), pacienteAtualizado.getCpf(), pacienteAtualizado.getContato(),
                pacienteAtualizado.getContatoEmergencia(), pacienteAtualizado.getDataNascimento(),pacienteAtualizado.getUltimaConsulta(),pacienteAtualizado.getDataAdmissao());
        return response;

    }

    //BUSCAR APLICAÇÕES



}
