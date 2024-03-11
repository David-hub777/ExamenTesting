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

import com.examen.dragonball.models.DragonballOwn;

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
        List<Dragonball> listaDragonballs = new ArrayList<Dragonball>();
        for (Dragonball bola : bolasdeDragon) {
            if (!bola.isEstado())
            listaDragonballs.add(new Dragonball(bola.getNumEstrellas(), bola.getUbicacion(), bola.getEstado()));
        }
        return new ResponseEntity<List<Dragonball>>(listaDragonballs, HttpStatus.OK);
    }

    @GetMapping(path = "/owned", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Dragonball>> getOwnedBolasdeDragon() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<Dragonball> listaDragonballs = new ArrayList<Dragonball>();
        for(Dragonball bola : bolasdeDragon){
            if(bola.isEstado()){
                listaDragonballs.add(bola);
            }
        }
        return new ResponseEntity<List<Dragonball>>(listaDragonballs, HttpStatus.OK);
    }

    @GetMapping(path = "/get", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DragonballOwn> get(@RequestParam int ball) {
        
        ArrayList<Integer> listaNumEstrellas = new ArrayList<Integer>();
        for(Dragonball bola : bolasdeDragon){
            listaNumEstrellas.add(bola.getNumEstrellas());
            bola.setEstado(true);
        }
        
        for(int numeroBola : listaNumEstrellas){
            if(numeroBola == ball){
                Dragonball dragonball = bolasdeDragon.get(ball-1);
                // dragonball.setEstado(true);
                DragonballOwn Medragonball = new DragonballOwn(dragonball.getNumEstrellas(), dragonball.getEstado());
                return new ResponseEntity<DragonballOwn>(Medragonball, HttpStatus.OK);
            }
        }
        
            // bola.setEstado(true);
            // DragonballOwn Medragonball = new DragonballOwn(bola.getNumEstrellas(), bola.getEstado());
            // return new ResponseEntity<DragonballOwn>(Medragonball, HttpStatus.OK);
            // //Creo un modelo DragonballOwn para devolver stardots y found property
        
        return new ResponseEntity<DragonballOwn>(HttpStatus.NOT_FOUND);
        
    }

    @PostMapping(path = "/invokeDragon", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Dragonball>> invokeDragon() {
        List<Dragonball> listaDragonball = new ArrayList<Dragonball>();
        // for (Dragonball bola : bolasdeDragon) {
        //     if (bola.isEstado()) {
        //         listaDragonballs.add(bola);
        //     }
        // }
        // System.out.println("Se han encontrado todas las bolas de dragon.Invoca a Shenron"+listaDragonballs.size());
        if (bolasdeDragon.size() == 7) {
            System.out.println("Se han encontrado todas las bolas de dragon.Invoca a Shenron");
            for(Dragonball ball : bolasdeDragon){
                ball.setEstado(false);
            }
            // List<Dragonball> listaDragonballs = new ArrayList<Dragonball>();
            // for(Dragonball bola : bolasdeDragon){
            //     if(bola.isEstado()){
            //         listaDragonballs.add(bola);
            //     }
            // }
            return new ResponseEntity<List<Dragonball>>(bolasdeDragon, HttpStatus.I_AM_A_TEAPOT);
        } else {
            return new ResponseEntity<List<Dragonball>>(HttpStatus.CONFLICT);
        }
    }

    
}