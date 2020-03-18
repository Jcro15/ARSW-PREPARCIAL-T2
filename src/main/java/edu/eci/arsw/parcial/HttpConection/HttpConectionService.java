package edu.eci.arsw.parcial.HttpConection;

import edu.eci.arsw.parcial.Exceptions.AirportException;

public interface HttpConectionService {

    String doRequest(String name) throws AirportException;
}
