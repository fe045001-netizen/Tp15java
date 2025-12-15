package com.example;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamBasics {
    public static void main(String[] args) {
        List<String> noms = Arrays.asList("Jean", "Pierre", "Marie", "Sophie", "Paul");
        
        // Filtrer les noms qui commencent par 'P'
        List<String> nomsP = noms.stream()
                                 .filter(nom -> nom.startsWith("P"))
                                 .collect(Collectors.toList());
        System.out.println("Noms commençant par P: " + nomsP);
        
        // Transformer chaque nom en majuscules
        List<String> nomsMajuscules = noms.stream()
                                         .map(String::toUpperCase)
                                         .collect(Collectors.toList());
        System.out.println("Noms en majuscules: " + nomsMajuscules);
        
        // Compter les noms de plus de 4 lettres
        long count = noms.stream()
                        .filter(nom -> nom.length() > 4)
                        .count();
        System.out.println("Nombre de noms avec plus de 4 lettres: " + count);
    }
}