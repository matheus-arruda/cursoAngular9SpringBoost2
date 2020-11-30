package org.matheus.teste;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
//@SpringBootApplication -> Informa que a classe será gerido pelo SpringBoot
@SpringBootApplication
//@ComponentScan -> Pacotes que serão escaneados, se não for definido, todos os pacotes são escaneados pelo Spring
/*@ComponentScan(basePackages = {
        "org.matheus.teste.repository",
        "org.matheus.teste.service"})*/
//@RestController -> A aplicação se torna acessível via web
@RestController
public class VendasApplication {

    //String herdando do metodo minhaConfiguration
    @Autowired
    @Qualifier("applicationName")
    private String applicationName;

    //Metodo com mapeamento de URL
    @GetMapping("/hello")
    public String helloWorld() {
        return "<b>Nome da Aplicação:</b> <font color='red'>" + applicationName+"</font>";
    }
    //Metodo principal do projeto
    public static void main(String[] args) {
        //Código para definir qual é a classe que inicia o aplicativo
        SpringApplication.run(VendasApplication.class, args);

    }

}
