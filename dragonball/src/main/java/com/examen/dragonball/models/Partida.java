package com.examen.dragonball.models;

import java.util.ArrayList;

public class Partida {
    
    Jugador jugador1;
    Jugador jugador2;
    int ronda;
    String winner;
    ArrayList<String> players = new ArrayList<String>();

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
    public String getWinner() {
        return winner;
    }
    public void setWinner(String ganador) {
        this.winner = ganador;
    }
    public void addWinner(String ganador) {
        ronda++;
        this.winner = ganador;
        if(ganador.equals("jugador1")){
            players.add("j1");
        }else
            players.add("j2");
        
    }

    
    public Partida(Jugador jugador1, Jugador jugador2, int ronda) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.ronda = ronda;
        // this.winner.add(winner) ;
    }
    public ArrayList<String> getPlayers() {
        return players;
    }
    public void setPlayers(ArrayList<String> players) {
        this.players = players;
    }
}
