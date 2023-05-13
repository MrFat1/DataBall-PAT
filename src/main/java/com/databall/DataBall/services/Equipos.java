package com.databall.DataBall.services;

import com.databall.DataBall.dao.Equipo;
import com.databall.DataBall.dto.BusquedaModel;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface Equipos {

    Iterable<Equipo> getEquipo(BusquedaModel model);

}
