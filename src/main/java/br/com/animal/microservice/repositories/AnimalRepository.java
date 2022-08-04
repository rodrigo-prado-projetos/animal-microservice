package br.com.animal.microservice.repositories;

import br.com.animal.microservice.repositories.model.Animal;
import org.springframework.data.repository.CrudRepository;

public interface AnimalRepository extends CrudRepository<Animal, Long> {

}
