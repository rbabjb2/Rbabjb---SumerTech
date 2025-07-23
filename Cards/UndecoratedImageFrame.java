import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.awt.Image;
import javax.imageio.*;

public class UndecoratedImageFrame extends JFrame {

    private JFrame pos = new JFrame();
    @SuppressWarnings("unused")
    private BufferedImage image;

    public UndecoratedImageFrame(BufferedImage image) {
        this.image = image;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);
        setSize(500, 500);

        MyImagePanel img = new MyImagePanel(image);
        add(img);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);

        
        while (true) {
            try {
                Thread.sleep(100000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            pos.setLocation(pos.getX() + 5, 100);
            setLocationRelativeTo(pos);
        }
    }

    // Custom JPanel to draw the BufferedImage
    class MyImagePanel extends JPanel {
        BufferedImage image;

        public MyImagePanel(BufferedImage image) {
            this.image = image;
            setPreferredSize(new Dimension(image.getWidth(), image.getHeight())); // Set panel size to match image
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g); // Paint the background
            // 3. Draw the BufferedImage on the JPanel
            g.drawImage(image, 0, 0, this); // Draw the image at (0,0)
        }

        public static void main(String[] args) throws IOException {
            System.out.println("Main Method");

            BufferedImage img = ImageIO.read(new File("5.png"));
            BufferedImage img2 = new BufferedImage(300, 200, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2d = img2.createGraphics();
            g2d.setColor(Color.DARK_GRAY);
            g2d.fillRect(0, 0, 300, 200);
            g2d.setColor(Color.BLUE);
            g2d.drawImage(img, 0, 0, Color.RED, null);
            g2d.dispose();

            SwingUtilities.invokeLater(() -> new UndecoratedImageFrame(img));
        }

        public void coolFish() throws IOException{

            BufferedImage img = ImageIO.read(new File("5.png"));
            BufferedImage img2 = new BufferedImage(300, 200, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2d = img2.createGraphics();
            g2d.setColor(Color.DARK_GRAY);
            g2d.fillRect(0, 0, 300, 200);
            g2d.setColor(Color.BLUE);
            g2d.drawImage(img, 0, 0, Color.RED, null);
            g2d.dispose();

            SwingUtilities.invokeLater(() -> new UndecoratedImageFrame(img));
        }

    }
}