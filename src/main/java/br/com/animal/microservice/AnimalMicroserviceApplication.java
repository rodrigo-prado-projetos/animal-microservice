package br.com.animal.microservice;

import br.com.animal.microservice.util.ConstantsUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(ConstantsUtil.BASE_PACKAGE)
public class AnimalMicroserviceApplication {
    public static void main(String[] args) {
        SpringApplication.run(AnimalMicroserviceApplication.class, args);
    }
}
