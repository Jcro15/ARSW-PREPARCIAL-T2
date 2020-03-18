package edu.eci.arsw.parcial.cache.impl;

import edu.eci.arsw.parcial.cache.AirportsCache;
import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentHashMap;
@Service
public class AirportsCacheimpl implements AirportsCache {
    ConcurrentHashMap<String,Tuple<String,Long>> cacheMap;

    public AirportsCacheimpl() {
        this.cacheMap = new ConcurrentHashMap<>();
    }

    @Override
    public Tuple<String, Long> getStoredResponse(String name) {
        return cacheMap.get(name);
    }

    @Override
    public void saveResponse(String name, String response) {
        cacheMap.put(name,new Tuple<String, Long>(response,System.currentTimeMillis()));
    }
}
