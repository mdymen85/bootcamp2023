package com.matera.bootcamp2023.carteira;


import com.matera.bootcamp2023.dto.ContaDto;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Entity
//@Table(name = "bootcamp_conta")
@Getter
@Setter
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int agencia;
    private int numero = new Random().nextInt(100000);
    private BigDecimal saldo = BigDecimal.ZERO;

    @CreationTimestamp
    private LocalDateTime dataCriacao;
    @UpdateTimestamp
    private LocalDateTime dataUltimaAtualizacao;

    @ManyToOne
    @JoinColumn(name = "nome_coluna_titular_id")
    private Titular titular;

    @ManyToMany
    @JoinTable(name = "conta_tipos_tarifa",
            joinColumns = @JoinColumn(name = "conta_id"),
            inverseJoinColumns = @JoinColumn(name = "tipo_tarifa_id")
    )
    private List<TipoTarifa> tiposTarifa = new ArrayList<>();

    public Conta() {
    }


    //credito, debito
    public void credito(BigDecimal valor) {

        this.validar(valor);

        saldo.add(valor);

    }

    public void debito(BigDecimal valor) {

        this.validar(valor);

        // -1 se for menor
        // 0 se for igual
        // 1 se for maior

        // valor = 100
        // saldo = 250
        // 100.compareTo(250) > 0 -> -1
        //if (-1 > 0) { nao entro }

        // valor = 100
        // saldo = 50

        // 100.compareTo(50) > 0 -> 1
        //if (1 > 0) { sim entro }

        if (valor.compareTo(saldo) > 0) {
            throw new RuntimeException();
        }

        saldo.subtract(valor);

    }

    /**
     * este metodo...
     *
     * @param valor
     */
    private void validar(BigDecimal valor) {

        if (valor == null) {
            throw new RuntimeException();
        }

        if (this.valorIncorreto(valor)) {
            throw new RuntimeException();
        }

    }

    private boolean valorIncorreto(BigDecimal valor) {
        //NPE
        return valor.compareTo(BigDecimal.ZERO) <= 0;
    }

    public ContaDto toContaDto() {
        ContaDto dto = new ContaDto();
        dto.setAgencia(this.getAgencia());
        dto.setNumero(this.getNumero());
        dto.setSaldo(this.getSaldo());
        return dto;
    }


}