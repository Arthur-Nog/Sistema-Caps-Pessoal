package Spring.Sistema_Caps.demo.controller;

import Spring.Sistema_Caps.demo.dto.AdminRequestDTO;
import Spring.Sistema_Caps.demo.dto.AdminResponseDTO;
import Spring.Sistema_Caps.demo.entity.Admin;
import Spring.Sistema_Caps.demo.service.AdminService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    public final AdminService adminService;

    public AdminController(AdminService adminService){
        this.adminService = adminService;
    }


    @PostMapping
    public ResponseEntity<AdminResponseDTO> cadastrarAdmin(@RequestBody AdminRequestDTO dto){
        AdminResponseDTO novoAdmin = adminService.cadastrarAdmin(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoAdmin);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerAdmin(@PathVariable Long id){
         adminService.removerAdmin(id);
         return ResponseEntity.noContent().build();
    }
}
