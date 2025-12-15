package com.example;

public class Personne {
    private String nom;
    private int age;
    private String ville;
    private String prenom;
    public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public Personne(String nom, int age, String ville) {
        this.nom = nom;
        this.age = age;
        this.ville = ville;
    }
    public Personne(String prenom, String nom, int age) {
        this.prenom = prenom;
        this.nom = nom;
        this.age = age;
    }

    public String getNom() {
        return nom;
    }

    public int getAge() {
        return age;
    }

    public String getVille() {
        return ville;
    }

    @Override
    public String toString() {
        return nom + " (" + age + ", " + ville + ")";
    }
}
