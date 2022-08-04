package br.com.animal.microservice.business.object;

import br.com.animal.microservice.business.service.AnimalBS;
import br.com.animal.microservice.exception.AnimalNaoEncontrado;
import br.com.animal.microservice.repositories.model.Animal;
import br.com.animal.microservice.util.AnimalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AnimalBO {
    @Autowired
    private AnimalBS animalBS;
    @Autowired
    private AnimalUtil animalUtil;

    public void validarSeAnimalExisteNaBaseDeDados(Long idAnimal) {
        Optional<Animal> animal = this.animalBS.buscarAnimalPorId(idAnimal);
        if (!animal.isPresent()) {
            throw new AnimalNaoEncontrado();
        }
    }

    public void alterarStatusDoAnimalParaAdotado(Animal animal) {
        this.animalBS.alterarStatusDoAnimalParaAdotado(animal);
    }

}