import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GameDisplay extends JPanel {
    private final int WALL = Sokoban.WALL;
    private final int PLAYER = Sokoban.PLAYER;
    private final int BOX = Sokoban.BOX;
    private final int ROAD = Sokoban.ROAD;
    private final int DEST = Sokoban.DEST;
    private final int BOX_DEST = Sokoban.BOX_DEST;
    private BufferedImage wallImage;
    private BufferedImage playerImage;
    private BufferedImage boxImage;
    private BufferedImage roadImage;
    private BufferedImage destImage;
    private BufferedImage boxDestImage;
    private BufferedImage unknown;
    private int[][] levelData;

    public GameDisplay() {
        setFocusable(true);
    }

    public void setLevelData(int[][] levelData) {
        this.levelData = levelData;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (levelData != null) {
            drawGame(g, levelData);
        }
    }

    private void drawGame(Graphics g, int[][] levelData) {
        if (levelData != null) {
            for (int i = 0; i < levelData.length; i++) {
                for (int j = 0; j < levelData[i].length; j++) {
                    switch (levelData[i][j]) {
                        case WALL:
                            g.drawImage(wallImage, i, j, this);
                            break;
                        case PLAYER:
                            g.drawImage(playerImage, i, j, this);
                            break;
                        default:
                            g.drawImage(unknown, i, j, this );
                    }
                }
            }
        }
    }

    private void loadImage() {
        try {
            wallImage = ImageIO.read(new File("res/wall.png"));
            playerImage = ImageIO.read(new File("res/player.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

