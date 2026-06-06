package vue;

import modele.*;
import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class MainApp extends JFrame {
    private JButton[][] boutons = new JButton[3][3];
    private JLabel labelStatut = new JLabel("", JLabel.CENTER);
    private Jeu jeu;
    private boolean contreOrdi; // Variable pour savoir si on joue contre l'IA

    public MainApp(boolean contreOrdi) {
        this.contreOrdi = contreOrdi;
        
        // Initialisation des joueurs selon le mode
        Joueur j1 = new Joueur("Joueur 1", Symbole.X);
        Joueur j2 = contreOrdi ? new Joueur("Ordinateur", Symbole.O) : new Joueur("Joueur 2", Symbole.O);
        jeu = new Jeu(j1, j2);

        setTitle("Tic-Tac-Toe - " + (contreOrdi ? "PvE" : "PvP"));
        setSize(400, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel grillePanel = new JPanel(new GridLayout(3, 3));
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                JButton btn = new JButton("");
                btn.setFont(new Font("Arial", Font.BOLD, 60));
                boutons[i][j] = btn;
                int r = i, c = j;
                btn.addActionListener(e -> jouerUnCoup(r, c));
                grillePanel.add(btn);
            }
        }

        labelStatut.setFont(new Font("Arial", Font.BOLD, 20));
        labelStatut.setText("Au tour de : " + jeu.getJoueurCourant().getSymbole());
        add(labelStatut, BorderLayout.NORTH);
        add(grillePanel, BorderLayout.CENTER);
    }

    private void jouerUnCoup(int ligne, int colonne) {
        if (jeu.jouerTour(ligne, colonne)) {
            boutons[ligne][colonne].setText(jeu.getPlateau().getGrille()[ligne][colonne].toString());
            boutons[ligne][colonne].setForeground(jeu.getPlateau().getGrille()[ligne][colonne] == Symbole.X ? Color.BLUE : Color.RED);
            
            if (jeu.isPartieTerminee()) {
                verifierFinDePartie();
            } else if (contreOrdi && jeu.getJoueurCourant().getNom().equals("Ordinateur")) {
                Timer timer = new Timer(500, e -> faireJouerIA()); // Petit délai pour faire "réfléchir" l'IA
                timer.setRepeats(false);
                timer.start();
            } else {
                labelStatut.setText("Au tour de : " + jeu.getJoueurCourant().getSymbole());
            }
        }
    }

    private void faireJouerIA() {
        Random rand = new Random();
        int r, c;
        do {
            r = rand.nextInt(3);
            c = rand.nextInt(3);
        } while (jeu.getPlateau().getGrille()[r][c] != Symbole.VIDE);
        jouerUnCoup(r, c);
    }

    private void verifierFinDePartie() {
        if (jeu.getPlateau().verifierVictoire(Symbole.X) || jeu.getPlateau().verifierVictoire(Symbole.O)) {
            String gagnant = jeu.getJoueurCourant().getNom();
            labelStatut.setText("Victoire de " + gagnant + " !");
            ScoreDAO.enregistrerVictoire(gagnant);
            JOptionPane.showMessageDialog(this, "Gagnant : " + gagnant);
        } else {
            labelStatut.setText("Match Nul !");
            JOptionPane.showMessageDialog(this, "Match Nul !");
        }
        this.dispose();
        new FenetreMenu().setVisible(true); // Retour au menu
    }
}