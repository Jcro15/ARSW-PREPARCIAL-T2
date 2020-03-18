package edu.eci.arsw.parcial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Clase main de la aplicaion AirportFinder
 */
@SpringBootApplication
@ComponentScan(basePackages = {"edu.eci.arsw.parcial"})
public class ParcialApplication {
    /**
     * Metodo main del proyecto
     * @param args args
     */
    public static void main(String[] args) {
        SpringApplication.run(ParcialApplication.class, args);
    }

}