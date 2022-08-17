package br.com.animal.microservice.business.object;

import br.com.animal.microservice.business.service.AnimalBS;
import br.com.animal.microservice.controller.dto.AnimalDTO;
import br.com.animal.microservice.convert.AnimalConvert;
import br.com.animal.microservice.exception.AnimalAdotado;
import br.com.animal.microservice.exception.AnimalNaoEncontrado;
import br.com.animal.microservice.repositories.model.Animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class AnimalBO {
    private final AnimalBS animalBS;
    private final AnimalConvert animalConvert;

    @Autowired
    public AnimalBO(AnimalBS animalBS, AnimalConvert animalConvert) {
        this.animalBS = animalBS;
        this.animalConvert = animalConvert;
    }

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

    public void alterarStatusDoAnimalParaApadrinhado(Animal animal) {
        animal.setApadrinhado(Boolean.TRUE);
        this.animalBS.alterarStatusDoAnimalParaAdotado(animal);
    }

    public void alterarStatusDoAnimalParaAdotado(Animal animal) {
        animal.setAdotado(Boolean.TRUE);
        this.animalBS.alterarStatusDoAnimalParaAdotado(animal);
    }

    public List<AnimalDTO> buscarTodosOsAnimais() {
        return this.animalConvert.montarRespostaDeTodosAnimais(
                this.animalBS.buscarTodosOsAnimais()
        );
    }
}