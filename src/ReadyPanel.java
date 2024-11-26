import javax.swing.*;
import java.awt.*;

public class ReadyPanel extends JPanel {

    private String player1Name;
    private String player2Name;

    public ReadyPanel(JPanel mainPanel, CardLayout cardLayout) {
        setLayout(new GridLayout(3, 2, 10, 10));

        //player 1 ready up
        JLabel name1Label = new JLabel("Player 1, enter your name:");
        name1Label.setFont(new Font("Arial", Font.PLAIN, 16));
        JTextField name1TextField = new JTextField(20);
        name1TextField.setFont(new Font("Arial", Font.PLAIN, 16));

        //player 2 ready up
        JLabel name2Label = new JLabel("Player 2, enter your name:");
        name2Label.setFont(new Font("Arial", Font.PLAIN, 16));
        JTextField name2TextField = new JTextField(20);
        name2TextField.setFont(new Font("Arial", Font.PLAIN, 16));

        //ready button
        JButton readyButton = new JButton("Ready");
        readyButton.setFont(new Font("Arial", Font.BOLD, 18));
        readyButton.setBackground(Color.GREEN);
        readyButton.setForeground(Color.WHITE);

        //both players need to enter names to be ready
        readyButton.addActionListener(e -> {
            player1Name = name1TextField.getText().trim();
            player2Name = name2TextField.getText().trim();

            if (player1Name.isEmpty() || player2Name.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Both names need to be entered");
            } else {
                BattleshipGrid.createPlayerFrame(player1Name + "'s Game", player1Name);
                BattleshipGrid.createPlayerFrame(player2Name + "'s Game", player2Name);

                SwingUtilities.getWindowAncestor(this).dispose();
            }
        });

        add(name1Label);
        add(name1TextField);
        add(name2Label);
        add(name2TextField);
        add(new JLabel()); //empty JLabel so that ready is on right side
        add(readyButton);
    }
}
