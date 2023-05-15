package com.databall.DataBall.Controller;

import com.databall.DataBall.dao.Equipo;
import com.databall.DataBall.services.Equipos;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class EquiposController {

    @Autowired
    Equipos equipos;

    Logger log = LoggerFactory.getLogger(EquiposController.class);

    @GetMapping(path = "/getEquipoSearch/{filtro}/{busqueda}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<Equipo>> getEquipo(@PathVariable String filtro, @PathVariable String busqueda) {

        log.info("Datos recibidos: " + filtro + " y " + busqueda);

        Iterable<Equipo> response = equipos.getEquipo(filtro, busqueda);
        return ResponseEntity.ok().body(response);

    }



}
