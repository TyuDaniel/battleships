public class Main {
    public static void main(String[] args) {
        // Launch the Battleship menu on the Event Dispatch Thread
        javax.swing.SwingUtilities.invokeLater(BattleshipMENU::new);
    }
}
