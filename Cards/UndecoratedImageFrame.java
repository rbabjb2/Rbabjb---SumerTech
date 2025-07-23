import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.Image;
import javax.imageio.*;

public class UndecoratedImageFrame extends JFrame {

    private BufferedImage image;

    public UndecoratedImageFrame(BufferedImage image) {
        this.image = image;

        // 1. Create an Undecorated JFrame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true); // Remove border and title bar

        // 2. Create a Custom JPanel for Drawing
        MyImagePanel panel = new MyImagePanel();
        add(panel);

        // 5. Set Frame Properties and Make it Visible
        pack(); // Size the frame to fit the panel
        setLocationRelativeTo(null); // Center the frame on the screen
        setVisible(true); // Display the frame
    }

    // Custom JPanel to draw the BufferedImage
    class MyImagePanel extends JPanel {

        public MyImagePanel() {
            setPreferredSize(new Dimension(image.getWidth(), image.getHeight())); // Set panel size to match image
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g); // Paint the background
            // 3. Draw the BufferedImage on the JPanel
            g.drawImage(image, 0, 0, this); // Draw the image at (0,0)
        }
    }

    public static void main(String[] args) {
        // Create a sample BufferedImage (replace with your actual image loading)
        try {
        BufferedImage img = ImageIO.read(new File("5.png"));
        BufferedImage img2 = new BufferedImage(300, 200, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = img2.createGraphics();
        g2d.setColor(Color.DARK_GRAY);
        g2d.fillRect(0, 0, 300, 200);
        g2d.setColor(Color.BLUE);
        g2d.drawImage(img, 0, 0, Color.RED, null);
        g2d.dispose();

        SwingUtilities.invokeLater(() -> new UndecoratedImageFrame(img));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}