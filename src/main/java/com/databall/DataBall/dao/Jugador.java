package com.databall.DataBall.dao;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("JUGADORES")
public class Jugador {

    private @Column("NOMBRE") @Id
    String nombre;
    private @Column("POSICION")
    String posicion;
    private @Column("EQUIPO")
    String equipo;
    private @Column("NPARTIDOS")
    int npartidos;
    private @Column("GOLES")
    int goles;
    private @Column("ASISTENCIAS")
    int asistencias;
    private @Column("AMARILLAS")
    int amarillas;
    private @Column("ROJAS")
    int rojas;

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
    public int getNpartidos() {
        return npartidos;
    }
    public void setNpartidos(int npartidos) {
        this.npartidos = npartidos;
    }
    public int getGoles() {
        return goles;
    }
    public void setGoles(int goles) {
        this.goles = goles;
    }
    public int getAsistencias() {
        return asistencias;
    }
    public void setAsistencias(int asistencias) {
        this.asistencias = asistencias;
    }
    public int getAmarillas() {
        return amarillas;
    }
    public void setAmarillas(int amarillas) {
        this.amarillas = amarillas;
    }
    public int getRojas() {
        return rojas;
    }
    public void setRojas(int rojas) {
        this.rojas = rojas;
    }

    public Jugador(String nombre, String posicion, String equipo, int npartidos, int goles, int asistencias, int amarillas, int rojas) {
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
