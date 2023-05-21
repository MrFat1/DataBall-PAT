package com.databall.DataBall.Controller;

import com.databall.DataBall.dao.Jugador;
import com.databall.DataBall.services.Jugadores;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JugadoresController {

    Logger log = LoggerFactory.getLogger(JugadoresController.class);

    @Autowired
    Jugadores jugadores;

    @GetMapping(path = "/getJugadorSearch/{filtro}/{busqueda}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<Jugador>> getJugador(@PathVariable String filtro, @PathVariable String busqueda) {

        log.info("Parámetros recibidos " + filtro + " y " + busqueda);

        Iterable<Jugador> response = jugadores.getJugador(filtro, busqueda);
        return ResponseEntity.ok().body(response);

    }

}
