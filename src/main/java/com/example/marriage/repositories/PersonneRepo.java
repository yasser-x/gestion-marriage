package com.example.marriage.repositories;

import com.example.marriage.entities.Personne;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonneRepo extends JpaRepository<Personne, Long>{
}
