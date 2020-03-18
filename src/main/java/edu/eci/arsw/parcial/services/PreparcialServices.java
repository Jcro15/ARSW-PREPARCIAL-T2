package edu.eci.arsw.parcial.services;

import edu.eci.arsw.parcial.Exceptions.AirportException;

/**
 * Interfaz de servicios de la aplicacion
 */
public interface PreparcialServices {
    /**
     * Busca los aeropuertos que coincidan con un nombre
     * @param name el nombre que deben tener los aeropuertos
     * @return un string con los aeropuertos en formato JSON
     * @throws AirportException si no encuentra aeropuertos con ese nombre
     */
    String getAirportsByName(String name) throws AirportException;
}
