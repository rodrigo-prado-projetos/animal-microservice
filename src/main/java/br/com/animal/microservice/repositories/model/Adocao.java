package br.com.animal.microservice.repositories.model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;


@Data
@Entity
@Table(name = "APADRINHAMENTO")
@ToString
public class Adocao {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "ID_ANIMAL")
    private int idAnimal;
    @Column(name = "ID_PESSOA")
    private int idPessoa;
    @Column
    private String data;
    @Column
    private String observacao;
}