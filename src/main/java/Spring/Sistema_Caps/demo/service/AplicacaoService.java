package Spring.Sistema_Caps.demo.service;

import Spring.Sistema_Caps.demo.dto.AplicacaoRequestDTO;
import Spring.Sistema_Caps.demo.dto.AplicacaoResponseDTO;
import Spring.Sistema_Caps.demo.dto.ConsultaResponseDTO;
import Spring.Sistema_Caps.demo.entity.Aplicacao;
import Spring.Sistema_Caps.demo.entity.Medicamento;
import Spring.Sistema_Caps.demo.entity.Paciente;
import Spring.Sistema_Caps.demo.entity.Profissional;
import Spring.Sistema_Caps.demo.repository.AplicacaoRepository;
import Spring.Sistema_Caps.demo.repository.MedicamentoRepository;
import Spring.Sistema_Caps.demo.repository.PacienteRepository;
import Spring.Sistema_Caps.demo.repository.ProfissionalRepository;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class AplicacaoService {

    private final AplicacaoRepository aplicacaoRepository;
    private final PacienteRepository pacienteRepository;
    private final ProfissionalRepository profissionalRepository;
    private final MedicamentoRepository medicamentoRepository;

    public AplicacaoService(AplicacaoRepository aplicacaoRepository, PacienteRepository pacienteRepository, ProfissionalRepository profissionalRepository, MedicamentoRepository medicamentoRepository) {
        this.aplicacaoRepository = aplicacaoRepository;
        this.pacienteRepository = pacienteRepository;
        this.profissionalRepository = profissionalRepository;
        this.medicamentoRepository = medicamentoRepository;
    }

    //Aplicar medicamento

    @Transactional
    public AplicacaoResponseDTO realizarAplicacao(AplicacaoRequestDTO dto){

        Paciente paciente = pacienteRepository.findByNome(dto.paciente()).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND,"Esse paciente não consta na nossa base de dados!"));

        Profissional profissional = profissionalRepository.findByNome(dto.profissional()).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND,"Esse profissional não consta na nossa base de dados!"));

        Medicamento medicamento = medicamentoRepository.findByNomeMedicamento(dto.medicamento()).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND,"Esse medicamento não consta na nossa base de dados!"));
        if (dto.qtdAplicada() > medicamento.getQuantidadeInEstoque()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "A quantidade em estoque é insuficiente!");
        }

        medicamento.setQuantidadeInEstoque(medicamento.getQuantidadeInEstoque() - dto.qtdAplicada());

        Aplicacao aplicacao = new Aplicacao();
        aplicacao.setPacienteAplicado(paciente);
        aplicacao.setProfissional(profissional);
        aplicacao.setMedicamento(medicamento);
        aplicacao.setDataAplicacao(dto.dataAplicacao());
        aplicacao.setObs(dto.obs());
        aplicacao.setQtdAplicada(dto.qtdAplicada());

        Aplicacao aplicacaoSalva = aplicacaoRepository.save(aplicacao);

        return new AplicacaoResponseDTO(aplicacaoSalva.getId(),aplicacaoSalva.getPacienteAplicado().getNome(),aplicacaoSalva.getProfissional().getNome(),
                aplicacaoSalva.getMedicamento().getNomeMedicamento(),aplicacaoSalva.getDataAplicacao(),aplicacaoSalva.getQtdAplicada(),aplicacaoSalva.getObs());

    }

    //Listar Aplicações(DATA)

    public List<AplicacaoResponseDTO> listarAplicacaoData(LocalDate data){

        List<Aplicacao> aplicacaoList = aplicacaoRepository.findByDataAplicacao(data);
        if(aplicacaoList.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Não existem aplicações para essa data !");
        }

        List<AplicacaoResponseDTO> responseList = new ArrayList<>();

        for(Aplicacao a: aplicacaoList){
            AplicacaoResponseDTO dto = new AplicacaoResponseDTO(a.getId(),a.getPacienteAplicado().getNome(),
                    a.getProfissional().getNome(),a.getMedicamento().getNomeMedicamento(),a.getDataAplicacao(),a.getQtdAplicada(),a.getObs());

            responseList.add(dto);
        }
        return responseList;
    }

    //Listar Aplicações(PACIENTE)

    public List<AplicacaoResponseDTO> listarAplicacaoPaciente(Long id){
        List<Aplicacao> aplicacaoList = aplicacaoRepository.findByPacienteAplicadoId(id);

        if(aplicacaoList.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Não existem aplicações para esse paciente !");
        }

        List<AplicacaoResponseDTO> responseList = new ArrayList<>();
        for (Aplicacao a : aplicacaoList){
            AplicacaoResponseDTO dto = new AplicacaoResponseDTO(a.getId(),a.getPacienteAplicado().getNome(),a.getProfissional().getNome(),a.getMedicamento().getNomeMedicamento(),
                    a.getDataAplicacao(),a.getQtdAplicada(),a.getObs());
            responseList.add(dto);
        }
        return responseList;
    }

}
