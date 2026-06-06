package modele;

public class Plateau {
    private Symbole[][] grille;

    // Constructeur : initialise une grille de 3x3
    public Plateau() {
        grille = new Symbole[3][3];
        initialiserGrille();
    }

    // Remplit la grille avec des symboles VIDE
    public void initialiserGrille() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                grille[i][j] = Symbole.VIDE;
            }
        }
    }

    // Permet de placer un symbole (X ou O) aux coordonnées ligne/colonne
    public boolean jouerCoup(int ligne, int colonne, Symbole symbole) {
        // On vérifie que la case est dans les limites et qu'elle est vide
        if (ligne >= 0 && ligne < 3 && colonne >= 0 && colonne < 3 && grille[ligne][colonne] == Symbole.VIDE) {
            grille[ligne][colonne] = symbole;
            return true; // Le coup a été joué avec succès
        }
        return false; // Coup invalide
    }

    // Vérifie si un symbole a gagné (alignement de 3)
    public boolean verifierVictoire(Symbole s) {
        // Vérification des lignes et des colonnes
        for (int i = 0; i < 3; i++) {
            if ((grille[i][0] == s && grille[i][1] == s && grille[i][2] == s) || 
                (grille[0][i] == s && grille[1][i] == s && grille[2][i] == s)) {
                return true;
            }
        }
        // Vérification des diagonales
        if ((grille[0][0] == s && grille[1][1] == s && grille[2][2] == s) || 
            (grille[0][2] == s && grille[1][1] == s && grille[2][0] == s)) {
            return true;
        }
        
        return false;
    }

    // Vérifie si la grille est pleine (match nul)
    public boolean estPlein() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grille[i][j] == Symbole.VIDE) {
                    return false; // Il reste au moins une case vide
                }
            }
        }
        return true; // Aucune case vide
    }

    // Getter pour récupérer l'état de la grille (utile pour la Vue plus tard)
    public Symbole[][] getGrille() {
        return grille;
    }
}