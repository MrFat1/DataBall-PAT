package com.databall.DataBall.dao;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.data.relational.core.sql.In;

@Table("JUGADORES")
public class Jugador {

    private @Column("NOMBRE") @Id
    String nombre;
    private @Column("POSICION")
    String posicion;
    private @Column("EQUIPO")
    String equipo;
    private @Column("NPARTIDOS")
    Integer npartidos;
    private @Column("GOLES")
    Integer goles;
    private @Column("ASISTENCIAS")
    Integer asistencias;
    private @Column("AMARILLAS")
    Integer amarillas;
    private @Column("ROJAS")
    Integer rojas;

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getPosicion() {
        return posicion;
    }
    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }
    public String getEquipo() {
        return equipo;
    }
    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }
    public Integer getNpartidos() {
        return npartidos;
    }
    public void setNpartidos(int npartidos) {
        this.npartidos = npartidos;
    }
    public Integer getGoles() {
        return goles;
    }
    public void setGoles(int goles) {
        this.goles = goles;
    }
    public Integer getAsistencias() {
        return asistencias;
    }
    public void setAsistencias(int asistencias) {
        this.asistencias = asistencias;
    }
    public Integer getAmarillas() {
        return amarillas;
    }
    public void setAmarillas(int amarillas) {
        this.amarillas = amarillas;
    }
    public Integer getRojas() {
        return rojas;
    }
    public void setRojas(int rojas) {
        this.rojas = rojas;
    }

    public Jugador(String nombre, String posicion, String equipo, Integer npartidos, Integer goles, Integer asistencias, Integer amarillas, Integer rojas) {
        this.nombre = nombre;
        this.posicion = posicion;
        this.equipo = equipo;
        this.npartidos = npartidos;
        this.goles = goles;
        this.asistencias = asistencias;
        this.amarillas = amarillas;
        this.rojas = rojas;
    }

    public Jugador() {
        this.nombre = "";
        this.posicion = "";
        this.equipo = "";
        this.npartidos = 0;
        this.asistencias = 0;
        this.amarillas = 0;
        this.rojas = 0;
    }

    @Override
    public String toString() {
        return "Jugador{" +
                "nombre='" + nombre + '\'' +
                ", posicion='" + posicion + '\'' +
                ", equipo='" + equipo + '\'' +
                ", npartidos=" + npartidos +
                ", goles=" + goles +
                ", asistencias=" + asistencias +
                ", amarillas=" + amarillas +
                ", rojas=" + rojas +
                '}';
    }
}
