package com.example;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
public class ComparateurCompose {
    public static void main(String[] args) {
        List<Personne> personnes = Arrays.asList(
            new Personne("Jean", "Dupont", 30),
            new Personne("Marie", "Martin", 25),
            new Personne("Pierre", "Dupont", 40),
            new Personne("Sophie", "Martin", 35),
            new Personne("Paul", "Dupont", 20)
        );
        
        // Comparateur composé: d'abord par nom, puis par prénom, puis par âge
        Comparator<Personne> comparateur = Comparator
            .comparing(Personne::getNom)
            .thenComparing(Personne::getPrenom)
            .thenComparingInt(Personne::getAge);
        
        // Tri et affichage
        System.out.println("Liste triée:");
        personnes.stream()
            .sorted(comparateur)
            .forEach(System.out::println);
        
        // Variante: tri par nom (ordre naturel) puis par âge (ordre décroissant)
        Comparator<Personne> comparateurVariante = Comparator
            .comparing(Personne::getNom)
            .thenComparing(Personne::getAge, Comparator.reverseOrder());
        
        System.out.println("\nListe triée (variante):");
        personnes.stream()
            .sorted(comparateurVariante)
            .forEach(System.out::println);
    }
}