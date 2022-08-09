package br.com.animal.microservice.exception;

public class PessoaNaoEncontrado extends RuntimeException {
    public PessoaNaoEncontrado() {
        super("Pessoa não cadastrado(a) na base de dados");
    }
}