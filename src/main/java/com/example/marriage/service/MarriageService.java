package com.example.marriage.service;

import com.example.marriage.entities.Invite;
import com.example.marriage.entities.Marriage;
import com.example.marriage.repositories.InviteRepo;
import com.example.marriage.repositories.MarriageRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class MarriageService {
    private MarriageRepo marriageRepo;
    private InviteRepo inviteRepo  ;
    private InviteService inviteService ;

    public MarriageService() {
    }

    public MarriageService(MarriageRepo marriageRepo, InviteRepo inviteRepo, InviteService inviteService) {
        this.marriageRepo = marriageRepo;
        this.inviteRepo = inviteRepo;
        this.inviteService = inviteService;
    }

    public List<Marriage> getAll(){
        return  this.marriageRepo.findAll() ;

    }

    public Marriage getMarById( Long Id ){
        return this.marriageRepo.findById(Id).orElseThrow(()->new RuntimeException("makaynch marriage")) ;
    }

    public Marriage AddMariage(Marriage marriage) {
        return this.marriageRepo.save(marriage) ;
    }

    public  void deleteMarriage(Marriage marriage){
        this.marriageRepo.delete(marriage);
    }

    public Marriage QrMarriage(Long mar_id  , Invite invite){
        Marriage marriage = this.getMarById(mar_id) ;
        marriage.getInvites().add(invite) ;
        invite.getMarriages().add(marriage) ;

        marriageRepo.save(marriage) ;
        inviteRepo.save(invite);


        return marriage ;
    }



}
