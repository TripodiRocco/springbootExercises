package com.firstTimeSpring.demo.Exercise6.Controllers;

import com.firstTimeSpring.demo.Exercise6.Entities.PiattoInvernale;
import com.firstTimeSpring.demo.Exercise6.Services.PiattoInvernaleService;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/piatto-invernale")
public class PiattoInvernaleController {

    @Autowired
    private final PiattoInvernaleService piattoInvernaleService;


    public PiattoInvernaleController(PiattoInvernaleService piattoInvernaleService) {
        this.piattoInvernaleService = piattoInvernaleService;
    }

    @GetMapping(value = "/ottieni-piatto-invernale")
    public ResponseEntity<?> getPiattiInvernali() {
        try {
            List<PiattoInvernale> piattiInvernali = piattoInvernaleService.getPiattiInvernali();
            return ResponseEntity.ok().body(piattiInvernali);
        } catch (UnirestException e) {
            // Gestione dell'eccezione UnirestException
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Errore durante la richiesta dei piatti invernali");
        }
    }

}
