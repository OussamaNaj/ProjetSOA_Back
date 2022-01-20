package com.soa.admin_manager.service;

import javax.transaction.Transactional;

import com.soa.admin_manager.model.Administrator;
import com.soa.admin_manager.repository.AdminRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class AdminService {
    private final AdminRepository adminRepository;

    @Autowired
    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public Administrator CUAdmin(Administrator administrator) {
        return adminRepository.save(administrator);
    }

    public void deleteAdmin(int cin) {
        adminRepository.deleteById(cin);
    }

    public Administrator getAdmin(int cin) {
        Administrator administrator = adminRepository.getById(cin);
        return administrator;
    }

}
