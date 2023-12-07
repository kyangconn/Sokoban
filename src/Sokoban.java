import javax.swing.*;

/**
 * @author kyang
 */
public class Sokoban {

    public static final int WALL = 1;
    public static final int PLAYER = 2;
    public static final int BOX = 3;
    public static final int ROAD = 4;
    public static final int DEST = 5;
    public static final int BOX_DEST = 6;
    public int levels = 1;
    public int steps = 0;
    private int playerX, playerY;
    private int[][] currentLevel, cacheLevel;

    private final JFrame frame;

    public Sokoban() {
        frame = new JFrame("Sokoban");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);

        MainMenu mainMenu = new MainMenu(this);
        frame.add(mainMenu.getMainMenu());
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Sokoban::new);
    }

    public void exitGame() {
        if (frame != null) {
            frame.dispose();
            System.exit(0);
        }
    }

    public void switchToMainMenuPanel() {
        frame.getContentPane().removeAll();
        MainMenu mainMenu = new MainMenu(this);
        frame.add(mainMenu.getMainMenu());
        frame.validate();
        frame.repaint();
    }

    public void switchToGameSelectPanel() {
        frame.getContentPane().removeAll();
        GameSelect gameSelect = new GameSelect(this);
        frame.add(gameSelect.getGameSelect());
        frame.validate();
        frame.repaint();
    }

    public void switchToGameLevelPanel() {
        frame.getContentPane().removeAll();  // 移除所有组件
        GameLevel gameLevel = new GameLevel(this);
        frame.add(gameLevel.getGameLevel());
        frame.validate();
        frame.repaint();
    }

    public void initLevel(int levels) {
        currentLevel = Levels.getLevel(levels);
        cacheLevel = Levels.getLevel(levels);
        getPlayerPosition();
        switchToGameLevelPanel();
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

    public void moveUp() {
        tryMove(-1, 0);
    }

    public void moveDown() {
        tryMove(1, 0);
    }

    public void moveRight() {
        tryMove(0, 1);
    }

    public void moveLeft() {
        tryMove(0, -1);
    }

    private void tryMove(int dy, int dx) {
        int nextY = playerY + dy;
        int nextX = playerX + dx;

        switch (currentLevel[nextY][nextX]) {
            case ROAD, DEST -> movePlayer(nextY, nextX);
            case BOX, BOX_DEST -> {
                int nextBoxX = nextX + dx;
                int nextBoxY = nextY + dy;
                tryMoveBox(nextBoxY, nextBoxX, nextY, nextX);
            }
            default -> {
                // No Other situations.
            }
        }
    }

    private void tryMoveBox(int boxY, int boxX, int playerY, int playerX) {
        switch (currentLevel[boxY][boxX]) {
            case ROAD -> {
                currentLevel[boxY][boxX] = BOX;
                currentLevel[playerY][playerX] = cacheLevel[playerY][playerX];
                movePlayer(playerY, playerX);
            }
            case DEST -> {
                currentLevel[boxY][boxX] = BOX_DEST;
                movePlayer(playerY, playerX);
            }
            default -> {
                // WALL and BOX_DEST will NOT in situation.
            }
        }
    }

    private void movePlayer(int y, int x) {
        if (cacheLevel[playerY][playerX] == PLAYER) {
            currentLevel[playerY][playerX] = ROAD;
        }
        currentLevel[playerY][playerX] = cacheLevel[playerY][playerX];
        playerY = y;
        playerX = x;
        currentLevel[playerY][playerX] = PLAYER;
    }
}
