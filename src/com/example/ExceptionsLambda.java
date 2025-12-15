package com.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

// Interface fonctionnelle qui peut lancer une exception
@FunctionalInterface
interface IOFunction<T, R> {
    R apply(T t) throws IOException;
    
    // Méthode utilitaire pour transformer en Function standard
    static <T, R> Function<T, R> unchecked(IOFunction<T, R> f) {
        return t -> {
            try {
                return f.apply(t);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        };
    }
}

public class ExceptionsLambda {
    public static void main(String[] args) {
        // Exemple 1: Gestion directe dans la lambda
        try {
            List<String> fichiers = Files.list(Paths.get("."))
                                        .map(p -> {
                                            try {
                                                return Files.size(p) + " - " + p.getFileName();
                                            } catch (IOException e) {
                                                return "Erreur: " + p.getFileName();
                                            }
                                        })
                                        .collect(Collectors.toList());
            System.out.println("Fichiers: " + fichiers);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        // Exemple 2: Utilisation de notre interface IOFunction
        try {
            List<Long> tailles = Files.list(Paths.get("."))
                                     .map(IOFunction.unchecked(Files::size))
                                     .collect(Collectors.toList());
            System.out.println("Tailles: " + tailles);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}