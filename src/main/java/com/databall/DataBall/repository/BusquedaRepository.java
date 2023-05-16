package com.databall.DataBall.repository;

import com.databall.DataBall.dao.Equipo;
import com.databall.DataBall.dao.Jugador;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;

public interface BusquedaRepository extends CrudRepository<Equipo, Integer> {

    @Query("SELECT * FROM EQUIPOS WHERE :filtro LIKE '%Real%'")
    ArrayList<Equipo> getResultadoBusqueda(
            @Param("filtro") String filtro,
            @Param("busqueda") String busqueda);

    @Modifying
    @Query("SELECT * FROM JUGADORES WHERE :filtro LIKE '%:busqueda%'")
    Iterable<Jugador> selectJugador(
            @Param("filtro") String filtro,
            @Param("busqueda") String busqueda
    );

}
