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
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        };
        level1.addActionListener(listener);
        level2.addActionListener(listener);
        level3.addActionListener(listener);
        level4.addActionListener(listener);
        level5.addActionListener(listener);
    }

    public JPanel getGameSelect() {
        return gameSelect;
    }
}
