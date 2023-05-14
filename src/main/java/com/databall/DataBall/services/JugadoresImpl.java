package com.databall.DataBall.services;

import com.databall.DataBall.dao.Jugador;
import com.databall.DataBall.dto.BusquedaModel;
import com.databall.DataBall.repository.BusquedaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JugadoresImpl implements Jugadores{

    @Autowired
    BusquedaRepository repo;

    @Override
    public Iterable<Jugador> getJugador(BusquedaModel model) {

        Iterable<Jugador> result = repo.selectJugador(model.getFiltro(), model.getBusqueda());

        return result;
    }


}
