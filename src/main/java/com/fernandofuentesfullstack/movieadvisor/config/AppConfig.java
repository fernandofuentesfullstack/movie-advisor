package com.fernandofuentesfullstack.movieadvisor.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "com.fernandofuentesfullstack.movieadvisor")
@PropertySource("classpath:/movieadvisor.properties")
@Getter
public class AppConfig {

    @Value("${file.path}")
    private String file;

    @Value("${file.csv.separator}")
    private String separator;

    @Value("${file.csv.list_separator}")
    private String listSeparator;

}
