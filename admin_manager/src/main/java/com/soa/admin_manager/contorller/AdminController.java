package com.soa.admin_manager.contorller;

import com.soa.admin_manager.model.Administrator;
import com.soa.admin_manager.service.AdminService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {
    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }
    @PostMapping("/cuadmin")
    public ResponseEntity<Administrator> CUAdmin(@RequestBody Administrator administrator) {
        Administrator a = adminService.CUAdmin(administrator);
        return new ResponseEntity<>(a, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{cin}")
    public ResponseEntity<?> deleteAdmin(@PathVariable("cin") int cin) {
        adminService.deleteAdmin(cin);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/get/{cin}")
    public ResponseEntity<Administrator> getAdmin(@PathVariable("cin") int cin) {
        Administrator a = adminService.getAdmin(cin);
        return new ResponseEntity<>(a, HttpStatus.OK);
    }

}
