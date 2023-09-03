package com.firstTimeSpring.demo.Exercise6.Services;

import com.firstTimeSpring.demo.Exercise6.Entities.PiattoInvernale;
import com.firstTimeSpring.demo.Exercise6.Repositories.PiattoInvernaleRepository;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PiattoInvernaleService {

    /*
    private final double MIN_WINTER_TEMPERATURE = 1.3;

    @Autowired
    private PiattoInvernaleService piattoInvernaleService;

    public PiattoInvernaleService(PiattoInvernaleService piattoInvernaleService) {
        this.piattoInvernaleService = piattoInvernaleService;
    }

    public boolean ottieniPiattoInvernale(){
        Double temperaturaCorrenteInGradiCentigradi = ottieniTemperaturaCorrenteInGradiCentigradi();
        return piattoInvernaleService.ottieniPiattoInvernale();
    }

    private double ottieniTemperaturaCorrenteInGradiCentigradi(){
        try {
            JSONObject response = Unirest.get("https://api.open-meteo.com/v1/forecast?latitude=38.433&longitude=16.0575&current_weather=true")
                            .asJson().getBody().getObject();
            return response.getJSONObject("current_weather").getDouble("temperature");

        } catch (UnirestException e) {
            throw new RuntimeException(e);
        }
    }
     */

    private final double MIN_WINTER_TEMPERATURE = 1.3;
    private final String OPEN_METEO_API_URL = "https://api.open-meteo.com/v1/forecast?latitude=38.433&longitude=16.0575&current_weather=true";

    @Autowired
    private final PiattoInvernaleRepository piattoInvernaleRepository;


    public PiattoInvernaleService(PiattoInvernaleRepository piattoInvernaleRepository) {
        this.piattoInvernaleRepository = piattoInvernaleRepository;
    }

    public double getCurrentTemperature() throws UnirestException {
        HttpResponse<JsonNode> response = Unirest.get(OPEN_METEO_API_URL).asJson();

        // Estrai la temperatura dal JSON di risposta
        double temperature = response.getBody().getObject().getJSONObject("current_weather").getDouble("temperature");

        return temperature;
    }


    public List<PiattoInvernale> getPiattiInvernali() throws UnirestException {
        List<PiattoInvernale> piattiInvernali = piattoInvernaleRepository.findAll();
        List<PiattoInvernale> piattiFiltrati = new ArrayList<>();

        for (PiattoInvernale piatto : piattiInvernali) {
            double currentTemperature = 0;
            if (currentTemperature >= MIN_WINTER_TEMPERATURE && piatto.isWinterMeal()) {
                piattiFiltrati.add(piatto);
            }
        }

        return piattiFiltrati;
    }

}
