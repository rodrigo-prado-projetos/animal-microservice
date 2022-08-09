package br.com.animal.microservice.business.service;

import br.com.animal.microservice.repositories.AdocaoRepository;
import br.com.animal.microservice.repositories.model.Adocao;
import br.com.animal.microservice.repositories.model.Animal;
import br.com.animal.microservice.repositories.model.Pessoa;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Slf4j
public class AdocaoBS {
    private final AdocaoRepository adocaoRepository;

    @Autowired
    public AdocaoBS(AdocaoRepository adocaoRepository) {
        this.adocaoRepository = adocaoRepository;
    }

    public void salvarAdocaoDoAnimal(Animal animal, Pessoa pessoa) {
        Adocao adocao = montarObjetoAdocao(Math.toIntExact(animal.getId()), pessoa);
        try {
            this.adocaoRepository.save(adocao);
        } catch (Exception e) {
            log.error("Ocorreu um erro ao tentar criar adocao na base de dados: ", adocao);
            throw new RuntimeException(e.getCause());
        }

    }

    private Adocao montarObjetoAdocao(int idAnimal, Pessoa pessoa) {
        Adocao adocao = new Adocao();
        adocao.setData(String.valueOf(LocalDateTime.now()));
        adocao.setIdAnimal(idAnimal);
        adocao.setIdPessoa(Math.toIntExact(pessoa.getId()));
        adocao.setObservacao("Animal adotado pela pessoa de nome: ".concat(pessoa.getNome()));
        return adocao;
    }
}