package vue;

import javax.swing.*;
import java.awt.*;

public class FenetreMenu extends JFrame {

    public FenetreMenu() {
        setTitle("Tic-Tac-Toe - Menu");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 1, 10, 10));

        JLabel label = new JLabel("Choisissez votre mode :", JLabel.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 16));

        JButton btnCoop = new JButton("2 Joueurs (Coop)");
        JButton btnOrdi = new JButton("Contre l'Ordinateur");

        // Action pour le mode Coop
        btnCoop.addActionListener(e -> {
            new MainApp(false).setVisible(true); // false = pas d'ordi
            this.dispose(); // Ferme le menu
        });

        // Action pour le mode Ordi
        btnOrdi.addActionListener(e -> {
            new MainApp(true).setVisible(true); // true = avec ordi
            this.dispose(); // Ferme le menu
        });

        add(label);
        add(btnCoop);
        add(btnOrdi);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new FenetreMenu().setVisible(true));
    }
}