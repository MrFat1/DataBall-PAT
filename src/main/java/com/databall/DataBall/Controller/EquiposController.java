package com.databall.DataBall.Controller;

import com.databall.DataBall.dao.Equipo;
import com.databall.DataBall.dao.Jugador;
import com.databall.DataBall.dto.BusquedaModel;
import com.databall.DataBall.services.Equipos;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EquiposController {

    @Autowired
    Equipos equipos;

    Logger log = LoggerFactory.getLogger(EquiposController.class);

    @PostMapping(path = "/getEquipoSearch",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<Iterable<Equipo>> getEquipo(@RequestBody BusquedaModel model) {

        log.info("Model generado con el POST: " + model.toString());

        Iterable<Equipo> response = equipos.getEquipo(model);
        return ResponseEntity.ok().body(response);

    }



}
