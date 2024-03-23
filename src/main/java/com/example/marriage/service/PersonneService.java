package com.example.marriage.service;

import com.example.marriage.entities.Marriage;
import com.example.marriage.entities.Personne;
import com.example.marriage.entities.Salle;
import com.example.marriage.repositories.MarriageRepo;
import com.example.marriage.repositories.PersonneRepo;
import com.example.marriage.repositories.SalleRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonneService {
    private PersonneRepo personneRepo ;
    private SalleRepo salleRepo ;
    private MarriageRepo marriageRepo ;
    private MarriageService marriageService ;


    public PersonneService(PersonneRepo personneRepo, SalleRepo salleRepo, MarriageRepo marriageRepo, MarriageService marriageService) {
        this.personneRepo = personneRepo;
        this.salleRepo = salleRepo;
        this.marriageRepo = marriageRepo;
        this.marriageService = marriageService;
    }

    public List<Personne> getAll(){
        return this.personneRepo.findAll();
    }

    public Personne getPersonneById(Long id ) {
        return this.personneRepo.findById(id).orElseThrow(()->new RuntimeException("makaynch epoux")) ;
    }

    public Personne addPersonne(Personne personne ) {
        return this.personneRepo.save(personne) ;

    }

    public void deletePersonne(Personne personne) {
        this.personneRepo.delete(personne);
    }

    public Personne updatePersonne(Personne personne){
        if (this.getPersonneById(personne.getId())!= null){
            return this.personneRepo.save(personne) ;
        }

        return null;

    }


    public Marriage reserver(Long epouseId  , Long epouId , Marriage marriage){
        Personne homme = this.getPersonneById(epouId) ;
        Personne femme = this.getPersonneById(epouseId) ;

        homme.getMariagesEpous().add(marriage) ;
        femme.getMarriageEpouse().add(marriage) ;

        marriage.setPersonneEpoux(homme) ;
        marriage.setPersonneEpouse(femme);

        this.personneRepo.save(homme) ;
        this.personneRepo.save(femme) ;
        this.marriageRepo.save(marriage) ;
        return marriage ;

    }

    public Salle confirmer(Long marriagenum , Salle salle){
            Marriage marriage = this.marriageService.getMarById(marriagenum) ;

            marriage.setSalle(salle);
            salle.getMarriages().add(marriage);

            salleRepo.save(salle) ;
            marriageRepo.save(marriage) ;

        return salle  ;
    }





}
