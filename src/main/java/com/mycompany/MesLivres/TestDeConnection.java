package com.mycompany.MesLivres;

import com.mycompany.MesLivres.entity.Auteur;
import com.mycompany.MesLivres.repository.AuteurRepositoryImpl;

public class TestDeConnection {
    public static void main(String... args){
        AuteurRepositoryImpl auteurRepository = new AuteurRepositoryImpl();
        Auteur bill = auteurRepository.getById(6L);
        bill.setNom("Maskof");
        auteurRepository.update(bill);

    }
}


