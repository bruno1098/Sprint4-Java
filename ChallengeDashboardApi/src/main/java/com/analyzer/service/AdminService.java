package com.analyzer.service;

import com.analyzer.model.Admin;
import com.analyzer.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public List<Admin> listarTodos() {
        return adminRepository.findAll();
    }

    public Optional<Admin> buscarPorId(Long id) {
        return adminRepository.findById(id);
    }

    public Admin salvar(Admin admin) {
        return adminRepository.save(admin);
    }

    public void deletarPorId(Long id) {
        adminRepository.deleteById(id);
    }
}