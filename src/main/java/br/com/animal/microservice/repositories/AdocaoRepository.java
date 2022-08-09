package br.com.animal.microservice.repositories;

import br.com.animal.microservice.repositories.model.Adocao;
import org.springframework.data.repository.CrudRepository;

public interface AdocaoRepository extends CrudRepository<Adocao, Long> {

}