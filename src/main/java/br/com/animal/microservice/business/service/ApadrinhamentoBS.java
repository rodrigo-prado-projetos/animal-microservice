package br.com.animal.microservice.business.service;

import br.com.animal.microservice.repositories.ApadrinhamentoRepository;
import br.com.animal.microservice.repositories.model.Apadrinhamento;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ApadrinhamentoBS {
    private final ApadrinhamentoRepository apadrinhamentoRepository;

    @Autowired
    public ApadrinhamentoBS(ApadrinhamentoRepository apadrinhamentoRepository) {
        this.apadrinhamentoRepository = apadrinhamentoRepository;
    }

    public List<Apadrinhamento> buscarApadrinhamentoPorIdDoAnimal(Long idAnimal) {
        try {
            return this.apadrinhamentoRepository.findByIdAnimal(idAnimal);
        } catch (Exception e) {
            log.error("Ocorreu um erro ao tenta buscar animal {} na tabela de apadrinhamento", idAnimal);
            throw new RuntimeException(e.getCause());
        }
    }

    public void encerrarApadrinhamentoPorIdDoApadrinhamento(Long idApadrinhamento) {
        try {
            this.apadrinhamentoRepository.deleteById(idApadrinhamento);
        } catch (Exception e) {
            log.error("Ocorreu um erro ao encerrar o apadrinhamento {}", idApadrinhamento);
            throw new RuntimeException(e.getCause());
        }
    }
}