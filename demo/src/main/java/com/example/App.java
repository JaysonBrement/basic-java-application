package com.example;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

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
        double masseSalariale = 0;
        for(int i = 0; i<employes.size(); i++){
            
            int yearDiff = employes.get(i).dateDiff();
            int[] chequeArray = employes.get(i).chequeEnfantCheck();
            double prime = employes.get(i).calculPrime(yearDiff);
            employes.get(i).chequeVacanceCheck(yearDiff);
            masseSalariale = masseSalariale + employes.get(i).getSalaire()+employes.get(i).calculPrime(yearDiff);
            Boolean Restaurant = employes.get(i).getAgence().getRestaurant();
        
            System.out.println("Employé " + employes.get(i).getNom() + " " + employes.get(i).getPrenom() + " ");
            System.out.println("Agence : " + employes.get(i).getAgence().getNom());
            System.out.println("l'employé à " + yearDiff + "de boite");
            System.out.println( "transfert en cours de " + prime + " euro vers la banque" );
            if(Restaurant){
                System.out.println("Restaurant en agence");
            }else{
                System.out.println("Ticket resto");
            }
            System.out.println("Cheques noel");
            System.out.println("------------------");
            System.out.println("20 euro :" + chequeArray[0]);
            System.out.println("30 euro :"+ chequeArray[1]);
            System.out.println("50 euro :"+ chequeArray[2]);
            System.out.println("total :"+ chequeArray[3]);
            System.out.println("------------------");

            System.out.println(" ------------------------ ");
        }
        
        System.out.println("La masse salariale coute " + masseSalariale);
        
    }
}
