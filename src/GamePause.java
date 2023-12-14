import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * @author kyang
 */
public class GamePause {
    private JButton returnToGameButton;
    private JPanel pauseMenu;
    private JButton returnToMenuButton;
    private JButton quitGameButton;

    public GamePause(Sokoban game) {
        pauseMenu.setBackground(new Color(225, 225, 225, 64));

        returnToGameButton.addActionListener(v -> game.switchToGameDisplay());
        returnToMenuButton.addActionListener(v -> game.switchToMainMenuPanel());
        quitGameButton.addActionListener(v -> game.exitGame());
        pauseMenu.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                game.switchToGameDisplay();
            }
        });
    }

    public JPanel getPauseMenu() {
        return pauseMenu;
    }

}
