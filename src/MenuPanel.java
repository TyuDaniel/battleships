
import javax.swing.*;
import java.awt.*;

public class MenuPanel extends JPanel {

    public MenuPanel(JPanel mainPanel, CardLayout cardLayout) {
        setLayout(new FlowLayout(FlowLayout.CENTER, 0, 250));

        JButton startButton = new JButton("Click to start");
        startButton.setFont(new Font("Arial", Font.BOLD, 18));
        startButton.setBackground(Color.BLUE);
        startButton.setForeground(Color.WHITE);
        startButton.setFocusPainted(false);
        startButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        startButton.setPreferredSize(new Dimension(150, 50));

        startButton.addActionListener(e -> cardLayout.show(mainPanel, "NameEntry"));

        add(startButton);
    }
}
