package br.com.animal.microservice.business.service;

import br.com.animal.microservice.repositories.AnimalRepository;
import br.com.animal.microservice.repositories.model.Animal;
import br.com.animal.microservice.util.ConstantsUtil;
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
            log.error(ConstantsUtil.ERRO_BUSCAR_ANIMAL, id);
            throw new RuntimeException(e.getCause());
        }
    }

    public void alterarStatusDoAnimalParaAdotado(Animal animal) {
        try {
            this.animalRepository.save(animal);
        } catch (Exception e) {
            log.error(ConstantsUtil.ERRO_ALTERAR_ANIMAL, animal.toString());
            throw new RuntimeException(e.getCause());
        }
    }

    public Iterable<Animal> buscarTodosOsAnimais() {
        try {
            return this.animalRepository.findAll();
        } catch (Exception e) {
            log.error(ConstantsUtil.ERRO_BUSCAR_LISTA_ANIMAL, e);
            throw new RuntimeException(e.getCause());
        }
    }
}