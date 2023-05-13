package com.databall.DataBall.dto;

public class BusquedaModel {

    private String busqueda;
    private String filtro;

    public BusquedaModel(String busqueda, String filtro) {
        this.busqueda = busqueda;
        this.filtro = filtro;
    }

    public String getBusqueda() {
        return busqueda;
    }
    public String getFiltro() {
        return filtro;
    }


}
