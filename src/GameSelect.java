import javax.swing.*;

/**
 * @author kyang
 */
public class GameSelect {
    private JPanel gameSelect;
    private JButton level1;
    private JButton level2;
    private JButton level3;
    private JButton level4;
    private JButton level5;
    private JButton menu;

    public GameSelect(Sokoban game) {
        level1.addActionListener(v -> {
            game.initLevel(1);
            game.switchToGameDisplay();
        });
        level2.addActionListener(v -> {
            game.initLevel(2);
            game.switchToGameDisplay();
        });
        level3.addActionListener(v -> {
            game.initLevel(3);
            game.switchToGameDisplay();
        });
        level4.addActionListener(v -> {
            game.initLevel(4);
            game.switchToGameDisplay();
        });
        level5.addActionListener(v -> {
            game.initLevel(5);
            game.switchToGameDisplay();
        });
        menu.addActionListener(v -> game.switchToMainMenuPanel());
    }

    public JPanel getGameSelect() {
        return gameSelect;
    }

}
