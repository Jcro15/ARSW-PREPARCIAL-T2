package edu.eci.arsw.parcial.services.impl;

import edu.eci.arsw.parcial.Exceptions.AirportException;
import edu.eci.arsw.parcial.HttpConection.HttpConectionService;
import edu.eci.arsw.parcial.cache.AirportsCache;
import edu.eci.arsw.parcial.cache.impl.Tuple;
import edu.eci.arsw.parcial.services.PreparcialServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PreparcialServicesimpl implements PreparcialServices {
    @Autowired
    AirportsCache airportsCache=null;
    @Autowired
    HttpConectionService httpConectionService=null;
    @Override
    public String getAirportsByName(String name) throws AirportException {
        Tuple<String, Long> response = null;
        response = airportsCache.getStoredResponse(name);
        if(response == null||(response.getElem2()>3000000)){
            String res=httpConectionService.doRequest(name);
            airportsCache.saveResponse(name,res);
            return res;
        }
        return response.getElem1();
    }
}
