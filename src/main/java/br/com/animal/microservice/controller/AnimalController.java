package br.com.animal.microservice.controller;

import br.com.animal.microservice.business.object.AdocaoBO;
import br.com.animal.microservice.business.object.AnimalBO;
import br.com.animal.microservice.controller.dto.AnimalDTO;
import br.com.animal.microservice.controller.vo.AnimalVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AnimalController {
    @Autowired
    private AdocaoBO adocaoBO;
    @Autowired
    private AnimalBO animalBO;

    @ApiOperation(value = "Retorna uma lista de animais")
    @GetMapping(value = "/animais")
    public ResponseEntity<List<AnimalDTO>> buscarTodosAnimais() {
        return ResponseEntity.ok(animalBO.buscarTodosOsAnimais());
    }

    @PostMapping
    public ResponseEntity<Object> adotarAnimal(@RequestBody AnimalVO animalVO) {
        this.adocaoBO.adotarAnimal(animalVO);
        return null;
    }
}