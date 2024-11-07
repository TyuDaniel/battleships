import javax.swing.*;
import java.awt.*;

public class BattleshipMENU extends JFrame {

    private CardLayout cardLayout;      // CardLayout to switch between screens
    private JPanel mainPanel;           // Main panel to hold all screens
    private String player1Name;         // Field to store Player 1's name
    private String player2Name;         // Field to store Player 2's name

    public BattleshipMENU() {
        setTitle("Battleship Game - Menu");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);  // Center the window on screen

        // Initialize CardLayout and main panel
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);  // Use CardLayout for mainPanel

        // Create and add menu panel
        JPanel menuPanel = createMenuPanel();
        mainPanel.add(menuPanel, "Menu");

        // Create and add name entry panel
        JPanel nameEntryPanel = createNameEntryPanel();
        mainPanel.add(nameEntryPanel, "NameEntry");

        // Set mainPanel as the content pane, allowing us to switch between screens
        setContentPane(mainPanel);
        setVisible(true);
    }

    // Method to create the initial menu panel with a "Click to start" button
    private JPanel createMenuPanel() {
        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 250));

        // Create and configure the "Click to start" button
        JButton startButton = new JButton("Click to start");
        startButton.setFont(new Font("Arial", Font.BOLD, 18));
        startButton.setBackground(Color.BLUE);
        startButton.setForeground(Color.WHITE);
        startButton.setFocusPainted(false);
        startButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        startButton.setPreferredSize(new Dimension(150, 50));

        // Set action listener to switch to the name entry panel when clicked
        startButton.addActionListener(e -> cardLayout.show(mainPanel, "NameEntry"));

        menuPanel.add(startButton);  // Add button to menu panel
        return menuPanel;
    }

    // Method to create the name entry panel
    private JPanel createNameEntryPanel() {
        JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));  // 3 rows, 2 columns

        // Label and text field for Player 1 name
        JLabel name1Label = new JLabel("Player 1, enter your name:");
        name1Label.setFont(new Font("Arial", Font.PLAIN, 16));
        JTextField name1TextField = new JTextField(20);
        name1TextField.setFont(new Font("Arial", Font.PLAIN, 16));

        // Label and text field for Player 2 name
        JLabel name2Label = new JLabel("Player 2, enter your name:");
        name2Label.setFont(new Font("Arial", Font.PLAIN, 16));
        JTextField name2TextField = new JTextField(20);
        name2TextField.setFont(new Font("Arial", Font.PLAIN, 16));

        // "Ready" button to confirm the names
        JButton readyButton = new JButton("Ready");
        readyButton.setFont(new Font("Arial", Font.BOLD, 18));
        readyButton.setBackground(Color.GREEN);
        readyButton.setForeground(Color.WHITE);

        // Action listener for the "Ready" button
        readyButton.addActionListener(e -> {
            player1Name = name1TextField.getText().trim();
            player2Name = name2TextField.getText().trim();

            if (player1Name.isEmpty() || player2Name.isEmpty()) {
                JOptionPane.showMessageDialog(panel, "Please enter names for both players.");
            } else {
                // Close the menu window
                dispose();

                // Create separate frames for each player
                createPlayerFrame(player1Name + "'s Game", player1Name);
                createPlayerFrame(player2Name + "'s Game", player2Name);
            }
        });

        // Add components to the panel in order
        panel.add(name1Label);
        panel.add(name1TextField);
        panel.add(name2Label);
        panel.add(name2TextField);
        panel.add(new JLabel());    // Empty placeholder for spacing
        panel.add(readyButton);

        return panel;
    }

    // Method to create a separate frame for each player
    private void createPlayerFrame(String title, String playerName) {
        JFrame playerFrame = new JFrame(title);
        playerFrame.setSize(500, 500);
        playerFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        playerFrame.setLocationRelativeTo(null);

        // Create a panel with the player's grid
        JPanel playerGridPanel = createPlayerGrid(playerName + "'s Grid");
        playerFrame.add(playerGridPanel);

        playerFrame.setVisible(true);
    }

    // Helper method to create a 10x10 grid for a player
    private JPanel createPlayerGrid(String title) {
        JPanel gridPanel = new JPanel(new GridLayout(10, 10));
        gridPanel.setBorder(BorderFactory.createTitledBorder(title));

        for (int row = 0; row < 10; row++) {
            for (int col = 0; col < 10; col++) {
                JButton cellButton = new JButton();
                cellButton.setPreferredSize(new Dimension(40, 40));

                // Optional: Add listeners for ship placement or guessing
                cellButton.addActionListener(e -> {
                    // Handle cell interaction here (ship placement or guessing)
                    cellButton.setBackground(Color.BLUE);  // Example color for ship placement
                });

                gridPanel.add(cellButton);  // Add button to the grid
            }
        }

        return gridPanel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(BattleshipMENU::new);
    }
}
