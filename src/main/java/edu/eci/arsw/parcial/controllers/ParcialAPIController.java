package edu.eci.arsw.parcial.controllers;

import edu.eci.arsw.parcial.Exceptions.AirportException;
import edu.eci.arsw.parcial.services.PreparcialServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Controlador api para la raiz /airports
 */
@RestController
@RequestMapping(value = "/airports")
public class ParcialAPIController {
    @Autowired
    PreparcialServices preparcialServices=null;

    /**
     * Busca los aeropuertos que coinciden con un nombre dado
     * @param name el nombre por el que se quieren buscar los aeropuertos
     * @return un response con un string que representa los objetos aeropuerto en formato JSON con sus respectivos
     * codigos http
     */
    @RequestMapping(path = "/{name}",method = RequestMethod.GET)
    public ResponseEntity<?> getAirportsByName(@PathVariable("name") String name){
        try {
            return new ResponseEntity<>(preparcialServices.getAirportsByName(name), HttpStatus.ACCEPTED);
        } catch (AirportException e) {
            Logger.getLogger(ParcialAPIController.class.getName()).log(Level.SEVERE, null, e);
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

}
