package com.example.marriage.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Invite extends Personne{
    @Enumerated(EnumType.STRING)
    private StatutInv statut;

    public Invite(Long id, String cin, String nom, String prenom, List<Marriage> mariagesEpous, List<Marriage> marriageEpouse, StatutInv statut) {
        super(id, cin, nom, prenom, mariagesEpous, marriageEpouse);
        this.statut = statut;
    }

    public Invite() {

    }

    public StatutInv getStatut() {
        return statut;
    }

    public void setStatut(StatutInv statut) {
        this.statut = statut;
    }

    @ManyToMany(mappedBy = "invites")
    private List<Marriage> marriages;

    public List<Marriage> getMarriages() {
        return marriages;
    }

    public void setMarriages(List<Marriage> marriages) {
        this.marriages = marriages;
    }
}
