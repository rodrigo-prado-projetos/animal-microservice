package br.com.animal.microservice.business.object;

import br.com.animal.microservice.controller.vo.AnimalVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AdocaoBO {
    @Autowired
    private AnimalBO animalBO;

    public void adotarAnimal(AnimalVO animalVO) {
        this.animalBO.validarSeAnimalExisteNaBaseDeDados(Long.valueOf(animalVO.getIdAnimal()));
    }

}
