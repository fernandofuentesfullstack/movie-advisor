package com.fernandofuentesfullstack.movieadvisor;

import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

/**
 * Este componente especial se encarga de cargar el mensaje de ayuda
 * que está almacenado en un fichero de texto.
 *
 * Es un ejemplo de un componente (gestionado por el contenedor de IoC)
 * con gestión del ciclo de vida (@PostConstruct).
 */

@Component
public class MovieAdvisorHelp {

    private String help;

    @PostConstruct
    public void init() {
        try {
            help = Files
                    .lines(Paths.get(ResourceUtils.getFile("classpath:help.txt").toURI()))
                    .collect(Collectors.joining("\n"));

        } catch (IOException e) {
            System.err.println("Error loading help text");
            System.exit(-1);
        }
    }

    String getHelp () {
        return help;
    }

}
