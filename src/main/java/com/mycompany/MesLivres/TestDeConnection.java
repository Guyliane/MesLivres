package com.mycompany.MesLivres;

import com.mycompany.MesLivres.entity.Auteur;
import com.mycompany.MesLivres.entity.Livre;
import com.mycompany.MesLivres.repository.AuteurRepositoryImpl;
import com.mycompany.MesLivres.service.AuteurService;
import com.mycompany.MesLivres.service.LivreService;

public class TestDeConnection {
    public static void main(String... args){
        LivreService livreService = new LivreService();
        Livre unLivre = new Livre();

        AuteurService auteurService = new AuteurService();
        Auteur unAuteur = new Auteur();
        unAuteur = auteurService.getById(5L);

        unLivre.setTitre("Le R1+triangle pour les nuls");
        unLivre.setResume("Un livre pour apprendre a faire le R1+triangle mais mal");
        unLivre.setAuteur(unAuteur);

        unAuteur.setLivre(unLivre);

        livreService.enregistrerLivre(unLivre);

        System.out.println("L'auteur qui a ecrit le livre : "+unLivre.getTitre()+" est : "+unLivre.getAuteur().getPrenom());

    }
}


