package org.matheus.teste.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//Classe de configuração
@Configuration
public class MinhaConfiguration {
    @Bean(name = "applicationName")
    public String applicationName() {
        return "Sistema de Vendas";
    }

}
