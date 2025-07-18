import java.util.Random;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.awt.image.*;

@SuppressWarnings("unused")
public class Maze extends JFrame implements Runnable {
    static Random random = new Random();
    static int gridSize = 21;
    TopDown topDown;
    private static int maze[][] = new int[gridSize][gridSize];
    private Thread thread;
    private boolean isRunning;
    private BufferedImage image;
    final int width = 1000;
    final int height = 680;
    String lastMove = null;
    int blockFacing = 4;
    int x = 1;
    int y = 1;
    String lastMove2 = null;
    int blockFacing2 = 4;
    int x2 = 1;
    int y2 = 1;
    public int[] pixels;
    public ArrayList<Texture> textures;
    public Camera camera;
    public Camera plr2;
    public Screen screen;

    public Maze() {
        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();
        thread = new Thread(this);
        textures = new ArrayList<Texture>();
        textures.add(Texture.brick);
        textures.add(Texture.wood);
        textures.add(Texture.blueStone);
        textures.add(Texture.rat);
        textures.add(Texture.flag);
        screen = new Screen(maze, textures, width, height, gridSize);
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                /*
                 * if (i == 0 || j == 0 || i == gridSize - 1 || j == gridSize - 1) {
                 * maze[i][j] = 1;
                 * } else {
                 * maze[i][j] = 0;
                 * }
                 */
                maze[i][j] = 1;
            }

        }
        maze[gridSize - 2][gridSize - 1] = 5;
        generateMaze(1, 1);
        for (int y = gridSize / 2; y < gridSize; y++) {
            for (int x = 0; x < gridSize / 2; x++) {
                if (maze[x][y] == 1) {
                    maze[x][y] = 2;
                }
            }
        }

        for (int y = 0; y < gridSize / 2; y++) {
            for (int x = gridSize / 2; x < gridSize; x++) {
                if (maze[x][y] == 1) {
                    maze[x][y] = 3;
                }
            }
        }

        for (int y = 0; y < gridSize / 2; y++) {
            for (int x = 0; x < gridSize / 2; x++) {
                if (maze[x][y] == 1) {
                    maze[x][y] = 4;
                }
            }
        }

        printScreen();
        camera = new Camera(1.5, 1.5, -1, 0, 0, -0.66, maze);
        plr2 = new Camera(1.5, 1.5, -1, 0, 0, -0.66, maze);
        topDown = new TopDown(camera, maze, gridSize, plr2);
        addKeyListener(camera);
        setSize(width, height);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBackground(Color.PINK);
        setTitle("Maze 2.0");
        setLocationRelativeTo(null);
        setVisible(true);

        start();

    }

    public static void main(String[] args) {
        new Maze();
    }

    private static void shuffleArray(int[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            int temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
    }

    public static void generateMaze(int row, int col) {
        maze[row][col] = 0;
        int[] directions = { 0, 1, 2, 3 };
        shuffleArray(directions);
        for (int direction : directions) {
            int newRow = row;
            int newCol = col;
            if (direction == 0) {
                newRow -= 2;
            }
            if (direction == 1) {
                newRow += 2;
            }
            if (direction == 2) {
                newCol -= 2;
            }
            if (direction == 3) {
                newCol += 2;
            }
            if (newRow > 0 && newRow < gridSize - 1 && newCol > 0 && newCol < gridSize - 1
                    && (maze[newRow][newCol] == 1)) {
                maze[row + (newRow - row) / 2][col + (newCol - col) / 2] = 0;
                generateMaze(newRow, newCol);
            }
        }
    }

    public static void printScreen() {
        for (int y = 0; y < gridSize; y++) {
            for (int x = 0; x < gridSize; x++) {
                System.out.print(maze[x][y]);
            }
            System.out.println();
        }
    }

    public void run() {
        requestFocus();
        double delta = 0;
        double startTime2 = System.currentTimeMillis();
        long startTime = System.nanoTime();
        final double frameRate = 1000000000.0 / 60.0;
        while (isRunning) {
            long nanoTime = System.nanoTime();
            delta += ((nanoTime - startTime) / frameRate);
            startTime = nanoTime;
            while (delta >= 1) {
                if (camera.updateRan == 0) {
                    if (lastMove != "turn") {
                        turn();
                    } else {
                        lastMove = "forward";
                        camera.forward = true;
                        if (blockFacing == 1) {
                            y -= 1;
                        } else if (blockFacing == 2) {
                            x += 1;
                        } else if (blockFacing == 3) {
                            y += 1;
                        } else {
                            x -= 1;
                        }
                    }
                }
                camera.update();
                if (plr2.updateRan == 0) {
                    if (lastMove2 != "turn") {
                        turn();
                    } else {
                        lastMove2 = "forward";
                        plr2.forward = true;
                        if (blockFacing2 == 1) {
                            y2 -= 1;
                        } else if (blockFacing2 == 2) {
                            x2 += 1;
                        } else if (blockFacing2 == 3) {
                            y2 += 1;
                        } else {
                            x2 -= 1;
                        }
                    }
                }
                plr2.update();
                screen.update(camera, pixels);
                topDown.update(startTime2);
                delta--;
            }
            render();
        }
    }

    private synchronized void start() {
        isRunning = true;
        thread.start();
    }

    private synchronized void stop() {
        isRunning = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void render() {
        BufferStrategy bufferStrat = getBufferStrategy();
        if (bufferStrat == null) {
            createBufferStrategy(3);
            return;
        }
        Graphics graphic = bufferStrat.getDrawGraphics();
        graphic.drawImage(image, 0, 0, image.getWidth(), image.getHeight(), null);
        bufferStrat.show();
    }

    public void turn() {
        if (blockFacing == 1) {
            if (x == gridSize - 2 && y == gridSize - 2) {
                camera.back = true;
            } else if (maze[x - 1][y] == 0) {
                camera.left = true;
                blockFacing = 4;
                lastMove = "turn";
            } else if (maze[x][y - 1] == 0) {
                camera.forward = true;
                y -= 1;
            } else if (maze[x + 1][y] == 0) {
                camera.right = true;
                blockFacing = 2;
                lastMove = "turn";
            } else {
                camera.left = true;
                blockFacing = 4;
            }
        } else if (blockFacing == 2) {
            if (x == gridSize - 2 && y == gridSize - 2) {
                camera.right = true;
                blockFacing = 3;
            } else if (maze[x][y - 1] == 0) {
                camera.left = true;
                blockFacing = 1;
                lastMove = "turn";
            } else if (maze[x + 1][y] == 0) {
                camera.forward = true;
                x += 1;
            } else if (maze[x][y + 1] == 0) {
                camera.right = true;
                blockFacing = 3;
                lastMove = "turn";
            } else {
                camera.left = true;
                blockFacing = 1;
            }
        } else if (blockFacing == 3) {
            if (x == gridSize - 2 && y == gridSize - 2) {
                camera.right = true;
                blockFacing = 4;
            } else if (maze[x + 1][y] == 0) {
                camera.left = true;
                blockFacing = 2;
                lastMove = "turn";
            } else if (maze[x][y + 1] == 0) {
                camera.forward = true;
                y += 1;
            } else if (maze[x - 1][y] == 0) {
                camera.right = true;
                blockFacing = 4;
                lastMove = "turn";
            } else {
                camera.left = true;
                blockFacing = 2;
            }
        } else if (blockFacing == 4) {
            if (x == gridSize - 2 && y == gridSize - 2) {
                camera.right = true;
                blockFacing = 1;
            } else if (maze[x][y + 1] == 0) {
                camera.left = true;
                blockFacing = 3;
                lastMove = "turn";
            } else if (maze[x - 1][y] == 0) {
                camera.forward = true;
                x -= 1;
            } else if (maze[x][y - 1] == 0) {
                camera.right = true;
                blockFacing = 1;
                lastMove = "turn";
            } else {
                camera.left = true;
                blockFacing = 3;
            }
        }
    }

    public void turnPlr2() {
        if (blockFacing2 == 1) {
            if (x2 == gridSize - 2 && y2 == gridSize - 2) {
                plr2.back = true;
            } else if (maze[x2 - 1][y2] == 0) {
                plr2.left = true;
                blockFacing2 = 4;
                lastMove2 = "turn";
            } else if (maze[x2][y2 - 1] == 0) {
                plr2.forward = true;
                y2 -= 1;
            } else if (maze[x + 1][y] == 0) {
                plr2.right = true;
                blockFacing2 = 2;
                lastMove2 = "turn";
            } else {
                plr2.left = true;
                blockFacing2 = 4;
            }
        } else if (blockFacing2 == 2) {
            if (x == gridSize - 2 && y == gridSize - 2) {
                camera.right = true;
                blockFacing = 3;
            } else if (maze[x][y - 1] == 0) {
                camera.left = true;
                blockFacing = 1;
                lastMove = "turn";
            } else if (maze[x + 1][y] == 0) {
                camera.forward = true;
                x += 1;
            } else if (maze[x][y + 1] == 0) {
                camera.right = true;
                blockFacing = 3;
                lastMove = "turn";
            } else {
                camera.left = true;
                blockFacing = 1;
            }
        } else if (blockFacing2 == 3) {
            if (x == gridSize - 2 && y == gridSize - 2) {
                camera.right = true;
                blockFacing = 4;
            } else if (maze[x + 1][y] == 0) {
                camera.left = true;
                blockFacing = 2;
                lastMove = "turn";
            } else if (maze[x][y + 1] == 0) {
                camera.forward = true;
                y += 1;
            } else if (maze[x - 1][y] == 0) {
                camera.right = true;
                blockFacing = 4;
                lastMove = "turn";
            } else {
                camera.left = true;
                blockFacing = 2;
            }
        } else if (blockFacing2 == 4) {
            if (x == gridSize - 2 && y == gridSize - 2) {
                camera.right = true;
                blockFacing = 1;
            } else if (maze[x][y + 1] == 0) {
                camera.left = true;
                blockFacing = 3;
                lastMove = "turn";
            } else if (maze[x - 1][y] == 0) {
                camera.forward = true;
                x -= 1;
            } else if (maze[x][y - 1] == 0) {
                camera.right = true;
                blockFacing = 1;
                lastMove = "turn";
            } else {
                camera.left = true;
                blockFacing = 3;
            }
        }
    }
}
