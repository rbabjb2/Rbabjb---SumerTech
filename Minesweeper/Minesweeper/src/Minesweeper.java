import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout; 
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

public class Minesweeper extends JFrame implements KeyListener, MouseListener, ActionListener {
    int mineNum;
    static int gridSize;
    static int[][] storage;
    static Random random = new Random();
    int blocksRevealed = 0;
    JFrame frame = new JFrame("Arlo was here...");
    JPanel panel = new JPanel();
    JPanel startPanel = new JPanel();
    JLabel gameLabel = new JLabel("MINESWEEPER");
    JLabel label = new JLabel("You");
    JLabel label2 = new JLabel("Win");
    JSlider size = new JSlider(JSlider.HORIZONTAL, 5, 30, 15);
    JSlider bombs = new JSlider(JSlider.HORIZONTAL, 5, 30, 15);
    JButton startGame = new JButton("START GAME");
    JButton[][] button;
    GridLayout grid;
    BoxLayout box = new BoxLayout(startPanel, BoxLayout.Y_AXIS);
    ImageIcon[] numbers = new ImageIcon[] { new ImageIcon("icons/0.png"), new ImageIcon("icons/1.png"),
            new ImageIcon("icons/2.png"),
            new ImageIcon("icons/3.png"), new ImageIcon("icons/4.png"), new ImageIcon("icons/5.png"),
            new ImageIcon("icons/6.png"), new ImageIcon("icons/7.png"), new ImageIcon("icons/8.png") };
    ImageIcon flag = new ImageIcon("icons/flag.png");
    ImageIcon wrongFlag = new ImageIcon("icons/wrongFlag.png");
    ImageIcon bomb = new ImageIcon("icons/bomb.png");

    public Minesweeper() {
        frame.setSize(700, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);

        startPanel.setLayout(box);
        gameLabel.setPreferredSize(new Dimension(400, 300));
        gameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        gameLabel.setFont(new Font(Font.SERIF, Font.BOLD, 60));
        startPanel.add(new Box.Filler(new Dimension(25, 50), new Dimension(150, 25), new Dimension(200, 35)));
        startPanel.add(gameLabel);

        JPanel creditPanel = new JPanel();
        JLabel creditLabel = new JLabel("Made by Arlo dev INC.");
        creditLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        creditPanel.add(creditLabel);
        startPanel.add(creditPanel);
        startPanel.add(new Box.Filler(new Dimension(15, 35), new Dimension(150, 40), new Dimension(200, 60)));

        JPanel sizePanel = new JPanel();
        JLabel sizeLabel = new JLabel("Size:");
        sizeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        startPanel.add(sizeLabel);
        size.setMajorTickSpacing(5);
        size.setMinorTickSpacing(1);
        size.setPaintTicks(true);
        size.setPaintLabels(true);
        sizePanel.setPreferredSize(new Dimension(175, 50));
        sizePanel.setMaximumSize(new Dimension(250, 50));
        sizePanel.add(size);
        startPanel.add(sizePanel);

        JPanel bombPanel = new JPanel();
        JLabel bombLabel = new JLabel("Bomb Amount:");
        bombLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        startPanel.add(bombLabel);
        bombs.setMajorTickSpacing(5);
        bombs.setMinorTickSpacing(1);
        bombs.setPaintTicks(true);
        bombs.setPaintLabels(true);
        bombPanel.setPreferredSize(new Dimension(175, 50));
        bombPanel.setMaximumSize(new Dimension(250, 50));
        bombPanel.add(bombs);
        startPanel.add(bombPanel);
        startPanel.add(new Box.Filler(new Dimension(25, 50), new Dimension(150, 25), new Dimension(200, 35)));

        JPanel startGamePanel = new JPanel();
        startGamePanel.setPreferredSize(new Dimension(150, 50));
        startGamePanel.setMinimumSize(new Dimension(150, 50));
        startGame.addActionListener(this);
        startGamePanel.add(startGame);
        startPanel.add(startGamePanel);
        startGame.setPreferredSize(new Dimension(125, 36));
        startGame.setAlignmentX(Component.CENTER_ALIGNMENT);

        startPanel.add(new Box.Filler(new Dimension(25, 50), new Dimension(150, 25), new Dimension(200, 35)));
        frame.add(startPanel);
        frame.invalidate();
        frame.validate();
        frame.repaint();
    }

    public void startGame() {
        frame.invalidate();
        frame.validate();
        frame.repaint();
        blocksRevealed = 0;
        for (int mines = 0; mines < mineNum; mines++) { // Place the mines
            int[] nextPos = new int[] { random.nextInt(gridSize), random.nextInt(gridSize) };
            if (storage[nextPos[0]][nextPos[1]] != -1) {
                storage[nextPos[0]][nextPos[1]] = -1;
                for (int j = -1; j < 2; j++) {
                    for (int i = -1; i < 2; i++) {

                        if ((nextPos[0] + i != -1 && nextPos[1] + j != -1)
                                && (nextPos[0] + i != gridSize && nextPos[1] + j != gridSize)
                                && storage[nextPos[0] + i][nextPos[1] + j] != -1) {
                            storage[nextPos[0] + i][nextPos[1] + j]++;
                        }
                    }
                }
            } else {
                mines--;
            }
        }

        frame.setSize(gridSize * 35, gridSize * 35);
        panel.setLayout(grid);
        for (int y = 0; y < gridSize; y++) {

            for (int i = 0; i < gridSize; i++) {
                button[i][y] = new JButton(numbers[0]);
                button[i][y].setPreferredSize(new Dimension(36, 36));
                panel.add(button[i][y]);
                button[i][y].addMouseListener(this);
            }
        }

        grid.layoutContainer(panel);
        frame.add(panel);
        frame.addKeyListener(this);
        frame.setFocusable(true);
        frame.requestFocus();
        frame.invalidate();
        frame.validate();
        frame.repaint();

    }

    public static void main(String[] args) {
        new Minesweeper();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        gridSize = size.getValue();
        mineNum = bombs.getValue();
        storage = new int[gridSize][gridSize];
        button = new JButton[gridSize][gridSize];
        grid = new GridLayout(0, gridSize, 0, 0);
        if (mineNum > (gridSize * gridSize)) {
            JLabel warnLabel = new JLabel("         There are too many mines. Lower them or raise grid size.");
            JFrame warnFrame = new JFrame("Help Screen");
            warnFrame.setSize(400, 300);
            warnFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            warnFrame.setVisible(true);
            warnFrame.setResizable(false);
            warnFrame.add(warnLabel);
        } else {
            startPanel.removeAll();
            frame.remove(startPanel);
            startGame();
        }
        frame.invalidate();
        frame.validate();
        frame.repaint();
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
        for (int y = 0; y < gridSize; y++) {
            for (int i = 0; i < gridSize; i++) {
                if (e.getSource() == button[i][y]) {
                    if (SwingUtilities.isRightMouseButton(e)) {
                        if (button[i][y].isEnabled() == true && button[i][y].getIcon() == numbers[0]) {
                            button[i][y].setIcon(flag);
                        } else if (button[i][y].getIcon() == flag) {
                            button[i][y].setIcon(numbers[0]);
                        }
                    } else {
                        if (storage[i][y] != -1) {
                            checkBlocksRevealed();
                            button[i][y].setIcon(numbers[storage[i][y]]);
                            if (storage[i][y] == 0) {
                                checkSurroundings(i, y);
                            }
                        } else {
                            System.out.println("You died!");
                            death();
                        }
                    }
                }
            }
        }

    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    public void checkBlocksRevealed() {
        blocksRevealed++;
        if (blocksRevealed == (gridSize * gridSize) - mineNum) {

            System.out.println("You win!");
            panel.removeAll();
            panel.add(label);
            panel.add(label2);
            frame.invalidate();
            frame.validate();
            frame.repaint();
        }
    }

    public void death() {
        for (int y = 0; y < gridSize; y++) {

            for (int x = 0; x < gridSize; x++) {
                if (button[x][y].getIcon() == numbers[0]) {
                    if (storage[x][y] == 0) {
                        button[x][y].setEnabled(false);
                    } else if (storage[x][y] == -1) {
                        button[x][y].setIcon(bomb);
                    } else {
                        button[x][y].setIcon(numbers[storage[x][y]]);
                    }
                } else if (button[x][y].getIcon() == flag) {
                    if (storage[x][y] == -1) {
                        button[x][y].setIcon(bomb);
                        button[x][y].setEnabled(false);
                    } else {
                        button[x][y].setIcon(wrongFlag);
                    }
                }
            }
        }
    }

    public void checkSurroundings(int i, int y) {
        button[i][y].setEnabled(false);
        for (int z = -1; z < 2; z++) {
            for (int x = -1; x < 2; x++) {
                if ((i + x > -1 && y + z > -1)
                        && (x + i < gridSize && y + z < gridSize) && (button[i + x][y + z].isEnabled() == true)
                        && button[x + i][z + y].getIcon() == numbers[0]) {
                    checkBlocksRevealed();
                    if (storage[i + x][y + z] == 0) {
                        checkSurroundings(i + x, y + z);
                    } else {
                        button[i + x][y + z].setIcon(numbers[storage[i + x][y + z]]);
                    }

                }
            }
        }
    }

}