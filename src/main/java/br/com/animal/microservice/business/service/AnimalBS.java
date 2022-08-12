package br.com.animal.microservice.business.service;

import br.com.animal.microservice.repositories.AnimalRepository;
import br.com.animal.microservice.repositories.model.Animal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class AnimalBS {
    private AnimalRepository animalRepository;

    @Autowired
    public AnimalBS(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    public Optional<Animal> buscarAnimalPorId(Long id) {
        try {
            return this.animalRepository.findById(id);
        } catch (Exception e) {
            log.error("Ocorreu um erro ao tenta buscar o animal pelo id: {}", id);
            throw new RuntimeException(e.getCause());
        }
    }

    public void alterarStatusDoAnimalParaAdotado(Animal animal) {
        try {
            animalRepository.save(animal);
        } catch (Exception e) {
            log.error("Ocorreu um erro ao tenta alterar o animal na base de dados: ", animal.toString());
            throw new RuntimeException(e.getCause());
        }
    }

    public Iterable<Animal> buscarTodosOsAnimais() {
        try {
            return animalRepository.findAll();
        } catch (Exception e) {
            log.error("Ocorreu um erro ao tenta buscar a lista de animais na base de dados: ", e);
            throw new RuntimeException(e.getCause());
        }
    }
}
