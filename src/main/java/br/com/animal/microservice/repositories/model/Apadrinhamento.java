package br.com.animal.microservice.repositories.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;


@Data
@Entity
@Table(name = "APADRINHAMENTO")
public class Apadrinhamento {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "ID_ANIMAL")
    private String idAnimal;
    @Column(name = "ID_PESSOA")
    private int idPessoa;
    @Column
    private BigDecimal valor;
    @Column(name = "DATA_INICIO")
    private String dataInicio;
    @Column(name = "DATA_FIM")
    private String dataFim;
    @Column
    private String observacao;

}
