package edu.eci.arsw.parcial.services.impl;

import edu.eci.arsw.parcial.Exceptions.AirportException;
import edu.eci.arsw.parcial.HttpConection.HttpConectionService;
import edu.eci.arsw.parcial.cache.AirportsCache;
import edu.eci.arsw.parcial.cache.impl.Tuple;
import edu.eci.arsw.parcial.services.PreparcialServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
/**
 * Implementacion de servicios que se apoya en la capa de cache para responder mas rapido
 */
public class PreparcialServicesimpl implements PreparcialServices {
    @Autowired
    AirportsCache airportsCache=null;
    @Autowired
    HttpConectionService httpConectionService=null;

    /**
     * retorna los aeropuertos consultados a la api que cumplan con el nombre dado
     * @param name el nombre que deben tener los aeropuertos
     * @return un string con la respuesta del servidor o la que esta almacenada en cache en formato JSON
     * @throws AirportException si no encuentra aeropuertos con ese nombre
     */
    @Override
    public String getAirportsByName(String name) throws AirportException {
        Tuple<String, Long> response = null;
        response = airportsCache.getStoredResponse(name);

        if(response == null){
            String res=httpConectionService.doRequest(name);
            airportsCache.saveResponse(name,res);
            return res;
        }
        else{
            Long timeInCache = response.getElem2();
            Long elapsedTime = System.nanoTime() - timeInCache;
            Long time = TimeUnit.SECONDS.convert(elapsedTime, TimeUnit.NANOSECONDS);
            if(time>300){
                String res=httpConectionService.doRequest(name);
                airportsCache.saveResponse(name,res);
                return res;
            }
        }
        return response.getElem1();
    }
}
