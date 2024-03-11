package com.examen.dragonball.models;

public class Dragonball {
    private int numEstrellas;
    private String ubicacion;
    private boolean estado;// Conseguida o no Conseguida

    public Dragonball() {
    }

    public Dragonball(int numeroBola, String localizacion, boolean estado) {
        this.numEstrellas = numeroBola;
        this.ubicacion = localizacion;
        this.estado = estado;
    }

    public int getNumEstrellas() {
        return numEstrellas;
    }

    public void setNumEstrellas(int numeroBola) {
        this.numEstrellas = numeroBola;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String localizacion) {
        this.ubicacion = localizacion;
    }

    public boolean getEstado() {
        return estado;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
}
