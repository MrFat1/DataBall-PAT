package com.databall.DataBall.services;

import com.databall.DataBall.dao.Equipo;
import com.databall.DataBall.repository.BusquedaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class EquiposImpl implements Equipos{

    Logger log = LoggerFactory.getLogger(EquiposImpl.class);

    @Autowired
    BusquedaRepository repo;

    @Override
    public Iterable<Equipo> getEquipo(String filtro, String busqueda) {

        log.info("Buscando equipo con el filtro " + filtro + " y la búsqueda " + busqueda);

        ArrayList<Equipo> result = repo.getResultadoBusqueda(filtro, busqueda);

        log.info("Lista obtenida: " + result);

        return result;

    }

}
