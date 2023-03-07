package com.matera.bootcamp2023.repository;

import com.matera.bootcamp2023.carteira.Conta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ContaRepository extends JpaRepository<Conta, Long> {

}