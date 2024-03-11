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

    @GetMapping(path = "/bolasdeDragon/radar", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Dragonball>> getBolasdeDragon() {
        return new ResponseEntity<List<Dragonball>>(bolasdeDragon, HttpStatus.OK);
    }

    
}