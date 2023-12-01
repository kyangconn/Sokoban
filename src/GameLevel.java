import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GameLevel {
    private Sokoban game;
    private JPanel gameLevel;
    private JPanel gameDisplay;
    private JPanel pauseMenu;
    private JButton returnGame;
    private JButton returnMenu;
    private JButton quitGame;
    private JLabel stepsLabel;

    public GameLevel(Sokoban game) {
        this.game = game;

        pauseMenu.setBackground(new Color(0, 0, 0, 150));

        gameDisplay.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_ESCAPE -> {
                        pauseMenu.setVisible(!pauseMenu.isVisible());
                        gameLevel.repaint();
                    }
                    case KeyEvent.VK_UP, KeyEvent.VK_W -> game.moveUp();
                    case KeyEvent.VK_DOWN, KeyEvent.VK_S -> game.moveDown();
                    case KeyEvent.VK_RIGHT, KeyEvent.VK_D -> game.moveRight();
                    case KeyEvent.VK_LEFT, KeyEvent.VK_A -> game.moveLeft();
                    default -> {
                        // No Other Keys need to be response.
                    }
                }
                stepsLabel.setText("LEVELS：" + game.levels + ",STEPS：" + game.steps);
            }
        });
        pauseMenu.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                gameDisplay.setVisible(!gameDisplay.isVisible());
                gameLevel.repaint();
            }
        });
        quitGame.addActionListener(v -> game.exitGame());
    }

    public JPanel getGameLevel() {
        return gameLevel;
    }
}
