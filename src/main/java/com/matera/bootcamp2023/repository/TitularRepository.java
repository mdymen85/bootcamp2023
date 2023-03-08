package com.matera.bootcamp2023.repository;

import com.matera.bootcamp2023.carteira.Conta;
import com.matera.bootcamp2023.carteira.Titular;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TitularRepository extends JpaRepository<Titular, Long> {

    // select * from conta where titular_id = parametro
//    List<Conta> findByTitularId(Long id);
}