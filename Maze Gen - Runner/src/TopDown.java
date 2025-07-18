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
    public Camera plr2;

    @SuppressWarnings("static-access")
    public TopDown(Camera cam, int[][] maze, int gridSize, Camera plr2) {
        this.plr2 = plr2;
        this.maze = maze;
        this.gridSize = gridSize;
        camera = cam;
        image = new BufferedImage(gridSize * 10, gridSize * 10, BufferedImage.TYPE_INT_RGB);
        pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();
        setSize((gridSize * 10) + 13, (gridSize * 10) + 39);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setBackground(Color.PINK);
        setTitle("Map");
        setLocation(0, 0);
        setVisible(true);
    }

    public void update(double startTime) {
        double nowTime = System.currentTimeMillis();
        setTitle(Double.toString((nowTime - startTime) / 1000));
        for (int j = 0; j < image.getHeight(); j++) {

            for (int i = 0; i < image.getWidth(); i++) {
                if (maze[j / 10][i / 10] == 5) {
                    pixels[j + (i * image.getHeight())] = Color.BLUE.getRGB();
                } else if (maze[j / 10][i / 10] != 0) {
                    pixels[j + (i * image.getHeight())] = Color.WHITE.getRGB();
                } else {
                    pixels[j + (i * image.getHeight())] = Color.BLACK.getRGB();
                }
            }

        }
        for (int i = -2; i < 3; i++) {
            for (int j = -2; j < 3; j++) {
                pixels[(int) (camera.posX * 10) + j
                        + (((int) (camera.posY * 10) + i) * image.getHeight())] = Color.GREEN.getRGB();

            }
        }
        for (int i = -2; i < 3; i++) {
            for (int j = -2; j < 3; j++) {
                pixels[(int) (plr2.posX * 10) + j
                        + (((int) (plr2.posY * 10) + i) * image.getHeight())] = Color.YELLOW.getRGB();

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
