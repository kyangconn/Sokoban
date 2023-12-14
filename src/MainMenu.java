import javax.swing.*;

/**
 * @author kyang
 */
public class MainMenu {
    private JPanel mainMenu;
    private JButton startButton;
    private JButton selectButton;
    private JButton quitButton;

    public MainMenu(Sokoban game) {
        startButton.addActionListener(v -> game.switchToGameDisplay());
        selectButton.addActionListener(v -> game.switchToGameSelectPanel());
        quitButton.addActionListener(v -> game.exitGame());
    }

    public JPanel getMainMenu() {
        return mainMenu;
    }

}