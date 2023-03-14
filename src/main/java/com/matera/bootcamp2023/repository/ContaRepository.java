package com.matera.bootcamp2023.repository;

import com.matera.bootcamp2023.domain.Conta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ContaRepository extends JpaRepository<Conta, Long> {

    Optional<Conta> findByAgenciaAndNumero(int agencia, int numero);

    Optional<Conta> findByPix(String chavePix);

}