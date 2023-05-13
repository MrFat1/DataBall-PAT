package com.databall.DataBall.dao;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("EQUIPOS")
public class Equipo {

    private @Column("NOMBRE") @Id
    String nombre;
    private @Column("ENTRENADOR")
    String entrenador;
    private @Column("PRESIDENTE")
    String presidente;
    private @Column("ESTADIO")
    String estadio;
    private @Column("POSICION")
    int posicion;
    private @Column("CAPACIDAD")
    int capacidad;
    private @Column("MSALARIAL")
    int masaSalarial;

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEntrenador() {
        return entrenador;
    }
    public void setEntrenador(String entrenador) {
        this.entrenador = entrenador;
    }

    public String getPresidente() {
        return presidente;
    }
    public void setPresidente(String presidente) {
        this.presidente = presidente;
    }

    public String getEstadio() {
        return estadio;
    }
    public void setEstadio(String estadio) {
        this.estadio = estadio;
    }

    public int getPosicion() {
        return posicion;
    }
    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public int getCapacidad() {
        return capacidad;
    }
    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public int getMasaSalarial() {
        return masaSalarial;
    }
    public void setMasaSalarial(int masaSalarial) {
        this.masaSalarial = masaSalarial;
    }


    public Equipo(String nombre, String entrenador, String presidente, String estadio, int posicion, int capacidad, int masaSalarial) {
        this.nombre = nombre;
        this.entrenador = entrenador;
        this.presidente = presidente;
        this.estadio = estadio;
        this.posicion = posicion;
        this.capacidad = capacidad;
        this.masaSalarial = masaSalarial;
    }

    public Equipo() {
        this.nombre = "";
        this.entrenador = "";
        this.presidente = "";
        this.estadio = "";
        this.posicion = 0;
        this.capacidad = 0;
        this.masaSalarial = 0;
    }

    @Override
    public String toString() {
        return "Equipo [Nombre=" + this.nombre + ", Entrenador=" + this.entrenador + ", Presidente=" + this.presidente + ", Estadio=" + this.estadio + ", Posicion=" + this.posicion
                + ", Capacidad=" + this.capacidad + ", Masa Salarial=" + this.masaSalarial + "]";
    }

}
