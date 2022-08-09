package br.com.animal.microservice.exception;

public class AnimalAdotado extends RuntimeException {
    public AnimalAdotado() {
        super("Animal já foi adotado");
    }
}
