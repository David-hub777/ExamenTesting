package com.examen.dragonball.models;

public class DragonballOwn {
    private int stardots;
    private boolean found;// Conseguida o no Conseguida

    public DragonballOwn() {
    }

    public DragonballOwn(int numeroBola, boolean estado) {
        this.stardots = numeroBola;
        this.found = estado;
    }

    public int getStardots() {
        return stardots;
    }

    public void setStardots(int numeroBola) {
        this.stardots = numeroBola;
    }

    public boolean getFound() {
        return found;
    }

    public boolean isFound() {
        return found;
    }

    public void setFound(boolean estado) {
        this.found = estado;
    }
    
}
