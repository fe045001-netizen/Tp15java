package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.Consumer;


public class ReferencesMethodes {
    public static void main(String[] args) {
        // Référence à une méthode statique
        Function<String, Integer> parser = Integer::parseInt;
        System.out.println("Parsing: " + parser.apply("123"));
        
        // Référence à une méthode d'instance sur un objet particulier
        Consumer<String> printer = System.out::println;
        printer.accept("Via référence de méthode");
        
        // Référence à une méthode d'instance sur un type arbitraire
        BiFunction<String, String, Boolean> comparateur = String::equalsIgnoreCase;
        System.out.println("Comparaison: " + comparateur.apply("hello", "HELLO"));
        
        // Référence à un constructeur
        Supplier<List<String>> listFactory = ArrayList::new;
        List<String> liste = listFactory.get();
        liste.add("élément");
        System.out.println("Liste créée: " + liste);
        
        // Référence à un constructeur de tableau
        Function<Integer, String[]> arrayCreator = String[]::new;
        String[] array = arrayCreator.apply(5);
        array[0] = "Premier";
        System.out.println("Taille du tableau: " + array.length);
    }
}