package com.example.marriage.service;

import com.example.marriage.entities.Invite;
import com.example.marriage.repositories.InviteRepo;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class InviteService {
    private InviteRepo inviteRepo ;

    public List<Invite> getAll() {
        return this.inviteRepo.findAll() ;
    }

    public Invite getInviteById(Long id ) {
        return this.inviteRepo.findById(id).orElseThrow(()->new RuntimeException("makaynch invite")) ;
    }

    public Invite addInvite(Invite invite){
        return this.inviteRepo.save(invite) ;
    }

    public void deleteInvite(Invite invite){
        this.inviteRepo.delete(invite);
    }
}
