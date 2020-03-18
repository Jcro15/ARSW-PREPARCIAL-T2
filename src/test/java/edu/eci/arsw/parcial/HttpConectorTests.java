package edu.eci.arsw.parcial;
import edu.eci.arsw.parcial.Exceptions.AirportException;
import edu.eci.arsw.parcial.HttpConection.HttpConectionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HttpConectorTests {

    @Autowired
    private HttpConectionService httpConectionService;

    @Test
    public void shouldGetAirportsByName() throws AirportException {
        String response = httpConectionService.doRequest("berlin");
        assertNotNull(response);
        System.out.println(response);
        assertTrue(response.contains("Berlin"));
    }

    @Test
    public void shouldNotGetAirportsByNameIfDoesntExist()  {
        try {
            String response = httpConectionService.doRequest("ciudadgotica");
            System.out.println(response);

            fail("No debería existir este aeropuerto");
        } catch (AirportException e) {
            assertEquals("Not Found",e.getMessage());
        }
    }

}