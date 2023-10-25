package sokoban;

public class Levels {

    public static int[][] getLevel(int n) {
        return switch (n) {
            case 1 -> level1;
            case 2 -> level2;
            case 3 -> level3;
            case 4 -> level4;
            case 5 -> level5;
            default -> levelFac();
        };
    }

    private static final int[][] level1 = {
            {0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
            {0, 0, 0, 0, 1, 5, 1, 0, 0, 0},
            {0, 0, 0, 0, 1, 4, 1, 0, 0, 0},
            {1, 1, 1, 1, 1, 4, 1, 0, 0, 0},
            {1, 5, 4, 4, 3, 3, 1, 1, 1, 1},
            {1, 1, 1, 1, 3, 2, 3, 4, 5, 1},
            {0, 0, 0, 1, 4, 1, 1, 1, 1, 1},
            {0, 0, 0, 1, 4, 1, 0, 0, 0, 0},
            {0, 0, 0, 1, 5, 1, 0, 0, 0, 0},
            {0, 0, 0, 1, 1, 1, 0, 0, 0, 0}
    };

    private static final int[][] level2 = {
            {1, 1, 1, 1, 1, 0, 0, 0, 0, 0},
            { 1, 2, 4, 4, 1, 0, 0, 0, 0, 0},
            { 1, 4, 3, 3, 1, 0, 1, 1, 1, 0},
            { 1, 4, 3, 4, 1, 0, 1, 5, 1, 0},
            { 1, 1, 1, 4, 1, 1, 1, 5, 1, 0},
            { 0, 1, 1, 4, 4, 4, 4, 5, 1, 0},
            { 0, 1, 4, 4, 4, 1, 4, 4, 1, 0},
            { 0, 1, 4, 4, 5, 1, 1, 1, 1, 0},
            { 0, 1, 1, 1, 1, 1, 0, 0, 0, 0}
    };

    private static final int[][] level3 = {
            {1, 1, 1, 1, 1, 1, 1, 0, 0, 0},
            { 1, 5, 5, 5, 5, 5, 1, 1, 1, 1},
            { 1, 5, 1, 1, 1, 5, 1, 5, 5, 1},
            { 1, 5, 1, 3, 5, 5, 5, 5, 5, 1},
            { 1, 5, 1, 3, 1, 1, 1, 1, 5, 1},
            { 1, 5, 5, 5, 3, 3, 5, 5, 5, 1},
            { 1, 5, 1, 5, 5, 5, 5, 1, 5, 1},
            { 1, 5, 1, 1, 1, 1, 5, 1, 2, 1},
            { 1, 5, 5, 5, 5, 5, 5, 5, 5, 1},
            { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
    };

    private static final int[][] level4 = {
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 2, 5, 1, 5, 5, 5, 1, 5, 1},
            {1, 5, 5, 1, 5, 1, 5, 1, 5, 1},
            {1, 5, 5, 1, 5, 1, 5, 5, 5, 1},
            {1, 5, 3, 3, 5, 1, 5, 1, 5, 1},
            {1, 5, 5, 5, 5, 5, 5, 1, 5, 1},
            {1, 5, 1, 1, 1, 3, 5, 1, 5, 1},
            {1, 5, 1, 5, 5, 5, 5, 5, 5, 1},
            {1, 5, 5, 5, 1, 1, 1, 1, 5, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
    };

    private static final int[][] level5 = {
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 5, 5, 5, 5, 5, 5, 5, 5, 1},
            {1, 5, 1, 1, 5, 1, 1, 1, 5, 1},
            {1, 5, 1, 3, 5, 5, 5, 1, 5, 1},
            {1, 5, 5, 5, 5, 3, 5, 1, 5, 1},
            {1, 5, 1, 3, 5, 5, 5, 1, 5, 1},
            {1, 5, 1, 1, 1, 1, 1, 1, 5, 1},
            {1, 5, 5, 5, 5, 5, 5, 5, 5, 1},
            {1, 5, 2, 1, 1, 5, 1, 1, 5, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
    };

    private static int[][] levelFac() {
        int[][] randomLevel = new int[0][];



        return randomLevel;
    }
}
