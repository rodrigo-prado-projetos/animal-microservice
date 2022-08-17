package br.com.animal.microservice.business.service;

import br.com.animal.microservice.repositories.PessoaRepository;
import br.com.animal.microservice.repositories.model.Pessoa;
import br.com.animal.microservice.util.ConstantsUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class PessoaBS {
    private final PessoaRepository pessoaRepository;

    @Autowired
    public PessoaBS(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    public Optional<Pessoa> buscarPessoaPorId(Long id) {
        try {
            return this.pessoaRepository.findById(id);
        } catch (Exception e) {
            log.error(ConstantsUtil.ERRO_BUSCAR_PESSOA, id);
            throw new RuntimeException(e.getCause());
        }
    }
}