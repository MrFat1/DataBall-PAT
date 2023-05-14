package com.databall.DataBall.services;

import com.databall.DataBall.dao.Equipo;
import com.databall.DataBall.dto.BusquedaModel;
import com.databall.DataBall.repository.BusquedaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EquiposImpl implements Equipos{

    Logger log = LoggerFactory.getLogger(EquiposImpl.class);

    @Autowired
    BusquedaRepository repo;

    @Override
    public Iterable<Equipo> getEquipo(BusquedaModel model) {

        log.info("Accediendo a la búsqueda de equipos con el model: " + model.toString());

        ArrayList<Equipo> result = repo.getResultadoBusqueda(model.getFiltro(), model.getBusqueda());

        log.info("Lista obtenida: " + result);

        return result;

    }

}
