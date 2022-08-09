package br.com.animal.microservice.repositories;

import br.com.animal.microservice.repositories.model.Apadrinhamento;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ApadrinhamentoRepository extends CrudRepository<Apadrinhamento, Long> {

    List<Apadrinhamento> findByIdAnimal(Long idAnimal);

}