package br.com.animal.microservice.mock;

import br.com.animal.microservice.repositories.AnimalRepository;
import br.com.animal.microservice.repositories.model.Animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MockAnimal {
    @Autowired
    private AnimalRepository animalRepository;

    public void inserirAnimaisNaBaseDeDados(String linhaArquivo) {
        Animal animal = obterObjetoAnimal(linhaArquivo.split("\\|"));
        this.animalRepository.save(animal);
    }

    private Animal obterObjetoAnimal(String[] linha) {
        Animal animal = new Animal();
        animal.setNome(linha[0]);
        animal.setIdade(linha[1]);
        animal.setRaca(linha[2]);
        animal.setCor(linha[3]);
        animal.setPeso(linha[4]);
        animal.setAltura(linha[5]);
        animal.setSexo(linha[6]);
        animal.setPorte(linha[7]);
        animal.setPelo(linha[8]);
        animal.setSituacao(linha[9]);
        animal.setHistoria(linha[10]);
        animal.setAdotado(Boolean.parseBoolean(linha[11]));
        animal.setApadrinhado(Boolean.parseBoolean(linha[12]));
        animal.setObservacao(linha[13]);
        return animal;
    }
}