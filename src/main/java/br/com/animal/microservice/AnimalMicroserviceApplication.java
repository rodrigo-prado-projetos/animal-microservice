package br.com.animal.microservice;

import br.com.animal.microservice.mock.MockAnimal;
import br.com.animal.microservice.mock.MockPessoa;
import br.com.animal.microservice.util.ConstantsUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

@Slf4j
@SpringBootApplication
@ComponentScan(ConstantsUtil.BASE_PACKAGE)
public class AnimalMicroserviceApplication {
    @Autowired
    private MockAnimal mockAnimal;
    @Autowired
    private MockPessoa mockPessoa;

    public static void main(String[] args) {
        SpringApplication.run(AnimalMicroserviceApplication.class, args);
    }

    @Bean
    public void inserirAnimaisNaBaseDeDados() {
        try {
            Stream<String> lines = Files.lines(Paths.get("src/main/resources/animais.txt"));
            lines.forEach((String line) -> {
                        this.mockAnimal.inserirAnimaisNaBaseDeDados(line);
                    }
            );
        } catch (Exception e) {
            log.error("Ocorreu um erro ao tentar popular a tabela de animais");
        }
    }

    @Bean
    public void inserirPessoasNaBaseDeDados() {
        try {
            Stream<String> lines = Files.lines(Paths.get("src/main/resources/pessoas.txt"));
            lines.forEach((String linha) -> {
                        this.mockPessoa.inserirPessoasNaBaseDeDados(linha);
                    }
            );
        } catch (Exception e) {
            log.error("Ocorreu um erro ao tentar popular a tabela de pessoas");
        }
    }
}
