package br.com.animal.microservice.controller.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Data
public class AnimalVO {
    @NotNull(message = "Campo idAnimal, não pode ser nulo.")
    @NotBlank(message = "Campo idAnimal, não pode ser vazio.")
    private int idAnimal;
    @NotNull(message = "Campo idPessoa, não pode ser nulo.")
    @NotBlank(message = "Campo idPessoa, não pode ser vazio.")
    private int idPessoa;
    @JsonIgnore
    private LocalDateTime localDateTime = LocalDateTime.now();
    @Size(max = 1000, message = "Campo observação deve ter no máximo 1000 caracteres.")
    private String observacao;
}