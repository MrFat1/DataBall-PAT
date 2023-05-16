package com.databall.DataBall.services;

import com.databall.DataBall.dao.Equipo;
import com.databall.DataBall.dao.Jugador;
import com.databall.DataBall.repository.BusquedaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JugadoresImpl implements Jugadores{

    @Autowired
    BusquedaRepository repo;

    Logger log = LoggerFactory.getLogger(JugadoresImpl.class);

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public Iterable<Jugador> getJugador(String filtro, String busqueda) {

        log.info("Buscando jugador con el filtro " + filtro + " y la búsqueda " + busqueda);

        List<Jugador> result = this.buscarJugador(filtro, busqueda);

        log.info("Lista obtenida: " + result);

        return result;
    }

    public List<Jugador> buscarJugador(String filtro, String busqueda) {

        String sql;

        if (busqueda.equals("all")) {
            sql = "SELECT * FROM JUGADORES";
        } else {
            sql = "SELECT * FROM JUGADORES WHERE " + filtro + " LIKE '%" + busqueda + "%'";
        }

        return jdbcTemplate.query(
                sql,
                (rs, rowNum) ->
                        new Jugador(
                                rs.getString("nombre"),
                                rs.getString("posicion"),
                                rs.getString("equipo"),
                                rs.getInt("npartidos"),
                                rs.getInt("goles"),
                                rs.getInt("asistencias"),
                                rs.getInt("amarillas"),
                                rs.getInt("rojas")
                        )
        );
    }


}
