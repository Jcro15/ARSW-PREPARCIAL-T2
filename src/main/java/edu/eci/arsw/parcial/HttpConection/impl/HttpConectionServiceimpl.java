package edu.eci.arsw.parcial.HttpConection.impl;

import edu.eci.arsw.parcial.Exceptions.AirportException;
import edu.eci.arsw.parcial.HttpConection.HttpConectionService;
import org.springframework.stereotype.Service;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

@Service
public class HttpConectionServiceimpl implements HttpConectionService {


    @Override
    public String doRequest(String name) throws AirportException {
        OkHttpClient client = new OkHttpClient();
        String resp = null;

        Request request = new Request.Builder()
                .url("https://cometari-airportsfinder-v1.p.rapidapi.com/api/airports/by-text?text=" + name)
                .get()
                .addHeader("x-rapidapi-host", "cometari-airportsfinder-v1.p.rapidapi.com")
                .addHeader("x-rapidapi-key", "7985e66558msh4284297b171966dp10ddd9jsn2db136bdfb7b")
                .build();

        Response res = null;
        try {
            res = client.newCall(request).execute();
            if (res.isSuccessful()) {
                resp= res.body().string();
            }
        } catch (IOException e) {
            throw new AirportException("Bad Request");
        }

        return resp;
    }
}
