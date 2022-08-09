package br.com.animal.microservice.repositories.model;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name = "PESSOA")
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String nome;
    @Column
    private int idade;
    @Column
    private String cpf;
    @Column
    private String endereco;
    @Column
    private String cidade;
    @Column
    private String estado;
    @Column
    private int numero;
    @Column
    private String telefone;
}
