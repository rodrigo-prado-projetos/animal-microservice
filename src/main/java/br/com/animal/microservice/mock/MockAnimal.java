package br.com.animal.microservice.mock;

import br.com.animal.microservice.controller.dto.AnimalDTO;

import java.util.ArrayList;
import java.util.List;

public class MockAnimal {
    public static List<AnimalDTO> getAnimalDTOS() {
        AnimalDTO animalDTO = new AnimalDTO();
        animalDTO.setId(1);
        animalDTO.setNome("Mel");
        animalDTO.setIdade(1);
        animalDTO.setRaca("Shih-Tzu");
        animalDTO.setCor("Branco");
        animalDTO.setPeso("5,8 kg");
        animalDTO.setAltura("20 cm");
        animalDTO.setSexo("Fêmea");
        animalDTO.setPorte("Pequeno");
        animalDTO.setPelo("Longo");
        animalDTO.setSituacao("Disponivel para ser adotado (a)");
        animalDTO.setHistoria("Essa raça originou-se do cruzamento do Lhasa Apso (Tibet) com o Pequinês (China) há muitos séculos.");
        animalDTO.setAdotado(Boolean.FALSE);
        animalDTO.setApadrinhado(Boolean.FALSE);
        animalDTO.setObservacao("Brincalhão, Astuto, Extrovertido, Amigável, Vivaz");
        List<AnimalDTO> animais = new ArrayList<>();
        animais.add(animalDTO);
        return animais;
    }
}
