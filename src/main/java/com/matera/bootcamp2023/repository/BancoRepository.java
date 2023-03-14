package com.matera.bootcamp2023.repository;

import com.matera.bootcamp2023.domain.Banco;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BancoRepository extends JpaRepository<Banco, Long> {

    Optional<Banco> findByCodigo(int codigo);
}