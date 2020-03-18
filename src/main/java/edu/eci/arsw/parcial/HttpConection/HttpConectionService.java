package edu.eci.arsw.parcial.HttpConection;

import edu.eci.arsw.parcial.Exceptions.AirportException;

/**
 * Interfaz que define los servicios de conexion http
 */
public interface HttpConectionService {
    /**
     * realiza una peticion para obtener los aeropuertos dado un nombre de la api
     * @param name el nombre por el cual se desea filtrar los aeropuertos
     * @return un string con los objetos en formato JSON
     * @throws AirportException si no encuentra un aeropuerto con estas caracteristicas
     */
    String doRequest(String name) throws AirportException;
}
