package com.examen.dragonball.restController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.examen.dragonball.models.Dragonball;

@RestController
@RequestMapping(path = "/dragonball")
public class DragonBallRestController {
    String[] localizacionesBolasdeDragon = { 
        "Planeta Tierra A",
        "Planeta Namek A", 
        "Planeta Tierra B",
        "Planeta NamekB",
        "Planeta Tierra C",
        "Planeta NamekC",
        "Planeta Tierra D",
    };

    List<Dragonball> bolasdeDragon = new ArrayList<Dragonball>(Arrays.asList(
        new Dragonball(1, localizacionesBolasdeDragon[0], false),
        new Dragonball(2, localizacionesBolasdeDragon[1], false),
        new Dragonball(3, localizacionesBolasdeDragon[2], false),
        new Dragonball(4, localizacionesBolasdeDragon[3], false),
        new Dragonball(5, localizacionesBolasdeDragon[4], false),
        new Dragonball(6, localizacionesBolasdeDragon[5], false),
        new Dragonball(7, localizacionesBolasdeDragon[6], false)
    ));

    @GetMapping(path = "/radar", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Dragonball>> getBolasdeDragon() {
        return new ResponseEntity<List<Dragonball>>(bolasdeDragon, HttpStatus.OK);
    }

    @GetMapping(path = "/owned", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Dragonball>> getOwnedBolasdeDragon() {
        return new ResponseEntity<List<Dragonball>>(bolasdeDragon.stream().filter(b -> b.isEstado()).collect(Collectors.toList()), HttpStatus.OK);
    }

    @GetMapping(path = "/get{ball}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Dragonball> getBolaDeDragon(@PathVariable int ball) {
        Dragonball bola = bolasdeDragon.stream().filter(b -> b.getNumEstrellas() == ball).findFirst().orElse(null);
        if (bola != null) {
            return new ResponseEntity<Dragonball>(bola, HttpStatus.OK);
        } else {
            return new ResponseEntity<Dragonball>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(path = "/invokeDragon", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Dragonball> addBolaDeDragon(@RequestBody Dragonball bola) {
        if (bolasdeDragon.stream().filter(b -> b.getNumEstrellas() == bola.getNumEstrellas()).findFirst().orElse(null) == null) {
            bolasdeDragon.add(bola);
            return new ResponseEntity<Dragonball>(bola, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<Dragonball>(HttpStatus.CONFLICT);
        }
    }

    
}