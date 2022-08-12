package br.com.animal.microservice.mock;

import br.com.animal.microservice.repositories.PessoaRepository;
import br.com.animal.microservice.repositories.model.Pessoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MockPessoa {
    @Autowired
    private PessoaRepository pessoaRepository;

    public void inserirPessoasNaBaseDeDados(String linhaArquivo) {
        Pessoa pessoa = obterObjetoPessoa(linhaArquivo.split("\\|"));
        this.pessoaRepository.save(pessoa);
    }

    private Pessoa obterObjetoPessoa(String[] linha) {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome(linha[0]);
        pessoa.setIdade(Integer.parseInt(linha[1]));
        pessoa.setCpf(linha[2]);
        pessoa.setEndereco(linha[3]);
        pessoa.setCidade(linha[4]);
        pessoa.setEstado(linha[5]);
        pessoa.setNumero(Integer.parseInt(linha[6]));
        pessoa.setTelefone(linha[7]);
        return pessoa;
    }
}