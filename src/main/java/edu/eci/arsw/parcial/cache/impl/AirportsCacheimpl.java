package edu.eci.arsw.parcial.cache.impl;

import edu.eci.arsw.parcial.cache.AirportsCache;
import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Implementación en memoria del cache
 */
@Service
public class AirportsCacheimpl implements AirportsCache {
    ConcurrentHashMap<String,Tuple<String,Long>> cacheMap;

    public AirportsCacheimpl() {
        this.cacheMap = new ConcurrentHashMap<>();
    }

    /**
     * Retorna una respuesta que ya había sido solicitada anteriormente
     * @param name el nombre de la localizacion de los aeropuertos
     * @return una tupla String,long donde el string es la respuesta del servidor y el lon el tiempo en milisegundos
     */
    @Override
    public Tuple<String, Long> getStoredResponse(String name) {
        return cacheMap.get(name);
    }

    /**
     * Guarda el resultado de una petición con el tiempo en el que se genera
     * @param name nombre de la localización que genero la petición
     * @param response respueta del servidor a la petición
     */
    @Override
    public void saveResponse(String name, String response) {
        cacheMap.put(name,new Tuple<String, Long>(response,System.nanoTime()));
    }
}
