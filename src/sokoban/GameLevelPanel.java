package sokoban;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GameLevelPanel extends JPanel {
    private static Sokoban game;
    private final JLabel stepsLabel;
    private JPanel gameDisplayPanel;
    private JPanel pausePanel;

    public GameLevelPanel(Sokoban game) {
        GameLevelPanel.game = game;
        setLayout(new BorderLayout());

        stepsLabel = new JLabel("LEVELS：" + game.levels + ",STEPS：" + game.steps);
        add(stepsLabel, BorderLayout.SOUTH);

        gameDisplayPanel = new JPanel();
        add(gameDisplayPanel, BorderLayout.CENTER);

        setPausePanel();
        add(pausePanel, BorderLayout.CENTER);


        // Add key listener to show the pause panel
        gameDisplayPanel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_E) {
                    togglePauseMenu();
                    System.out.println("ESC");
                }
            }
        });
    }

    public static void hitWall() {
        JOptionPane hitWall = new JOptionPane("推不动啦，换个方向看看？");
        JDialog dialog = hitWall.createDialog(game, "提示");
        Timer timer = new Timer(2000, e -> dialog.dispose());

        timer.setRepeats(false);
        timer.start();
        dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        dialog.setModalityType(Dialog.ModalityType.MODELESS);
        dialog.setVisible(true);
    }

    public void togglePauseMenu() {
        pausePanel.setVisible(!pausePanel.isVisible());
        repaint();
    }

    private void setPausePanel() {
        pausePanel = new JPanel();
        pausePanel.setBackground(new Color(0, 0, 0, 150));
        pausePanel.setLayout(new BoxLayout(pausePanel, BoxLayout.Y_AXIS));

        JButton continueButton = new JButton("Continue Game");
        JButton settingButton = new JButton("Setting");
        JButton backToMenuButton = new JButton("Back to Menu");
        JButton exitGameButton = new JButton("Exit Game");

        pausePanel.add(Box.createRigidArea(new Dimension(0, 40)));
        pausePanel.add(continueButton);
        pausePanel.add(Box.createRigidArea(new Dimension(0, 40)));
        pausePanel.add(settingButton);
        pausePanel.add(Box.createRigidArea(new Dimension(0, 40)));
        pausePanel.add(backToMenuButton);
        pausePanel.add(Box.createRigidArea(new Dimension(0, 40)));
        pausePanel.add(exitGameButton);
        pausePanel.add(Box.createRigidArea(new Dimension(0, 40)));

        // Initially, the pause panel is not visible
        pausePanel.setVisible(false);

    }
}
