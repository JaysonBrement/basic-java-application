package com.example;

public class Agence {
    private String nom;
    private String adresse;
    private String codePostal;
    private String ville;
    private Boolean restaurant;
    private Boolean ticketsResto;
    
    public Agence(String nom, String adresse, String codePostal, String ville, Boolean restaurant, Boolean ticketsResto) {
        this.nom = nom;
        this.adresse = adresse;
        this.codePostal = codePostal;
        this.ville = ville;
        this.restaurant = restaurant;
        this.ticketsResto = ticketsResto;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getAdresse() {
        return adresse;
    }
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
    public String getCodePostal() {
        return codePostal;
    }
    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }
    public String getVille() {
        return ville;
    }
    public void setVille(String ville) {
        this.ville = ville;
    }
    public Boolean getRestaurant() {
        return restaurant;
    }
    public void setRestaurant(Boolean restaurant) {
        this.restaurant = restaurant;
    }
    public Boolean getTicketsResto() {
        return ticketsResto;
    }
    public void setTicketsResto(Boolean ticketsResto) {
        this.ticketsResto = ticketsResto;
    }
    
    

}
