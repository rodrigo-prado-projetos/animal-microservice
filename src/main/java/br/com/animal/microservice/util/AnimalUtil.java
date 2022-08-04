package br.com.animal.microservice.util;

import br.com.animal.microservice.exception.AnimalNaoEncontrado;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AnimalUtil {
    public void validarSeAnimalExisteNaBaseDeDados(Object animal) {
        Optional<Object> optional = (Optional<Object>) animal;
        if (!optional.isPresent()) {
            throw new AnimalNaoEncontrado();
        }
    }
}
