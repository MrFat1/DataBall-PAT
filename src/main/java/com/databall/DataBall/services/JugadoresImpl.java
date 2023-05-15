package com.databall.DataBall.services;

import com.databall.DataBall.dao.Jugador;
import com.databall.DataBall.repository.BusquedaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JugadoresImpl implements Jugadores{

    @Autowired
    BusquedaRepository repo;

    @Override
    public Iterable<Jugador> getJugador(String filtro, String busqueda) {

        Iterable<Jugador> result = repo.selectJugador(filtro, busqueda);

        return result;
    }


}
