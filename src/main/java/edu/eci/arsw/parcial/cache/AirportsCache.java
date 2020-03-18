package edu.eci.arsw.parcial.cache;

import edu.eci.arsw.parcial.cache.impl.Tuple;
import org.springframework.stereotype.Service;

@Service
public interface AirportsCache {
    Tuple<String, Long> getStoredResponse(String name);

    void saveResponse(String name,String response);

}
