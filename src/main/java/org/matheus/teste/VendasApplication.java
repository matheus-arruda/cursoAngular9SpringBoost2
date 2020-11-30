package org.matheus.teste;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
//@SpringBootApplication -> Informa que a classe será gerido pelo SpringBoot
@SpringBootApplication
//@RestController -> A aplicação se torna acessível via web
@RestController
public class VendasApplication {
    //Metodo com mapeamento de URL
    @GetMapping("/hello")
    public String helloWorld() {

        return "hello world";

    }
    //Metodo principal do projeto
    public static void main(String[] args) {
        //Código para definir qual é a classe que inicia o aplicativo
        SpringApplication.run(VendasApplication.class, args);

    }

}
