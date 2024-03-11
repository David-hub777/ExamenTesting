package com.examen.dragonball.models;

public class Jugador {
    String nombre ;
    String jugada;
    public String getNombre() {
        return nombre;
    }
    public String getJugada() {
        return jugada;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setJugada(String jugada) {
        this.jugada = jugada;
    }
    public Jugador(String nombre, String jugada) {
        this.nombre = nombre;
        this.jugada = jugada;
    }
    
}
