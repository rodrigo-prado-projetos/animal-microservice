package br.com.animal.microservice.convert;

import br.com.animal.microservice.controller.dto.AnimalDTO;
import br.com.animal.microservice.repositories.model.Animal;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class AnimalConvert {
    public List<AnimalDTO> montarRespostaDeTodosAnimais(Iterable<Animal> animals) {
        List<AnimalDTO> animalDTOList = new ArrayList<>();
        animals.forEach(animal -> {
            AnimalDTO animalDTO = new AnimalDTO();
            BeanUtils.copyProperties(animal, animalDTO);
            animalDTOList.add(animalDTO);
        });
        return animalDTOList;
    }
}
