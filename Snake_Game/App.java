import javax.swing.*;

public class App {
    public static void main(String[] args) throws Exception {
        int boardWidth = 1500;
        int boardHeight = 800;

        JFrame frame = new JFrame("Snake");
        frame.setVisible(true);
        frame.setSize(boardWidth, boardHeight);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        SnakeGame snakeGame = new SnakeGame(boardWidth, boardHeight);
        frame.add(snakeGame);
        frame.pack();
        snakeGame.requestFocus();

        // Wait for the game to finish
        while (!snakeGame.isGameOver()) {
            try {
                Thread.sleep(100); // Adjust the delay as needed
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Display a dialog box when the game is over
        int option = JOptionPane.showOptionDialog(frame,
                "Game Over! Your score: " + snakeGame.getScore(),
                "Game Over",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                new Object[] { "Start Over", "Quit" },
                "Start Over");

        if (option == JOptionPane.YES_OPTION) {
            // Start over
            frame.dispose();
            main(args);
        } else {
            // Quit the game
            System.exit(0);
        }
    }
}
