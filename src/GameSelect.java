import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameSelect {
    private Sokoban game;
    private JPanel gameSelect;
    private JButton level1;
    private JButton level2;
    private JButton level3;
    private JButton level4;
    private JButton level5;

    public GameSelect(Sokoban game) {
        this.game = game;
        level1.addActionListener(v -> game.initLevel(1));
        level2.addActionListener(v -> game.initLevel(2));
        level3.addActionListener(v -> game.initLevel(3));
        level4.addActionListener(v -> game.initLevel(4));
        level5.addActionListener(v -> game.initLevel(5));
    }

    public JPanel getGameSelect() {
        return gameSelect;
    }
}
