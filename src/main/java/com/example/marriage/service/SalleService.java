package com.example.marriage.service;

import com.example.marriage.entities.Salle;
import com.example.marriage.repositories.SalleRepo;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SalleService {
    private SalleRepo salleRepo ;
    public List<Salle> getAll(){
        return this.salleRepo.findAll() ;
    }
    public Salle getSalleById(Long id) {
        return this.salleRepo.findById(id).orElseThrow(()->new RuntimeException("makaynach salle"))  ;
    }

    public Salle addSalle(Salle salle){
        return this.salleRepo.save(salle) ;
    }
    public void deleteSalle(Salle salle) {
        this.salleRepo.delete(salle);
    }
}
