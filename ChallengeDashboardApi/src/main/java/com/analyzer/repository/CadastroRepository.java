package com.analyzer.repository;

import com.analyzer.model.Cadastro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CadastroRepository extends JpaRepository<Cadastro, Long> {
    Optional<Cadastro> findByEmail(String email);
}

