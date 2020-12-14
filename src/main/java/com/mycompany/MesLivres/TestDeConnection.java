package com.mycompany.MesLivres;

import com.mycompany.MesLivres.entity.Auteur;
import com.mycompany.MesLivres.repository.AuteurRepositoryImpl;
import com.mycompany.MesLivres.service.AuteurService;

public class TestDeConnection {
    public static void main(String... args){
        AuteurService auteurService = new AuteurService();
        Auteur jiji = new Auteur();
        jiji.setPrenom("Jiss");
        jiji.setNom("Mock");
        auteurService.createAuteur(jiji);

        System.out.println("L'id de "+jiji.getPrenom()+" est : "+ jiji.getId());

    }
}


