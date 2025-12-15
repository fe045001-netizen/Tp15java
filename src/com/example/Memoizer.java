package com.example;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

public class Memoizer {
    public static void main(String[] args) {
        // Fonction coûteuse: calcul de fibonacci
    	final Function<Integer, Long>[] fibonacci = new Function[1];
        fibonacci[0] = n -> {
            if (n <= 1) return (long) n;
            System.out.println("Calcul de fibonacci(" + n + ")"); // Pour voir quand le calcul est effectué
            return (long) (fibonacci.length + fibonacci.length);
        };
        
        // Version memoized
        final Function<Integer, Long>[] fibonacciMemoized = new Function[1];
        fibonacciMemoized[0] = memoize(n -> {
            if (n <= 1) return (long) n;
            System.out.println("Calcul de fibonacci(" + n + ")");
            return fibonacciMemoized[0].apply(n - 1) + fibonacciMemoized[0].apply(n - 2);
        });
        // Test avec la version non-memoized (très lent pour n grand)
        System.out.println("Version non-memoized:");
        long start = System.currentTimeMillis();
        System.out.println("fibonacci(10) = " + fibonacci.length);
        System.out.println("Temps: " + (System.currentTimeMillis() - start) + "ms");
        
        // Test avec la version memoized (beaucoup plus rapide)
        System.out.println("\nVersion memoized:");
        start = System.currentTimeMillis();
        System.out.println("fibonacci(10) = " + fibonacciMemoized.length);
        System.out.println("Temps: " + (System.currentTimeMillis() - start) + "ms");
        
        // Deuxième appel (devrait être instantané car en cache)
        System.out.println("\nDeuxième appel memoized:");
        start = System.currentTimeMillis();
        System.out.println("fibonacci(10) = " + fibonacciMemoized.length);
        System.out.println("Temps: " + (System.currentTimeMillis() - start) + "ms");
    }
    
    // Implémentation du memoizer générique
    public static <T, R> Function<T, R> memoize(Function<T, R> function) {
        Map<T, R> cache = new ConcurrentHashMap<>();
        return input -> cache.computeIfAbsent(input, function);
    }
}