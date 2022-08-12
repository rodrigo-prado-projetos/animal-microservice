package br.com.animal.microservice.controller.vo;

import br.com.animal.microservice.exception.ValorMenorQueZero;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
public class ApadrinhamentoVO extends AnimalVO {
    @NotNull(message = "Campo valor, não pode ser nulo.")
    private BigDecimal valor;

    public void validarSeOValorDoApadrinhamentoEMaiorQueZero() {
        if (this.valor.compareTo(BigDecimal.ZERO) <= 0) {
            throw new ValorMenorQueZero();
        }
    }
}
