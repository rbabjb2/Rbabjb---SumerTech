import java.util.Random;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.awt.image.*;

//@SuppressWarnings("unused")
public class TopDown extends JFrame {
    static Random random = new Random();
    static int gridSize;
    private static int maze[][];
    private BufferedImage image;
    public int[] pixels;
    public ArrayList<Texture> textures;
    public Camera camera;

    @SuppressWarnings("static-access")
    public TopDown(Camera cam, int[][] maze, int gridSize) {
        this.maze = maze;
        this.gridSize = gridSize;
        camera = cam;
        image = new BufferedImage(gridSize * 10, gridSize * 10, BufferedImage.TYPE_INT_RGB);
        pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();
        setSize((gridSize * 10) + 13, (gridSize * 10) + 39);
        setResizable(false);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setBackground(Color.PINK);
        setTitle("Map");
        setLocation(0, 0);
        setVisible(true);
    }

    public void update(double startTime) {
        double nowTime = System.currentTimeMillis();
        setTitle(Double.toString((nowTime - startTime) / 1000));
        for (int y = 0; y < image.getHeight(); y++) {

            for (int x = 0; x < image.getWidth(); x++) {
                if (maze[x / 10][y / 10] == 5) {
                    pixels[x + (y * image.getHeight())] = Color.BLUE.getRGB();
                } else if (maze[x / 10][y / 10] == 1) {
                    pixels[x + (y * image.getHeight())] = Color.WHITE.getRGB();
                } else if (maze[x / 10][y / 10] == 2) {
                    pixels[x + (y * image.getHeight())] = Color.YELLOW.getRGB();
                } else if (maze[x / 10][y / 10] == 3) {
                    pixels[x + (y * image.getHeight())] = Color.RED.getRGB();
                } else if (maze[x / 10][y / 10] == 4) {
                    pixels[x + (y * image.getHeight())] = Color.MAGENTA.getRGB();
                } else {
                    pixels[x + (y * image.getHeight())] = Color.BLACK.getRGB();
                }
            }

        }
        for (int y = -2; y < 3; y++) {
            for (int x = -2; x < 3; x++) {
                pixels[(int) (camera.posX * 10) + x
                        + (((int) (camera.posY * 10) + y) * image.getHeight())] = Color.GREEN.getRGB();

            }
        }
        render();
    }

    public void render() {
        BufferStrategy bufferStrat = getBufferStrategy();
        if (bufferStrat == null) {
            createBufferStrategy(3);
            return;
        }
        Graphics graphic = bufferStrat.getDrawGraphics();
        graphic.drawImage(image, 8, 31, image.getWidth(), image.getHeight(), null);
        bufferStrat.show();
    }
}
