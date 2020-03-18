package edu.eci.arsw.parcial;

import edu.eci.arsw.parcial.Exceptions.AirportException;
import edu.eci.arsw.parcial.services.PreparcialServices;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServicesTests {

    @Autowired
    PreparcialServices preparcialServices;

    @Test
    public void shouldGetAirportsByName() throws AirportException {
        String response = preparcialServices.getAirportsByName("berlin");
        assertNotNull(response);
        assertTrue(response.contains("Berlin"));
    }

    @Test
    public void shouldNotGetAirportsByNameIfDoesntExist(){
        try {
            String response = preparcialServices.getAirportsByName("ciudadgotica");
            fail("No debería existir este aeropuerto");
        } catch (AirportException e) {
            assertEquals("Not Found",e.getMessage());
        }
    }
}