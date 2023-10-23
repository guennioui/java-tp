package com.mycompany.exercice2;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Exercice2 {

    public static void main(String[] args) {
        DecimalFormat decimalFormat = new DecimalFormat("0.00");         
        double salary = 0.0;
        double nbParts = 0.0;
        int nombreEnfant = 0;
        int situationFamilial;
        double r = 0.0;
        double coefFamilial = 0.0;                
        double[][] myArr = { 
            {4262,0,0}, 
            {8382, 0.0683, 291.09},
            {14753, 0.1914, 1322.92},
            {23888, 0.2826, 2668.39},
            {38868, 0.3738, 4846.98},
            {47932, 0.4262, 6883.66}, 
            {0, 0.4809, 9505.54}            
        }; 
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Entrer votre salaire: ");
        salary = scanner.nextDouble();       
        System.out.println("Entrer le nombre de vos enfant: ");
        nombreEnfant = scanner.nextInt();        
        System.out.println("Entrer votre situation familial: ");
        System.out.println("1 : marier");
        System.out.println("2 : celibataire");
        situationFamilial = scanner.nextInt();        
        
        scanner.close();
        
        if(situationFamilial == 1){          
            if(nombreEnfant <= 2){
                nbParts = nombreEnfant/2+2;
            }else{
                nbParts += nbParts/2;
            }
        }else if(situationFamilial == 2){
             if(nombreEnfant <= 2){
                 nbParts = nombreEnfant/2+1;
            }else{
                 nbParts += nbParts/2;
            }
        }
        r = 0.72 * salary * 12;
        coefFamilial = r / nbParts;        
                
        double min = coefFamilial;
        double max = 0.0;
        double medium = Double.MAX_VALUE;
        double coeffR = 0.0;
        double coeffN = 0.0;
        double impot = 0.0;
        
       for (int row = 0; row < myArr.length; row++) {
            if(myArr[row][0] > max){
                    max = myArr[row][0];                     
            }
        }
        
        for (int row = 0; row < myArr.length; row++) {           
            if(myArr[row][0] > coefFamilial){
                if(myArr[row][0] >= min && myArr[row][0] <= max && myArr[row][0] < medium){
                   medium = myArr[row][0];
                   coeffR = myArr[row][1];
                   coeffN = myArr[row][2];
                }
            }else if(myArr[row][0] == coefFamilial){
                medium = myArr[row][0];
                coeffR = myArr[row][1];
                coeffN = myArr[row][2];
            }else if(coefFamilial > max){
                medium = myArr[myArr.length-1][0];
                coeffR = myArr[myArr.length-1][1];
                coeffN = myArr[myArr.length-1][2];
            }             
        }
        
        impot = coeffR * r - coeffN * nbParts;
        
        System.out.println("R:"+r);
        System.out.println("QF:"+coefFamilial);
        System.out.println("medium: "+medium+" coeffR: "+coeffR+" coeffN: "+coeffN+"max: "+max); 
              
        System.out.println("Details du calcul: ");
        System.out.println("Nombre de parts: "+nbParts);
        System.out.println("Revenu imposable: "+decimalFormat.format(r));
        System.out.println("Quotient familial: "+decimalFormat.format(coefFamilial));
        System.out.println("impot a payer: "+decimalFormat.format(impot));
    }
}
