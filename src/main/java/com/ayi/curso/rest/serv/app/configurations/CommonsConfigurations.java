package com.ayi.curso.rest.serv.app.configurations;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.ayi.curso.rest.serv.app.configurations" +
        "com.ayi.curso.rest.serv.app.services" +
        "com.ayi.curso.rest.serv.app.mappers" +
        "com.ayi.curso.rest.serv.app.repositories"})
public class CommonsConfigurations {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
