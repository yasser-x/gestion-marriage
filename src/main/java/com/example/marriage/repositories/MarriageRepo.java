package com.example.marriage.repositories;

import com.example.marriage.entities.Marriage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarriageRepo extends JpaRepository<Marriage, Long> {
}
