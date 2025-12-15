package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Pattern;

class Validateur<T> {
    private final List<Regle<T>> regles = new ArrayList<>();
    
    public Validateur<T> ajouterRegle(Predicate<T> test, String messageErreur) {
        regles.add(new Regle<>(test, messageErreur));
        return this;
    }
    
    public List<String> valider(T valeur) {
        List<String> erreurs = new ArrayList<>();
        for (Regle<T> regle : regles) {
            if (!regle.test.test(valeur)) {
                erreurs.add(regle.messageErreur);
            }
        }
        return erreurs;
    }
    
    private static class Regle<T> {
        final Predicate<T> test;
        final String messageErreur;
        
        Regle(Predicate<T> test, String messageErreur) {
            this.test = test;
            this.messageErreur = messageErreur;
        }
    }
}

public class ValidationFormulaire {
    public static void main(String[] args) {
        // Validateur pour email
        Validateur<String> validateurEmail = new Validateur<String>()
            .ajouterRegle(s -> s != null && !s.isEmpty(), "L'email ne peut pas être vide")
            .ajouterRegle(s -> s.contains("@"), "L'email doit contenir @")
            .ajouterRegle(s -> Pattern.matches(".+@.+\\..+", s), "Format d'email invalide");
        
        // Test avec différentes valeurs
        List<String> emails = List.of("user@example.com", "", "invalide", "user@domaine");
        
        for (String email : emails) {
            List<String> erreurs = validateurEmail.valider(email);
            if (erreurs.isEmpty()) {
                System.out.println("Email valide: " + email);
            } else {
                System.out.println("Email invalide: " + email);
                erreurs.forEach(err -> System.out.println("  - " + err));
            }
        }
    }
}
