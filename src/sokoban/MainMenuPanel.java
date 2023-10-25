package sokoban;

import javax.swing.*;
import java.awt.*;

public class MainMenuPanel extends JPanel {
    private final Sokoban game;
    private JButton startButton;
    private JButton selectLevelButton;
    private JButton settingsButton;
    private JButton exitButton;

    public MainMenuPanel(Sokoban game) {
        this.game = game;

        initializeButtons();
        setupLayout();

        startButton.addActionListener(v -> startGame());
        exitButton.addActionListener(v -> exitGame());
    }

    private void initializeButtons() {
        startButton = new JButton("开始游戏");
        selectLevelButton = new JButton("选择关卡");
        settingsButton = new JButton("设置");
        exitButton = new JButton("退出游戏");
    }

    private void setupLayout() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        startButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        selectLevelButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        settingsButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        exitButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        add(Box.createRigidArea(new Dimension(0, 100)));
        add(startButton);
        add(Box.createRigidArea(new Dimension(0, 40)));
        add(selectLevelButton);
        add(Box.createRigidArea(new Dimension(0, 40)));
        add(settingsButton);
        add(Box.createRigidArea(new Dimension(0, 40)));
        add(exitButton);
    }

    private void startGame() {
        game.switchToGameLevelPanel();

    }

    private void exitGame() {
        Sokoban.exitGame(game);
    }

}
