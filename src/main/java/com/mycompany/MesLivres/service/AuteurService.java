package com.mycompany.MesLivres.service;

import com.mycompany.MesLivres.entity.Auteur;
import com.mycompany.MesLivres.repository.AuteurRepositoryImpl;

public class AuteurService {

    private AuteurRepositoryImpl auteurRepository;

    public AuteurService(){
        this.auteurRepository = new AuteurRepositoryImpl();
    }

    public void createAuteur(Auteur auteur){auteurRepository.create(auteur);}
}
