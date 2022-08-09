package br.com.animal.microservice.repositories;

import br.com.animal.microservice.repositories.model.Pessoa;
import org.springframework.data.repository.CrudRepository;

public interface PessoaRepository extends CrudRepository<Pessoa, Long> {

}