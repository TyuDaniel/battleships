import javax.swing.*;
import java.awt.*;

public class BattleshipMENU extends JFrame {

    private CardLayout cardLayout;
    private JPanel mainPanel;

    public BattleshipMENU() {
        setTitle("Battleship Game - Menu");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        mainPanel.add(new MenuPanel(mainPanel, cardLayout), "Menu");
        mainPanel.add(new ReadyPanel(mainPanel, cardLayout), "NameEntry");

        setContentPane(mainPanel);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(BattleshipMENU::new);
    }
}
