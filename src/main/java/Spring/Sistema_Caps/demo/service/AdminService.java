package Spring.Sistema_Caps.demo.service;

import Spring.Sistema_Caps.demo.dto.AdminRequestDTO;
import Spring.Sistema_Caps.demo.dto.AdminResponseDTO;
import Spring.Sistema_Caps.demo.entity.Admin;
import Spring.Sistema_Caps.demo.repository.AdminRepository;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    private final AdminRepository adminRepository;

    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public AdminResponseDTO cadastrarAdmin(AdminRequestDTO dto){
        Admin novoAdmin = new Admin();
        novoAdmin.setLogin(dto.login());
        novoAdmin.setSenha(dto.senha());

        Admin adminSalvo = adminRepository.save(novoAdmin);

      return new AdminResponseDTO(adminSalvo.getId(),adminSalvo.getLogin());

    }

    public void removerAdmin(Long id){
        if (!adminRepository.existsById(id)){
            throw new RuntimeException("Esse ID não existe");
        }
        adminRepository.deleteById(id);
    }


}
