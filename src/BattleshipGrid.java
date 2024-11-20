import javax.swing.*;
import java.awt.*;

public class BattleshipGrid {

    public static JFrame createPlayerFrame(String title, String playerName) {
        JFrame playerFrame = new JFrame(title);
        playerFrame.setSize(500, 500);
        playerFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        playerFrame.setLocationRelativeTo(null);

        // grid array to store its state
        int[][] gridArray = new int[10][10];

        // Pass the grid array to the createPlayerGrid method
        JPanel gridPanel = createPlayerGrid(playerName + "'s Grid", gridArray);
        playerFrame.add(gridPanel);

        playerFrame.setVisible(true);
        return playerFrame;
    }

    // grids for players to place ships on
    private static JPanel createPlayerGrid(String title, int[][] gridArray) {
        JPanel gridPanel = new JPanel(new GridLayout(10, 10));
        gridPanel.setBorder(BorderFactory.createTitledBorder(title));

        for (int row = 0; row < 10; row++) {
            for (int col = 0; col < 10; col++) {
                JButton cellButton = new JButton();
                cellButton.setPreferredSize(new Dimension(40, 40));

                // attach row and col information to the button
                final int currentRow = row;
                final int currentCol = col;

                // Button click to place ships
                cellButton.addActionListener(e -> {
                    if (gridArray[currentRow][currentCol] == 0) { // 0 is water
                        gridArray[currentRow][currentCol] = 1;   // 1 is ship
                        cellButton.setBackground(Color.BLUE); //updates to blue when ship placed
                    } else {
                        JOptionPane.showMessageDialog(gridPanel, "Ship already placed here!");
                    }
                });

                gridPanel.add(cellButton);
            }
        }
        return gridPanel;
    }
}
