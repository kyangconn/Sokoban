import javax.swing.*;
import java.awt.*;

/**
 * @author kyang
 */
public class GameComplete {
    private JButton nextLevelButton;
    private JPanel completeMenu;
    private JButton returnToMenuButton;
    private JButton quitGameButton;

    public GameComplete(Sokoban game) {
        completeMenu.setBackground(new Color(225, 225, 225, 64));

        nextLevelButton.addActionListener(v -> game.nextLevel());
        returnToMenuButton.addActionListener(v -> game.switchToMainMenuPanel());
        quitGameButton.addActionListener(v -> game.exitGame());
    }

    public JPanel getCompleteMenu() {
        return completeMenu;
    }

}
