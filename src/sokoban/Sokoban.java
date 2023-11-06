package sokoban;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Sokoban extends JFrame implements KeyListener {

    private static final int WALL = 1;
    private static final int PLAYER = 2;
    private static final int BOX = 3;
    private static final int ROAD = 4;
    private static final int DEST = 5;
    private static final int BOX_DEST = 6;
    public int levels = 1;
    public int steps = 0;
    private int leftX = 50;
    private int leftY = 50;
    private int playerX, playerY;
    private int cache = ROAD;
    private int[][] currentLevel;

    public Sokoban() {
        setTitle("sokoban");
        setDefaultLookAndFeelDecorated(true);
        setSize(800, 600);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Sokoban game = new Sokoban();

            MainMenuPanel menuPanel = new MainMenuPanel(game);
            game.add(menuPanel);

            game.setVisible(true);
        });
    }

    public static void exitGame(JFrame frame) {
        if (frame != null) {
            frame.dispose();
            System.exit(0);
        }
    }

    public void switchToGameLevelPanel() {
        getContentPane().removeAll();  // 移除所有组件
        GameLevelPanel gameLevelPanel = new GameLevelPanel(this);
        add(gameLevelPanel);
        validate();
        repaint();
    }

    public void initLevel(int levels) {
        currentLevel = Levels.getLevel(levels);
    }

    public void getPlayerPosition() {
        for (int i = 0; i < currentLevel.length; i++) {
            for (int j = 0; j < currentLevel[i].length; j++) {
                if (currentLevel[i][j] == PLAYER) {
                    playerY = i;
                    playerX = j;
                    break;
                }
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP, KeyEvent.VK_W -> moveUp();
            case KeyEvent.VK_DOWN, KeyEvent.VK_S -> moveDown();
            case KeyEvent.VK_RIGHT, KeyEvent.VK_D -> moveRight();
            case KeyEvent.VK_LEFT, KeyEvent.VK_A -> moveLeft();
        }
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    private void moveUp() {
        cache = currentLevel[playerY - 1][playerX];
        switch (currentLevel[playerY - 1][playerX]) {
            case WALL, BOX_DEST -> GameLevelPanel.hitWall();
            case BOX -> {
                cache = currentLevel[playerY - 2][playerX];
                switch (currentLevel[playerY - 2][playerX]) {
                    case ROAD -> {
                        currentLevel[playerY - 2][playerX] = BOX;
                        currentLevel[playerY - 1][playerX] = PLAYER;
                        currentLevel[playerY][playerX] = cache;
                    }
                    case DEST -> {
                        currentLevel[playerY - 2][playerX] = BOX_DEST;
                        currentLevel[playerY - 1][playerX] = PLAYER;
                        currentLevel[playerY][playerX] = cache;
                    }
                    default -> GameLevelPanel.hitWall();
                }
            }
            default -> {
                currentLevel[playerY - 1][playerX] = PLAYER;
                currentLevel[playerY][playerX] = cache;
            }
        }
        getPlayerPosition();
    }

    private void moveDown() {
        cache = currentLevel[playerY + 1][playerX];
        switch (currentLevel[playerY + 1][playerX]) {
            case WALL, BOX_DEST -> GameLevelPanel.hitWall();
            case BOX -> {
                cache = currentLevel[playerY + 2][playerX];
                switch (currentLevel[playerY + 2][playerX]) {
                    case ROAD -> {
                        currentLevel[playerY + 2][playerX] = BOX;
                        currentLevel[playerY + 1][playerX] = PLAYER;
                        currentLevel[playerY][playerX] = cache;
                    }
                    case DEST -> {
                        currentLevel[playerY + 2][playerX] = BOX_DEST;
                        currentLevel[playerY + 1][playerX] = PLAYER;
                        currentLevel[playerY][playerX] = cache;
                    }
                    default -> GameLevelPanel.hitWall();
                }
            }
            default -> {
                currentLevel[playerY + 1][playerX] = PLAYER;
                currentLevel[playerY][playerX] = cache;
            }
        }
        getPlayerPosition();
    }

    private void moveRight() {
        cache = currentLevel[playerY][playerX + 1];
        switch (currentLevel[playerY][playerX + 1]) {
            case WALL, BOX_DEST -> GameLevelPanel.hitWall();
            case BOX -> {
                cache = currentLevel[playerY][playerX + 2];
                switch (currentLevel[playerY][playerX + 2]) {
                    case ROAD -> {
                        currentLevel[playerY][playerX + 2] = BOX;
                        currentLevel[playerY][playerX + 1] = PLAYER;
                        currentLevel[playerY][playerX] = cache;
                    }
                    case DEST -> {
                        currentLevel[playerY][playerX + 2] = BOX_DEST;
                        currentLevel[playerY][playerX + 1] = PLAYER;
                        currentLevel[playerY][playerX] = cache;
                    }
                    default -> GameLevelPanel.hitWall();
                }
            }
            default -> {
                currentLevel[playerY][playerX + 1] = PLAYER;
                currentLevel[playerY][playerX] = cache;
            }
        }
        getPlayerPosition();
    }

    private void moveLeft() {
        cache = currentLevel[playerY][playerX - 1];
        switch (currentLevel[playerY][playerX - 1]) {
            case WALL, BOX_DEST -> GameLevelPanel.hitWall();
            case BOX -> {
                cache = currentLevel[playerY][playerX - 2];
                switch (currentLevel[playerY][playerX - 2]) {
                    case ROAD -> {
                        currentLevel[playerY][playerX - 2] = BOX;
                        currentLevel[playerY][playerX - 1] = PLAYER;
                        currentLevel[playerY][playerX] = cache;
                    }
                    case DEST -> {
                        currentLevel[playerY][playerX - 2] = BOX_DEST;
                        currentLevel[playerY][playerX - 1] = PLAYER;
                        currentLevel[playerY][playerX] = cache;
                    }
                    default -> GameLevelPanel.hitWall();
                }
            }
            default -> {
                currentLevel[playerY][playerX - 1] = PLAYER;
                currentLevel[playerY][playerX] = cache;
            }
        }
        getPlayerPosition();
    }
}
