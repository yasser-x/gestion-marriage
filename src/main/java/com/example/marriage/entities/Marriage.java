package com.example.marriage.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Marriage {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Numero ;
    private LocalDate Date ;
    private int NbrMinTemoins ;
    private int capaciteMin ;
    private int nombreMaximalEpoux ;

    @ManyToOne
    private Personne personneEpoux ;

    @ManyToOne
    private Personne personneEpouse ;

    @ManyToOne
    private Salle salle ;

    @ManyToMany
    @JoinTable(name = "marriage-invite")
    private List<Invite> invites;

    public Marriage() {
    }

    public Marriage(Long numero, LocalDate date, int nbrMinTemoins, int capaciteMin, int nombreMaximalEpoux, Personne personneEpoux, Personne personneEpouse, Salle salle) {
        Numero = numero;
        Date = date;
        NbrMinTemoins = nbrMinTemoins;
        this.capaciteMin = capaciteMin;
        this.nombreMaximalEpoux = nombreMaximalEpoux;
        this.personneEpoux = personneEpoux;
        this.personneEpouse = personneEpouse;
        this.salle = salle;
    }

    public Long getNumero() {
        return Numero;
    }

    public void setNumero(Long numero) {
        Numero = numero;
    }

    public LocalDate getDate() {
        return Date;
    }

    public void setDate(LocalDate date) {
        Date = date;
    }

    public int getNbrMinTemoins() {
        return NbrMinTemoins;
    }

    public void setNbrMinTemoins(int nbrMinTemoins) {
        NbrMinTemoins = nbrMinTemoins;
    }

    public int getCapaciteMin() {
        return capaciteMin;
    }

    public void setCapaciteMin(int capaciteMin) {
        this.capaciteMin = capaciteMin;
    }

    public int getNombreMaximalEpoux() {
        return nombreMaximalEpoux;
    }

    public void setNombreMaximalEpoux(int nombreMaximalEpoux) {
        this.nombreMaximalEpoux = nombreMaximalEpoux;
    }

    public Personne getPersonneEpoux() {
        return personneEpoux;
    }

    public void setPersonneEpoux(Personne personneEpoux) {
        this.personneEpoux = personneEpoux;
    }

    public Personne getPersonneEpouse() {
        return personneEpouse;
    }

    public void setPersonneEpouse(Personne personneEpouse) {
        this.personneEpouse = personneEpouse;
    }

    public Salle getSalle() {
        return salle;
    }

    public void setSalle(Salle salle) {
        this.salle = salle;
    }

    public List<Invite> getInvites() {
        return invites;
    }

    public void setInvites(List<Invite> invites) {
        this.invites = invites;
    }

    @Override
    public String toString() {
        return "Marriage{" +
                "Numero=" + Numero +
                ", Date=" + Date +
                ", NbrMinTemoins=" + NbrMinTemoins +
                ", capaciteMin=" + capaciteMin +
                ", nombreMaximalEpoux=" + nombreMaximalEpoux +
                ", personneEpoux=" + personneEpoux +
                ", personneEpouse=" + personneEpouse +
                ", salle=" + salle +
                '}';
    }
}
