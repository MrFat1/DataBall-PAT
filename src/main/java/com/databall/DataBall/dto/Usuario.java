package com.databall.DataBall.dto;

public class Usuario {
    private String Nombre;
    private String Apellidos;

    public Usuario(String n, String a, String c)
    {
        setNombre(n);
        setApellidos(a);
        setCorreo(c);
    }
    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    @Override
    public String toString()
    {
        return "Usuario:"+getNombre()+" "+ getApellidos()+" con el correo : "+getCorreo();
    }
    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String apellidos) {
        Apellidos = apellidos;
    }


    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    private String correo;

}
