package modele;

public class Jeu {
    private Plateau plateau;
    private Joueur joueur1;
    private Joueur joueur2;
    private Joueur joueurCourant;
    private boolean partieTerminee;

    public Jeu(Joueur joueur1, Joueur joueur2) {
        this.plateau = new Plateau();
        this.joueur1 = joueur1;
        this.joueur2 = joueur2;
        this.joueurCourant = joueur1; // Le joueur 1 commence par défaut
        this.partieTerminee = false;
    }

    // Tente de jouer un coup pour le joueur courant aux coordonnées données
    public boolean jouerTour(int ligne, int colonne) {
        // Si la partie est déjà finie, on ne peut plus jouer
        if (partieTerminee) {
            return false; 
        }

        // On essaie de placer le symbole sur le plateau
        boolean coupValide = plateau.jouerCoup(ligne, colonne, joueurCourant.getSymbole());
        
        if (coupValide) {
            // On vérifie s'il y a victoire après ce coup
            if (plateau.verifierVictoire(joueurCourant.getSymbole())) {
                joueurCourant.incrementerScore(); // Ajoute 1 point au gagnant
                partieTerminee = true;
            } 
            // On vérifie si le plateau est plein (match nul)
            else if (plateau.estPlein()) {
                partieTerminee = true; 
            } 
            // Sinon, la partie continue, c'est à l'autre de jouer
            else {
                changerTour(); 
            }
        }
        return coupValide; // Retourne true si le joueur a cliqué sur une case valide
    }

    // Passe le tour à l'autre joueur
    private void changerTour() {
        if (joueurCourant == joueur1) {
            joueurCourant = joueur2;
        } else {
            joueurCourant = joueur1;
        }
    }

    // Pour rejouer une nouvelle manche sans perdre les scores
    public void reinitialiserPartie() {
        plateau.initialiserGrille();
        partieTerminee = false;
    }

    // Getters utiles pour plus tard (pour la Vue)
    public Plateau getPlateau() { return plateau; }
    public Joueur getJoueurCourant() { return joueurCourant; }
    public boolean isPartieTerminee() { return partieTerminee; }
}