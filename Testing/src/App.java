import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout; 
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class App extends JFrame implements KeyListener, MouseListener, ActionListener {
    int mineNum;
    static int gridSize;
    static int[][] storage;
    static Random random = new Random();
    int blocksRevealed = 0;
    JFrame frame = new JFrame("Robert was here...");
    JPanel panel = new JPanel();
    JPanel startPanel = new JPanel();21
    JButton[][] button;
    GridLayout grid;
    BoxLayout box = new BoxLayout(startPanel, BoxLayout.Y_AXIS);
    ArrayList<Wall> walls = new ArrayList<Wall>();

    class Wall {
        
    }

    public App() {
        frame.setSize(700, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);


    }

    public static void main(String[] args) {
        new App();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        switch (keyCode) {
            case KeyEvent.VK_ESCAPE:
                System.exit(0);
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // This doesn't matter.
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // This doesn't matter.
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}