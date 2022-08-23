package br.com.animal.microservice.controller;

import br.com.animal.microservice.business.object.AdocaoBO;
import br.com.animal.microservice.business.object.AnimalBO;
import br.com.animal.microservice.business.object.ApadrinhamentoBO;
import br.com.animal.microservice.controller.dto.AnimalDTO;
import br.com.animal.microservice.controller.vo.AnimalVO;
import br.com.animal.microservice.controller.vo.ApadrinhamentoVO;
import br.com.animal.microservice.util.ConstantsUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AnimalController {
    private final AdocaoBO adocaoBO;
    private final ApadrinhamentoBO apadrinhamentoBO;
    private final AnimalBO animalBO;

    @Autowired
    public AnimalController(AdocaoBO adocaoBO, ApadrinhamentoBO apadrinhamentoBO, AnimalBO animalBO) {
        this.adocaoBO = adocaoBO;
        this.apadrinhamentoBO = apadrinhamentoBO;
        this.animalBO = animalBO;
    }

    @CrossOrigin
    @ApiOperation(value = "Retorna uma lista de animais")
    @GetMapping(value = ConstantsUtil.ANIMAIS)
    public ResponseEntity<List<AnimalDTO>> buscarTodosAnimais() {
        return ResponseEntity.ok(animalBO.buscarTodosOsAnimais());
    }

    @CrossOrigin
    @ApiOperation(value = "Adotar um animal")
    @PostMapping(value = ConstantsUtil.ADOTAR)
    public ResponseEntity<Object> adotarAnimal(@RequestBody AnimalVO animalVO) {
        this.adocaoBO.adotarAnimal(animalVO);
        return ResponseEntity.ok("Animal adotado com sucesso.");
    }

    @CrossOrigin
    @ApiOperation(value = "Apadrinhar um animal")
    @PostMapping(value = ConstantsUtil.APADRINHAR)
    public ResponseEntity<Object> apadrinharAnimal(@RequestBody ApadrinhamentoVO apadrinhamentoVO) {
        this.apadrinhamentoBO.apadrinharAnimal(apadrinhamentoVO);
        return ResponseEntity.ok("Animal apadrinhado com sucesso.");
    }
}