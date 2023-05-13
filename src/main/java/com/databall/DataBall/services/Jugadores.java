package com.databall.DataBall.services;

import com.databall.DataBall.dao.Jugador;
import com.databall.DataBall.dto.BusquedaModel;
import org.springframework.stereotype.Service;

@Service
public interface Jugadores {

   Iterable<Jugador> getJugador(BusquedaModel model);

}
