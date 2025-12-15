package com.example;

import java.util.function.IntUnaryOperator;

public class CaptureLambda {
    public static void main(String[] args) {
        // Capture d'une variable locale
        int facteur = 10;
        IntUnaryOperator multiplicateur = n -> n * facteur;
        
        // La variable doit être effectivement finale
        // facteur = 20; // Erreur de compilation si décommenté
        
        System.out.println("5 * " + facteur + " = " + multiplicateur.applyAsInt(5));
        
        // Capture de this
        new CaptureLambda().demoThis();
    }
    
    private int valeur = 100;
    
    private void demoThis() {
        Runnable r = () -> {
            // this fait référence à l'instance de CaptureLambda
            System.out.println("Valeur capturée: " + this.valeur);
        };
        r.run();
    }
}