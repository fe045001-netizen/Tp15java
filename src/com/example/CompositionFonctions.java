package com.example;

import java.util.function.Function;
import java.util.function.Predicate;

public class CompositionFonctions {
    public static void main(String[] args) {
        // Composition de Function avec andThen et compose
        Function<String, Integer> longueur = String::length;
        Function<Integer, Boolean> estPair = n -> n % 2 == 0;
        
        // andThen: applique la première fonction puis la seconde
        Function<String, Boolean> longueurEstPaire = longueur.andThen(estPair);
        System.out.println("'Bonjour' a une longueur paire: " + longueurEstPaire.apply("Bonjour"));
        
        // compose: applique la seconde fonction puis la première
        Function<String, Boolean> longueurEstPaire2 = estPair.compose(longueur);
        System.out.println("'Hello' a une longueur paire: " + longueurEstPaire2.apply("Hello"));
        
        // Composition de Predicate avec and, or, negate
        Predicate<String> commenceParA = s -> s.startsWith("A");
        Predicate<String> longueurSup5 = s -> s.length() > 5;
        
        Predicate<String> commenceParAEtLong = commenceParA.and(longueurSup5);
        Predicate<String> commenceParAOuLong = commenceParA.or(longueurSup5);
        Predicate<String> neCommencePasParA = commenceParA.negate();
        
        System.out.println("'Alphabet' commence par A et est long: " + commenceParAEtLong.test("Alphabet"));
        System.out.println("'Abc' commence par A ou est long: " + commenceParAOuLong.test("Abc"));
        System.out.println("'Bonjour' ne commence pas par A: " + neCommencePasParA.test("Bonjour"));
    }
}