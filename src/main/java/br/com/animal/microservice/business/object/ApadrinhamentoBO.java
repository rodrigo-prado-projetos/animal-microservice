
package br.com.animal.microservice.business.object;

import br.com.animal.microservice.business.service.ApadrinhamentoBS;
import br.com.animal.microservice.controller.vo.ApadrinhamentoVO;
import br.com.animal.microservice.repositories.model.Animal;
import br.com.animal.microservice.repositories.model.Apadrinhamento;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ApadrinhamentoBO {
    private final ApadrinhamentoBS apadrinhamentoBS;
    private final AnimalBO animalBO;
    private final PessoaBO pessoaBO;

    @Autowired
    public ApadrinhamentoBO(ApadrinhamentoBS apadrinhamentoBS, AnimalBO animalBO, PessoaBO pessoaBO) {
        this.apadrinhamentoBS = apadrinhamentoBS;
        this.animalBO = animalBO;
        this.pessoaBO = pessoaBO;
    }

    public void apadrinharAnimal(ApadrinhamentoVO apadrinhamentoVO) {
        Animal animal = this.animalBO.validarSeAnimalExisteNaBaseDeDados(
                Long.valueOf(apadrinhamentoVO.getIdAnimal())
        );

        this.pessoaBO.validarSePessoaExisteNaBaseDeDados(
                Long.valueOf(apadrinhamentoVO.getIdPessoa())
        );

        apadrinhamentoVO.validarSeOValorDoApadrinhamentoEMaiorQueZero();

        this.animalBO.validarSeAnimalFoiAdotado(animal.isAdotado());


        this.apadrinhamentoBS.apadrinharUmAnimal(
                obterObjetoApadrinhamentoParaSalvarNaBaseDeDados(apadrinhamentoVO)
        );
        this.animalBO.alterarStatusDoAnimalParaApadrinhado(animal);
    }


    public void validarSeAnimalEstaSendoApadrinhado(Animal animal) {
        if (animal.isApadrinhado()) {
            List<Apadrinhamento> apadrinhamentos = buscarApadrinhamentoPorIdDoAnimal(animal.getId());
            iterarListaDeApadrinhamentos(apadrinhamentos, animal);
        }
    }

    private List<Apadrinhamento> buscarApadrinhamentoPorIdDoAnimal(Long idAnimal) {
        return this.apadrinhamentoBS.buscarApadrinhamentoPorIdDoAnimal(idAnimal);
    }


    private void iterarListaDeApadrinhamentos(List<Apadrinhamento> apadrinhamentos, Animal animal) {
        for (Apadrinhamento apadrinhamento : apadrinhamentos) {
            encerrarApadrinhamentoDoAnimal(apadrinhamento.getId());
        }
    }

    private void encerrarApadrinhamentoDoAnimal(Long idApadrinhamento) {
        this.apadrinhamentoBS.encerrarApadrinhamentoPorIdDoApadrinhamento(idApadrinhamento);
    }

    private Apadrinhamento obterObjetoApadrinhamentoParaSalvarNaBaseDeDados(ApadrinhamentoVO apadrinhamentoVO) {
        Apadrinhamento apadrinhamento = new Apadrinhamento();
        BeanUtils.copyProperties(apadrinhamentoVO, apadrinhamento);
        return apadrinhamento;
    }
}