package com.example.marriage.repositories;

import com.example.marriage.entities.Invite;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InviteRepo extends JpaRepository<Invite , Long> {

}
