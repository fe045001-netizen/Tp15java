package com.example;

import java.util.function.IntPredicate;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;
import java.util.function.IntSupplier;

public class InterfacesPrimitives {
    public static void main(String[] args) {
        // IntPredicate - évite le boxing/unboxing
        IntPredicate estPair = n -> n % 2 == 0;
        System.out.println("5 est pair: " + estPair.test(5));
        System.out.println("6 est pair: " + estPair.test(6));
        
        // IntConsumer
        IntConsumer afficheur = n -> System.out.println("Nombre: " + n);
        afficheur.accept(42);
        
        // IntFunction<R>
        IntFunction<String> convertisseur = n -> "Valeur: " + n;
        System.out.println(convertisseur.apply(100));
        
        // IntSupplier
        IntSupplier de = () -> (int)(Math.random() * 6) + 1;
        System.out.println("Lancer de dé: " + de.getAsInt());
    }
}