import javax.swing.*;

public class Principal {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Pong");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            Jogo jogo = new Jogo();
            frame.add(jogo);

            frame.pack();
            frame.setResizable(false);
            frame.setVisible(true);

            jogo.startGame();
        });
    }
}
