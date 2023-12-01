import javax.swing.*;

public class MainMenu {
    private final Sokoban game;
    private JPanel mainMenu;
    private JButton startButton;
    private JButton selectButton;
    private JButton quitButton;

    public MainMenu(Sokoban game) {
        this.game = game;
        startButton.addActionListener(v -> game.switchToGameLevelPanel());
        selectButton.addActionListener(v -> game.switchToGameSelectPanel());
        quitButton.addActionListener(v -> game.exitGame());
    }

    public JPanel getMainMenu() {
        return mainMenu;
    }
}