package modele;

public class Joueur {
    private String nom;
    private Symbole symbole;
    private int score;

    public Joueur(String nom, Symbole symbole) {
        this.nom = nom;
        this.symbole = symbole;
        this.score = 0; // Le score commence à 0
    }

    public String getNom() { 
        return nom; 
    }
    
    public Symbole getSymbole() { 
        return symbole; 
    }
    
    public int getScore() { 
        return score; 
    }

    public void incrementerScore() {
        this.score++;
    }
}