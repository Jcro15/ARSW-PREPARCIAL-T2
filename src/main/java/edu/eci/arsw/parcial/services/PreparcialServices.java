package edu.eci.arsw.parcial.services;

import edu.eci.arsw.parcial.Exceptions.AirportException;

public interface PreparcialServices {

    String getAirportsByName(String name) throws AirportException;
}
