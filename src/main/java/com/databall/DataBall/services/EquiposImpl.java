package com.databall.DataBall.services;

import com.databall.DataBall.dao.Equipo;
import com.databall.DataBall.repository.BusquedaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquiposImpl implements Equipos{

    Logger log = LoggerFactory.getLogger(EquiposImpl.class);

    @Autowired
    BusquedaRepository repo;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public Iterable<Equipo> getEquipo(String filtro, String busqueda) {

        log.info("Buscando equipo con el filtro " + filtro + " y la búsqueda " + busqueda);

        //ArrayList<Equipo> result = repo.getResultadoBusqueda(filtro, busqueda);

        List<Equipo> result = this.buscarEquipo(filtro, busqueda);

        log.info("Lista obtenida: " + result);

        return result;

    }

    public List<Equipo> buscarEquipo(String filtro, String busqueda) {

        String sql;

        if (busqueda.equals("all")) {
            sql = "SELECT * FROM EQUIPOS";
        } else {
            sql = "SELECT * FROM EQUIPOS WHERE " + filtro + " LIKE '%" + busqueda + "%'";
        }

        return jdbcTemplate.query(
                sql,
                (rs, rowNum) ->
                        new Equipo(
                                rs.getString("nombre"),
                                rs.getString("entrenador"),
                                rs.getString("presidente"),
                                rs.getString("estadio"),
                                rs.getInt("posicion"),
                                rs.getInt("capacidad")
                        )
        );
    }

}
