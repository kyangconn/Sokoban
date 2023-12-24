import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @author kyang
 */
public class GameDisplay extends JPanel {
    private final JLabel stepsLabel;
    private int[][] levelData;
    private BufferedImage wallImage, playerImage, boxImage, roadImage, destImage, boxOnDestImage, unknown;

    public GameDisplay(Sokoban game, int[][] levelData) {
        this.levelData = levelData;
        stepsLabel = new JLabel("LEVELS：" + game.levels + ",STEPS：" + game.steps);
        add(stepsLabel);
        stepsLabel.setFocusable(false);
        setFocusable(true);
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_ESCAPE -> game.switchToPauseMenu();
                    case KeyEvent.VK_UP, KeyEvent.VK_W -> game.moveUp();
                    case KeyEvent.VK_DOWN, KeyEvent.VK_S -> game.moveDown();
                    case KeyEvent.VK_RIGHT, KeyEvent.VK_D -> game.moveRight();
                    case KeyEvent.VK_LEFT, KeyEvent.VK_A -> game.moveLeft();
                    default -> {
                        // No Other Keys need to be response.
                    }
                }
            }
        });
        loadImages();
    }

    public void setStepsLabel(int level, int steps) {
        stepsLabel.setText("LEVELS：" + level + ",STEPS：" + steps);
    }

    private void loadImages() {
        try {
            wallImage = ImageIO.read(getClass().getResource("/wall.png"));
            playerImage = ImageIO.read(getClass().getResource("/player.png"));
            boxImage = ImageIO.read(getClass().getResource("/box.png"));
            roadImage = ImageIO.read(getClass().getResource("/road.png"));
            destImage = ImageIO.read(getClass().getResource("/dest.png"));
            boxOnDestImage = ImageIO.read(getClass().getResource("/box_dest.png"));
            unknown = ImageIO.read(getClass().getResource("/unknown.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void setLevelData(int[][] levelData) {
        this.levelData = levelData;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < levelData.length; i++) {
            for (int j = 0; j < levelData[i].length; j++) {
                int cellSize = 64;
                switch (levelData[i][j]) {
                    case Sokoban.WALL:
                        g.drawImage(wallImage, j * cellSize, i * cellSize, this);
                        break;
                    case Sokoban.PLAYER:
                        g.drawImage(playerImage, j * cellSize, i * cellSize, this);
                        break;
                    case Sokoban.BOX:
                        g.drawImage(boxImage, j * cellSize, i * cellSize, this);
                        break;
                    case Sokoban.ROAD:
                        g.drawImage(roadImage, j * cellSize, i * cellSize, this);
                        break;
                    case Sokoban.DEST:
                        g.drawImage(destImage, j * cellSize, i * cellSize, this);
                        break;
                    case Sokoban.BOX_DEST:
                        g.drawImage(boxOnDestImage, j * cellSize, i * cellSize, this);
                        break;
                    default:
                        g.drawImage(unknown, j * cellSize, i * cellSize, this);
                        break;
                }
            }
        }
    }
}
