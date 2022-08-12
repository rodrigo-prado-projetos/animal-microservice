package br.com.animal.microservice.config;

import br.com.animal.microservice.exception.AnimalAdotado;
import br.com.animal.microservice.exception.AnimalNaoEncontrado;
import br.com.animal.microservice.exception.PessoaNaoEncontrado;
import br.com.animal.microservice.exception.ValorMenorQueZero;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ManipuladorErro extends ResponseEntityExceptionHandler {
    @ExceptionHandler({AnimalNaoEncontrado.class})
    public ResponseEntity<Object> animalNaoCadastradoNaBaseDeDados(AnimalNaoEncontrado animalNaoEncontrado) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(animalNaoEncontrado.getMessage());
    }

    @ExceptionHandler({PessoaNaoEncontrado.class})
    public ResponseEntity<Object> pessoaNaoCadastradoNaBaseDeDados(PessoaNaoEncontrado pessoaNaoEncontrado) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(pessoaNaoEncontrado.getMessage());
    }

    @ExceptionHandler({AnimalAdotado.class})
    public ResponseEntity<Object> pessoaNaoCadastradoNaBaseDeDados(AnimalAdotado animalAdotado) {
        return ResponseEntity.ok(animalAdotado.getMessage());
    }

    @ExceptionHandler({ValorMenorQueZero.class})
    public ResponseEntity<Object> valorDoApadrinhamentoNaoEMaiorQueZero(ValorMenorQueZero valorMenorQueZero) {
        return ResponseEntity.ok(valorMenorQueZero.getMessage());
    }
}