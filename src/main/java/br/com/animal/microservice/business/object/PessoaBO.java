package br.com.animal.microservice.business.object;

import br.com.animal.microservice.business.service.PessoaBS;
import br.com.animal.microservice.exception.PessoaNaoEncontrado;
import br.com.animal.microservice.repositories.model.Pessoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PessoaBO {
    private final PessoaBS pessoaBS;

    @Autowired
    public PessoaBO(PessoaBS pessoaBS) {
        this.pessoaBS = pessoaBS;
    }


    public Pessoa validarSePessoaExisteNaBaseDeDados(Long idPessoa) {
        Optional<Pessoa> pessoa = this.pessoaBS.buscarPessoaPorId(idPessoa);
        if (!pessoa.isPresent()) {
            throw new PessoaNaoEncontrado();
        }
        return pessoa.get();
    }
}