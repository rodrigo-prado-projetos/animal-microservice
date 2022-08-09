package br.com.animal.microservice.business.object;

import br.com.animal.microservice.business.service.AdocaoBS;
import br.com.animal.microservice.controller.vo.AnimalVO;
import br.com.animal.microservice.repositories.model.Animal;
import br.com.animal.microservice.repositories.model.Pessoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AdocaoBO {
    private final AnimalBO animalBO;
    private final PessoaBO pessoaBO;
    private final ApadrinhamentoBO apadrinhamentoBO;
    private final AdocaoBS adocaoBS;

    @Autowired
    public AdocaoBO(AnimalBO animalBO, PessoaBO pessoaBO, ApadrinhamentoBO apadrinhamentoBO, AdocaoBS adocaoBS) {
        this.animalBO = animalBO;
        this.pessoaBO = pessoaBO;
        this.apadrinhamentoBO = apadrinhamentoBO;
        this.adocaoBS = adocaoBS;
    }

    public void adotarAnimal(AnimalVO animalVO) {
        Animal animal = this.animalBO.validarSeAnimalExisteNaBaseDeDados(Long.valueOf(animalVO.getIdAnimal()));

        Pessoa pessoa = this.pessoaBO.validarSePessoaExisteNaBaseDeDados(Long.valueOf(animalVO.getIdPessoa()));

        this.animalBO.validarSeAnimalFoiAdotado(animal.isAdotado());

        this.apadrinhamentoBO.validarSeAnimalEstaSendoApadrinhado(animal);

        this.animalBO.alterarStatusDoAnimalParaAdotado(animal);

        this.adocaoBS.salvarAdocaoDoAnimal(animal, pessoa);
    }
}
