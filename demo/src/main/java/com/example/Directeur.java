package com.example;

public class Directeur extends Emploi{

    public Directeur(String nom, String prenom, String dateEmbauche, String fonction, int salaire, String service,
            Agence agence, Boolean chequeVacance, Enfants enfants) {
        super(nom, prenom, dateEmbauche, fonction, salaire, service, agence, chequeVacance, enfants);
    }
    @Override
    public double calculPrime(int yearDiff){
        double montantprime = (this.Salaire*0.02+this.Salaire*0.07)*yearDiff;
    
        return (double)montantprime;
    }
}
