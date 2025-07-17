import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import org.w3c.dom.Text;

@SuppressWarnings("unused")
public class Texture {
    public int[] pixels;
    private String filePath;
    public final int size;

    public Texture(String location, int size) {
        filePath = location;
        this.size = size;
        pixels = new int[size * size];
        load();
    }

    private void load() {
        try {
            BufferedImage image = ImageIO.read(new File(filePath));
            int height = image.getHeight();
            int width = image.getWidth();
            image.getRGB(0,0, width, height, pixels, 0, width);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static Texture chipmunk = new Texture("res/chipmunk.png", 64);
    public static Texture squirrel = new Texture("res/squirrel.png", 64);
    public static Texture mole = new Texture("res/mole.png", 64);
    public static Texture rat = new Texture("res/rat.png", 64);
    public static Texture flag = new Texture("res/flag.png", 64);
}
