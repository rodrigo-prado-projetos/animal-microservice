package br.com.animal.microservice.controller.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AnimalDTO {
    private int id;
    private String nome;
    private String idade;
    private String raca;
    private String cor;
    private String peso;
    private String altura;
    private String sexo;
    private String porte;
    private String pelo;
    private String situacao;
    private String historia;
    private boolean adotado;
    private boolean apadrinhado;
    private String observacao;
}
