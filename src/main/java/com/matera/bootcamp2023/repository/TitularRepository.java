package com.matera.bootcamp2023.repository;

import com.matera.bootcamp2023.domain.Titular;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TitularRepository extends JpaRepository<Titular, Long> {

    // select * from conta where titular_id = parametro
//    List<Conta> findByTitularId(Long id);
}