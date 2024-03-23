package com.example.marriage.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Salle {
    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id ;

    private String nom ;
    private String addresse ;
    private String ville ;
    private int capacite  ;

    @OneToMany(mappedBy = "salle" , fetch = FetchType.LAZY)
    private List<Marriage> marriages = new ArrayList<>() ;

    public Salle() {
    }

    public Salle(Long id, String nom, String addresse, String ville, int capacite, List<Marriage> marriages) {
        this.id = id;
        this.nom = nom;
        this.addresse = addresse;
        this.ville = ville;
        this.capacite = capacite;
        this.marriages = marriages;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAddresse() {
        return addresse;
    }

    public void setAddresse(String addresse) {
        this.addresse = addresse;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public int getCapacite() {
        return capacite;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    public List<Marriage> getMarriages() {
        return marriages;
    }

    public void setMarriages(List<Marriage> marriages) {
        this.marriages = marriages;
    }
}
