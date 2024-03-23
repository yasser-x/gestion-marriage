package com.example.marriage.controller;

import com.example.marriage.entities.Marriage;
import com.example.marriage.entities.Personne;
import com.example.marriage.entities.Salle;
import com.example.marriage.service.PersonneService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Personne")
public class PersonneController {
    private PersonneService personneService ;

    public PersonneController(PersonneService personneService) {
        this.personneService = personneService;
    }
    @GetMapping("/")
    public List<Personne> getAll(){
        return this.personneService.getAll() ;
    }
    @GetMapping("/{id}")
    public Personne getPersonneById(@PathVariable Long id){
        return this.personneService.getPersonneById(id) ;
    }
    @PostMapping("/add")
    public Personne addPersonne(@RequestBody Personne personne){
        return this.personneService.addPersonne(personne);
    }

    @DeleteMapping("/delete/{personne}")
    public void deletePersonne(@PathVariable Personne personne){
        this.personneService.deletePersonne(personne);
    }
    @PostMapping("/reserver/{hommeid}/{femmeid}")
    public Marriage reserver(@PathVariable Long hommeid , @PathVariable Long femmeid , @RequestBody Marriage marriage){
        return this.personneService.reserver(hommeid, femmeid, marriage) ;
    }

    @PostMapping
    public Salle confirmer(Long marriageId , Salle salle){
        return this.personneService.confirmer(marriageId , salle) ;
    }









}
