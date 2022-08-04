package br.com.animal.microservice.repositories.model;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name = "ANIMAL")
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String nome;
    @Column
    private int idade;
    @Column
    private String raca;
    @Column
    private String cor;
    @Column
    private String peso;
    @Column
    private String altura;
    @Column
    private String sexo;
    @Column
    private String porte;
    @Column
    private String pelo;
    @Column
    private String situacao;
    @Column
    private String historia;
    @Column
    private boolean adotado;
    @Column
    private boolean apadrinhado;
    @Column
    private String observacao;
}
