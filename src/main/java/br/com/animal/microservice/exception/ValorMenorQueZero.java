package br.com.animal.microservice.exception;

public class ValorMenorQueZero extends RuntimeException {
    public ValorMenorQueZero() {
        super("O valor para o apadrinhamento deve ser maior que 0");
    }
}
