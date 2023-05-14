package com.databall.DataBall.repository;

import com.databall.DataBall.dao.Equipo;
import com.databall.DataBall.dao.Jugador;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Sort;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public interface BusquedaRepository extends CrudRepository<Equipo, Integer> {

    @Query(value = "SELECT * FROM EQUIPOS WHERE :filtro LIKE '%:busqueda%'")
    ArrayList<Equipo> getResultadoBusqueda(
            @Param("filtro") String filtro,
            @Param("busqueda") String busqueda
    );

    @Modifying
    @Query("SELECT * FROM JUGADORES WHERE :filtro LIKE '%:busqueda%'")
    Iterable<Jugador> selectJugador(
            @Param("filtro") String filtro,
            @Param("busqueda") String busqueda
    );

}
