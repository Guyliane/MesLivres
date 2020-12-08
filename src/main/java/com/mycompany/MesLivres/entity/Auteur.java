package com.mycompany.MesLivres.entity;

public class Auteur {
    private Long Id;
    private String nom;
    private String prenom;

    //region Getters & Setters
    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    //endregion
}
