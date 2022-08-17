package br.com.animal.microservice.convert;

import br.com.animal.microservice.controller.dto.AnimalDTO;
import br.com.animal.microservice.repositories.model.Animal;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AnimalConvert {
    public List<AnimalDTO> montarRespostaDeTodosAnimais(Iterable<Animal> animais) {
        List<AnimalDTO> animaisDto = new ArrayList<>();
        animais.forEach(animal -> {
            AnimalDTO animalDTO = new AnimalDTO();
            BeanUtils.copyProperties(animal, animalDTO);
            animaisDto.add(animalDTO);
        });
        return animaisDto;
    }
}
