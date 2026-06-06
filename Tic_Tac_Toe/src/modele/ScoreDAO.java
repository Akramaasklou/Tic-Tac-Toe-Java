package modele;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ScoreDAO {
    // Coordonnées de votre base de données MySQL
    private static final String URL = "jdbc:mysql://localhost:3306/tictactoe_db";
    private static final String UTILISATEUR = "root"; // Par défaut sous XAMPP/WAMP
    private static final String MOT_DE_PASSE = "Akram@2005";; 
    // Méthode pour ajouter une victoire dans la base de données
    public static void enregistrerVictoire(String nomJoueur) {
        // Si le nom existe déjà, on ajoute 1 au score existant (ON DUPLICATE KEY UPDATE)
        String sql = "INSERT INTO scores (nom_joueur, score) VALUES (?, 1) " +
                     "ON DUPLICATE KEY UPDATE score = score + 1";
        
        try (Connection conn = DriverManager.getConnection(URL, UTILISATEUR, MOT_DE_PASSE);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, nomJoueur);
            pstmt.executeUpdate();
            System.out.println("✅ Score mis à jour pour : " + nomJoueur);
            
        } catch (SQLException e) {
            System.err.println("❌ Erreur SQL : " + e.getMessage());
        }
    }
}