package com.example.marriage.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Personne {
    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id ;
    private String cin ;
    private String nom ;
    private String prenom ;

    @OneToMany(mappedBy = "personneEpoux",  fetch = FetchType.EAGER)
    private List<Marriage> MariagesEpous = new ArrayList<>() ;

    @OneToMany(mappedBy = "personneEpouse" , fetch = FetchType.EAGER)
    private List<Marriage> MarriageEpouse = new ArrayList<>() ;

    public Personne() {
    }

    public Personne(Long id, String cin, String nom, String prenom, List<Marriage> mariagesEpous, List<Marriage> marriageEpouse) {
        this.id = id;
        this.cin = cin;
        this.nom = nom;
        this.prenom = prenom;
        MariagesEpous = mariagesEpous;
        MarriageEpouse = marriageEpouse;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public List<Marriage> getMariagesEpous() {
        return MariagesEpous;
    }

    public void setMariagesEpous(List<Marriage> mariagesEpous) {
        MariagesEpous = mariagesEpous;
    }

    public List<Marriage> getMarriageEpouse() {
        return MarriageEpouse;
    }

    public void setMarriageEpouse(List<Marriage> marriageEpouse) {
        MarriageEpouse = marriageEpouse;
    }

    @Override
    public String toString() {
        return "Personne{" +
                "id=" + id +
                ", cin='" + cin + '\'' +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", MariagesEpous=" + MariagesEpous +
                ", MarriageEpouse=" + MarriageEpouse +
                '}';
    }
}
