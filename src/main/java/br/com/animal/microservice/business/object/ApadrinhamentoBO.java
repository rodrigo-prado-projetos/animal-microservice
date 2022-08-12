
package br.com.animal.microservice.business.object;

import br.com.animal.microservice.business.service.ApadrinhamentoBS;
import br.com.animal.microservice.business.service.EnvioEmailBS;
import br.com.animal.microservice.controller.vo.ApadrinhamentoVO;
import br.com.animal.microservice.repositories.model.Animal;
import br.com.animal.microservice.repositories.model.Apadrinhamento;
import br.com.animal.microservice.util.ConstantsUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ApadrinhamentoBO {
    private final ApadrinhamentoBS apadrinhamentoBS;
    private final EnvioEmailBS envioEmailBS;
    private final AnimalBO animalBO;
    private final PessoaBO pessoaBO;
    @Value("${email}")
    private String email;

    @Autowired
    public ApadrinhamentoBO(ApadrinhamentoBS apadrinhamentoBS, EnvioEmailBS envioEmailBS, AnimalBO animalBO, PessoaBO pessoaBO) {
        this.apadrinhamentoBS = apadrinhamentoBS;
        this.envioEmailBS = envioEmailBS;
        this.animalBO = animalBO;
        this.pessoaBO = pessoaBO;
    }

    public void apadrinharAnimal(ApadrinhamentoVO apadrinhamentoVO) {
        Animal animal = this.animalBO.validarSeAnimalExisteNaBaseDeDados(Long.valueOf(apadrinhamentoVO.getIdAnimal()));

        this.pessoaBO.validarSePessoaExisteNaBaseDeDados(Long.valueOf(apadrinhamentoVO.getIdPessoa()));

        apadrinhamentoVO.validarSeOValorDoApadrinhamentoEMaiorQueZero();

        this.animalBO.validarSeAnimalFoiAdotado(animal.isAdotado());

        Apadrinhamento apadrinhamento = new Apadrinhamento();
        BeanUtils.copyProperties(apadrinhamentoVO, apadrinhamento);
        this.apadrinhamentoBS.apadrinhaUmAnimal(apadrinhamento);

        this.animalBO.alterarStatusDoAnimalParaApadrinhado(animal);
    }

    public void validarSeAnimalEstaSendoApadrinhado(Animal animal) {
        if (animal.isApadrinhado()) {
            iterarListaDeApadrinhamentos(buscarApadrinhamentoPorIdDoAnimal(animal), animal);
        }
    }

    private List<Apadrinhamento> buscarApadrinhamentoPorIdDoAnimal(Animal animal) {
        return this.apadrinhamentoBS.buscarApadrinhamentoPorIdDoAnimal(animal.getId());
    }


    private void iterarListaDeApadrinhamentos(List<Apadrinhamento> apadrinhamentos, Animal animal) {
        for (Apadrinhamento apadrinhamento : apadrinhamentos) {
            encerrarApadrinhamentoDoAnimal(apadrinhamento.getId());
            enviarEmailParaPessoaQueEstaApadrinhandoAnimal(apadrinhamento, animal);
        }
    }

    private void encerrarApadrinhamentoDoAnimal(Long idApadrinhamento) {
        this.apadrinhamentoBS.encerrarApadrinhamentoPorIdDoApadrinhamento(idApadrinhamento);
    }


    private void enviarEmailParaPessoaQueEstaApadrinhandoAnimal(Apadrinhamento apadrinhamento, Animal animal) {
        this.envioEmailBS.montarMensagemDeEmail(this.email, ConstantsUtil.ANIMAL_ADOTADO, animal.getNome());
        this.envioEmailBS.enviar();
    }
}