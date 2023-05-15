package com.databall.DataBall.services;

import com.databall.DataBall.dao.Equipo;
import org.springframework.stereotype.Service;

@Service
public interface Equipos {

    Iterable<Equipo> getEquipo(String filtro, String busqueda);

}
