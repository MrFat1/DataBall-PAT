package com.databall.DataBall.Controller;

import com.databall.DataBall.dao.Jugador;
import com.databall.DataBall.dto.BusquedaModel;
import com.databall.DataBall.services.Jugadores;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JugadoresController {

    Logger log = LoggerFactory.getLogger(JugadoresController.class);

    @Autowired
    Jugadores jugadores;

    @PostMapping(path = "/getJugadorSearch",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<Iterable<Jugador>> getJugador(@RequestBody BusquedaModel model) {

        log.info("Model generado con el POST: " + model.toString());

        Iterable<Jugador> response = jugadores.getJugador(model);
        return ResponseEntity.ok().body(response);

    }

}
