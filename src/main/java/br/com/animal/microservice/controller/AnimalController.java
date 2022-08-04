package br.com.animal.microservice.controller;

import br.com.animal.microservice.controller.dto.AnimalDTO;
import br.com.animal.microservice.mock.MockAnimal;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AnimalController {
    @ApiOperation(value = "Retorna uma lista de animais")
    @GetMapping(value = "/animais")
    public ResponseEntity<List<AnimalDTO>> buscarTodosAnimais() {
        return ResponseEntity.ok(MockAnimal.getAnimalDTOS());
    }
}