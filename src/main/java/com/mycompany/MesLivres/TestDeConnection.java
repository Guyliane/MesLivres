package com.mycompany.MesLivres;

import com.mycompany.MesLivres.entity.Auteur;
import com.mycompany.MesLivres.repository.AuteurRepositoryImpl;

public class TestDeConnection {
    public static void main(String... args){
        AuteurRepositoryImpl auteurRepository = new AuteurRepositoryImpl();
        Auteur jiji = new Auteur();
        jiji.setPrenom("Jiss");
        jiji.setNom("Mock");
        auteurRepository.create(jiji);

        System.out.println("L'id de "+jiji.getPrenom()+" est : "+ jiji.getId());

    }
}


