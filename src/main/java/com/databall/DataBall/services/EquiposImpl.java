package com.databall.DataBall.services;

import com.databall.DataBall.dao.Equipo;
import com.databall.DataBall.dto.BusquedaModel;
import com.databall.DataBall.repository.BusquedaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EquiposImpl implements Equipos{

    @Autowired
    BusquedaRepository repo;

    @Override
    public Iterable<Equipo> getEquipo(BusquedaModel model) {

        Iterable<Equipo> result = repo.getResultadoBusqueda(model.getBusqueda(), model.getFiltro());

        return result;

    }

}
