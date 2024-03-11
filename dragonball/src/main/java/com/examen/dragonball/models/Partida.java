package com.examen.dragonball.models;

import java.util.ArrayList;

public class Partida {
    
    Jugador jugador1;
    Jugador jugador2;
    int ronda;
    ArrayList<String> winner;

    public Jugador getJugador1() {
        return jugador1;
    }
    public void setJugador1(Jugador jugador1) {
        this.jugador1 = jugador1;
    }
    public Jugador getJugador2() {
        return jugador2;
    }
    public void setJugador2(Jugador jugador2) {
        this.jugador2 = jugador2;
    }
    public int getRonda() {
        return ronda;
    }
    public void setRonda(int ronda) {
        this.ronda = ronda;
    }
    public ArrayList<String> getWinner() {
        return winner;
    }
    public void setWinner(ArrayList<String> winner) {
        this.winner = winner;
    }
    public void addWinner(String jugador) {
        ronda++;
        this.winner.add(jugador);
    }

    
    public Partida(Jugador jugador1, Jugador jugador2, int ronda, String winner) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.ronda = ronda;
        this.winner.add(winner) ;
    }
}
