package com.databall.DataBall.services;

import com.databall.DataBall.dao.Jugador;
import org.springframework.stereotype.Service;

@Service
public interface Jugadores {

   Iterable<Jugador> getJugador(String filtro, String busqueda);

}
