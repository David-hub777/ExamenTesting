package com.examen.dragonball.restController;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.examen.dragonball.models.Jugador;
import com.examen.dragonball.models.Partida;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping(path = "/jankenpon")
public class JanKenPonController {
    
    Jugador jugador1 = new Jugador("Jugador1", "");
    Jugador jugador2 = new Jugador("Jugador2", "");
    Partida partida = new Partida(jugador1,jugador2,0);
    String[]elecciones = {"piedra","papel","tijeras"};
    

    @PostMapping(path="/play", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Partida> play(@RequestParam String jugador1, @RequestParam String jugador2) {
        String winner ="";
        System.out.println(jugador1);
        if(jugador1.equals(elecciones[0]) && jugador2.equals(elecciones[2])){
            winner = "jugador1";
            partida.addWinner(winner);
            return new ResponseEntity<Partida>(partida, HttpStatus.ACCEPTED);
        }else if(jugador1.equals(elecciones[1]) && jugador2.equals(elecciones[0])){
            winner = "jugador1";
            partida.addWinner(winner);
            
            return new ResponseEntity<Partida>(partida, HttpStatus.ACCEPTED);
        }else if(jugador1.equals(elecciones[2]) && jugador2.equals(elecciones[1])){
            winner = "jugador1";
            partida.addWinner(winner);
            return new ResponseEntity<Partida>(partida, HttpStatus.ACCEPTED);
        }else if(jugador1.equals(jugador2)){
            winner = "Empate";
            partida.addWinner(winner);
            return new ResponseEntity<Partida>(partida, HttpStatus.ACCEPTED);
        }else{
            winner = "jugador2";
            partida.addWinner(winner);
            return new ResponseEntity<Partida>(partida, HttpStatus.ACCEPTED);
        }
		
		
	}

    @GetMapping(path="/results/{jugador}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String results(@PathVariable String jugador) {
        return new String();
    }
    
}
