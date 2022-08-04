package br.com.animal.microservice.exception;

public class AnimalNaoEncontrado extends RuntimeException {
    public AnimalNaoEncontrado() {
        super("Animal não cadastrado na base de dados");
    }
}
