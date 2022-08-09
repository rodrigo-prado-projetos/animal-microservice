package br.com.animal.microservice.business.object;

import br.com.animal.microservice.business.service.AnimalBS;
import br.com.animal.microservice.exception.AnimalAdotado;
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

    public Animal validarSeAnimalExisteNaBaseDeDados(Long idAnimal) {
        Optional<Animal> animal = this.animalBS.buscarAnimalPorId(idAnimal);
        if (!animal.isPresent()) {
            throw new AnimalNaoEncontrado();
        }
        return animal.get();
    }

    public void validarSeAnimalFoiAdotado(boolean adotado) {
        if (adotado) {
            throw new AnimalAdotado();
        }
    }

    public void alterarStatusDoAnimalParaAdotado(Animal animal) {
        animal.setAdotado(Boolean.TRUE);
        this.animalBS.alterarStatusDoAnimalParaAdotado(animal);
    }
}