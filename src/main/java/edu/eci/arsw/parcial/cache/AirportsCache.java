package edu.eci.arsw.parcial.cache;

import edu.eci.arsw.parcial.cache.impl.Tuple;
import org.springframework.stereotype.Service;

/**
 * interfaz de servicios de cache
 */
@Service
public interface AirportsCache {
    /**
     * Retorna una respuesta que ya había sido solicitada anteriormente
     * @param name el nombre de la localizacion de los aeropuertos
     * @return una tupla String,long donde el string es la respuesta del servidor y el lon el tiempo en milisegundos
     */
    Tuple<String, Long> getStoredResponse(String name);
    /**
     * Guarda el resultado de una petición con el tiempo en el que se genera
     * @param name nombre de la localización que genero la petición
     * @param response respueta del servidor a la petición
     */
    void saveResponse(String name,String response);

}
