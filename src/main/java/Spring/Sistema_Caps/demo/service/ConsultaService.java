package Spring.Sistema_Caps.demo.service;

import Spring.Sistema_Caps.demo.dto.ConsultaRequestDTO;
import Spring.Sistema_Caps.demo.dto.ConsultaResponseDTO;
import Spring.Sistema_Caps.demo.entity.Consulta;
import Spring.Sistema_Caps.demo.entity.Paciente;
import Spring.Sistema_Caps.demo.entity.Profissional;
import Spring.Sistema_Caps.demo.repository.ConsultaRepository;
import Spring.Sistema_Caps.demo.repository.PacienteRepository;
import Spring.Sistema_Caps.demo.repository.ProfissionalRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ConsultaService {
    private final ConsultaRepository consultaRepository;
    private final PacienteRepository pacienteRepository;
    private final ProfissionalRepository profissionalRepository;

    public ConsultaService(ConsultaRepository consultaRepository, PacienteRepository pacienteRepository, ProfissionalRepository profissionalRepository) {
        this.consultaRepository = consultaRepository;
        this.pacienteRepository = pacienteRepository;
        this.profissionalRepository = profissionalRepository;
    }

    public ConsultaResponseDTO realizarConsulta(ConsultaRequestDTO dto) {

        Consulta consulta = new Consulta();

        Paciente paciente = pacienteRepository.findByNome(dto.pacienteConsultado()).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND,"Esse paciente não consta na base de dados"));
        Profissional profissional = profissionalRepository.findByNome(dto.profissionalAtendente()).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND,"Esse profissional não consta na base de dados!"));

        consulta.setPacienteConsultado(paciente);
        consulta.setProfissionalAtendente(profissional);
        consulta.setDataConsulta(dto.dataConsulta());
        consulta.setObs(dto.obs());

        Consulta consultaSalva = consultaRepository.save(consulta);

        return new ConsultaResponseDTO(consultaSalva.getId(),consultaSalva.getPacienteConsultado().getNome(),consultaSalva.getProfissionalAtendente().getNome()
        ,consultaSalva.getDataConsulta(),consultaSalva.getObs());
    }

    //Listar todas consultas
    public List<ConsultaResponseDTO> listarConsultas(){
        List<Consulta> consultas = consultaRepository.findAll();
        if(consultas.isEmpty()){
            throw new RuntimeException("Sem consultas na base de dados!");
        }

        List<ConsultaResponseDTO> responseList = new ArrayList<>();
        for (Consulta c:consultas){
            ConsultaResponseDTO dto = new ConsultaResponseDTO(c.getId(),c.getPacienteConsultado().getNome(),
                    c.getProfissionalAtendente().getNome(),c.getDataConsulta(),c.getObs());
            responseList.add(dto);
        }
        return responseList;
    }

    //Listar consultas por data

    public List<ConsultaResponseDTO> listarPorData(LocalDate data){

        List <Consulta> consultas = consultaRepository.findByDataConsulta(data);

        if(consultas.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Sem consultas para essa data!");
        }

        List <ConsultaResponseDTO> responseList = new ArrayList<>();

        for (Consulta c : consultas){
                ConsultaResponseDTO dto = new ConsultaResponseDTO(c.getId(),c.getPacienteConsultado().getNome(),
                        c.getProfissionalAtendente().getNome(),c.getDataConsulta(),c.getObs());
                responseList.add(dto);
            }
        return responseList;
    }

    //Listar consultas por paciente

    public List<ConsultaResponseDTO> listarPorPaciente(Long id){

        List <Consulta> consultas = consultaRepository.findByPacienteConsultadoId(id);
        if (consultas.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Não existem consultas desse paciente!");
        }

        List <ConsultaResponseDTO> responseList = new ArrayList<>();

        for (Consulta c : consultas){
            ConsultaResponseDTO dto = new ConsultaResponseDTO(c.getId(),c.getPacienteConsultado().getNome(),
                    c.getProfissionalAtendente().getNome(),c.getDataConsulta(),c.getObs());
            responseList.add(dto);
        }
        return responseList;
    }
    //Listar consultas por profissional

    public List<ConsultaResponseDTO> listarPorProfissional(Long id){

        List <Consulta> consultas = consultaRepository.findByProfissionalAtendenteId(id);
        if (consultas.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Não existem consultas desse paciente!");
        }

        List <ConsultaResponseDTO> responseList = new ArrayList<>();

        for (Consulta c : consultas){
            ConsultaResponseDTO dto = new ConsultaResponseDTO(c.getId(),c.getPacienteConsultado().getNome(),
                    c.getProfissionalAtendente().getNome(),c.getDataConsulta(),c.getObs());
            responseList.add(dto);
        }
        return responseList;
    }

}
