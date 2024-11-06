package com.example;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.Collections;

public class Emploi{
    private String nom;
    private String prenom;
    private String DateEmbauche;
    private String Fonction;
    protected int Salaire;
    private String Service;
    private Agence agence;
    private Boolean chequeVacance;
    private Enfants enfants;

    




    



    public Emploi(String nom, String prenom, String dateEmbauche, String fonction, int salaire, String service, Agence agence, Boolean chequeVacance, Enfants enfants) {
        this.nom = nom;
        this.prenom = prenom;
        DateEmbauche = dateEmbauche;
        Fonction = fonction;
        Salaire = salaire;
        Service = service;
        this.agence = agence;
        this.chequeVacance = chequeVacance;
        this.enfants = enfants;
        
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





    public String getFonction() {
        return Fonction;
    }


    public void setFonction(String fonction) {
        Fonction = fonction;
    }


    public int getSalaire() {
        return Salaire;
    }


    public void setSalaire(int salaire) {
        Salaire = salaire;
    }


    public String getService() {
        return Service;
    }


    public void setService(String service) {
        Service = service;
    }
    
    


    public Agence getAgence() {
        return agence;
    }


    public void setAgence(Agence agence) {
        this.agence = agence;
    }
    


    public Boolean getChequeVacance() {
        return chequeVacance;
    }


    public void setChequeVacance(Boolean chequeVacance) {
        this.chequeVacance = chequeVacance;
    }

    


    public Enfants getEnfants() {
        return enfants;
    }


    public void setEnfants(Enfants enfants) {
        this.enfants = enfants;
    }


    public double calculPrime(int yearDiff){
        double montantprime = (this.Salaire*0.02)*yearDiff;

        return (double)montantprime;
    }
    public ArrayList<Emploi> InstanceCreator(){
        Agence Agence1 = new Agence(
            "Agence1","5 rue de la boustifaille","59495", "Leffrinckoucke",true,false
        );
        Agence Agence2 = new Agence(
            "Agence2","4 rue du puit","75000", "Paris",true,false
        );
        Agence Agence3 = new Agence(
            "Agence3","3 rue de la rue","123456", "Marseille", false, true
        );

        Emploi employe2 = new Emploi("Aurant","ACharles","01/01/2020","facteur",1000,"courrier",Agence2,false,new Enfants(new int[]{1,17,1}));
        Emploi employe3 = new Emploi("Truc","Machin","01/01/2020","facteur",1000,"courrier",Agence2,false,null);
        Emploi employe4 = new Emploi("Flamel","nicolas","01/01/2020","facteur",1000,"courrier",Agence1,false,new Enfants(new int[]{1,17,1}));
        Emploi employe5 = new Emploi("Bureau","alain","01/01/2020","facteur",1000,"courrier",Agence3,false,null);
        Emploi employe1 = new Emploi("Bureau","Jean","01/01/2020","facteur",1000,"courrier",Agence1,false,new Enfants(new int[]{1,17,1}));
        Directeur Directeur = new Directeur("Omega","Bling","01/01/2020","facteur",1000,"courrier",Agence1,false,null);
        
        
        
        ArrayList<Emploi> employes = new ArrayList<>();
        

        employes.add(employe5);
        employes.add(employe2);
        employes.add(employe3);
        employes.add(employe1);
        employes.add(employe4);
        employes.add(Directeur);

        Collections.sort(employes, Emploi.EmpNomAndPrenomComparator);
        return employes;
    }
    public int dateDiff(){
        int castedDiff = 0;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        
        try {
            Date dateCurrentParsed = sdf.parse("01/01/2024");
            Date dateEmbaucheParsed = sdf.parse(this.DateEmbauche);
            long diffInMillis = dateCurrentParsed.getTime() - dateEmbaucheParsed.getTime();
            long difference_In_Years
                    = (diffInMillis
                    / (1000l * 60 * 60 * 24 * 365));
            castedDiff = (int) difference_In_Years;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return castedDiff;
        
    }

        public static Comparator<Emploi> EmpNomAndPrenomComparator = new Comparator<Emploi>() {

            public int compare(Emploi s1, Emploi s2) {
                String EmploiName1 = s1.getNom().toUpperCase();
                String EmploiName2 = s2.getNom().toUpperCase();
                
                int firstNameComparison = EmploiName1.compareTo(EmploiName2);
                if (firstNameComparison != 0) {
                    return firstNameComparison;
                }
        
                String EmploiLastName1 = s1.getPrenom().toUpperCase();
                String EmploiLastName2 = s2.getPrenom().toUpperCase();
                
                return EmploiLastName1.compareTo(EmploiLastName2);
            }
    
        };
        public void chequeVacanceCheck(int yearsOfService){
            if (yearsOfService >= 1){
                setChequeVacance(true);
            }
        }
        public int[] chequeEnfantCheck(){
            int total = 0;
            int Cheque20 = 0;
            int Cheque30 = 0;
            int Cheque50 = 0;
            if(this.enfants!=null){
                for(int i = 0; i < this.enfants.getAges().length;i++){
                    if(this.enfants.getAges()[i]<10){
                        Cheque20 = Cheque20 + 1;
                        total = total + 20;
                    }
                    if(this.enfants.getAges()[i]>11 && this.enfants.getAges()[i]<15){
                        Cheque30 = Cheque30 + 1;
                        total = total+30;
                    }
                    if(this.enfants.getAges()[i]>16 && this.enfants.getAges()[i]<18){
                        Cheque50 = Cheque50 + 1;
                        total = total+50;
                    }
                    
                }
        }
        int[] machin = {Cheque20, Cheque30, Cheque50, total};
        return machin;
}
    // public double masseSalariale(){
        
    // }
}

// if(this.getAgence().getRestaurant() == true){
//     System.out.println("Restaurant dans l'agence");
// }else{
//     System.out.println("tickets resto");
// }

// System.out.println( "transfert en cours de " + montantprime + " euro vers la banque" );
// System.out.println("Le gars a "+ yearDiff + " ans de boite");
// System.out.println("Cheques noel");
// System.out.println("------------------");
// System.out.println("20 euro :" + Cheque20);
// System.out.println("30 euro :"+ Cheque30);
// System.out.println("50 euro :"+ Cheque50);
// System.out.println("total :"+ total);
// System.out.println("------------------");
