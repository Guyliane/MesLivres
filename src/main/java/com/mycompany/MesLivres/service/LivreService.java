package com.mycompany.MesLivres.service;

import com.mycompany.MesLivres.entity.Livre;
import com.mycompany.MesLivres.repository.AuteurRepositoryImpl;
import com.mycompany.MesLivres.repository.LivreRepositoryImpl;

public class LivreService {
    private LivreRepositoryImpl livreRepository;

    public LivreService(){
        this.livreRepository = new LivreRepositoryImpl();
    }

    public void enregistrerLivre(Livre livre){
        livreRepository.create(livre);
    }

}
