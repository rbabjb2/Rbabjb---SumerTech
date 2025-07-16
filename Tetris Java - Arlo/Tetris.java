import javax.swing.*;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

// Click here when running:  

public class Tetris extends JFrame implements KeyListener {
    static JPanel panel = new JPanel();
    static JLabel label = new JLabel();
    static JFrame frame = new JFrame("Screen");
    static int screenSizeY = 14;
    static int screenSizeX = 10;
    static block[] blockArray = new block[5];
    static String[][] screen = new String[screenSizeX][screenSizeY];
    static boolean gameOver = false;
    static Random random = new Random();
    static String dropType = "default";
    static String nextBlock;

    public Tetris() {
        super();
        frame.addKeyListener(this);
        frame.setFocusable(true);
        frame.requestFocus();
    }

    public static void main(String[] args) {
        for (int i = 1; i < 5; i++) {
            blockArray[i] = new block();
            blockArray[i].setBlockNumber(i);
        }
        dropType = "default";
        new Tetris();
        String borderChar = "|";
        for (int i = 1; i < 5; i++) {
            blockArray[i].screenSizeSet(screenSizeX, screenSizeY);
        }

        for (int y = 0; y < screenSizeY; y++) {
            for (int x = 0; x < screenSizeX; x++) {
                if (x == screenSizeX - 1 || x == 0) {
                    screen[x][y] = borderChar;
                } else if (y == screenSizeY - 1) {
                    screen[x][y] = "=";
                } else {
                    screen[x][y] = " ";
                }
            }
        }
        label.setFont(new Font("Monospaced", Font.BOLD, 16));
        frame.setSize(400, 400);
        String[] possibleBlocks = new String[] { "line", "cube", "l", "j", "s", "z", "t" };
        nextBlock = possibleBlocks[random.nextInt(7)];
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.add(panel);
        printScreen();
        for (int i = 1; i < 5; i++) {
            blockArray[i].reset(nextBlock);
            screen[blockArray[i].posX][blockArray[i].posY] = "X";

        }
        printScreen();
        nextBlock = possibleBlocks[random.nextInt(7)];
        while (gameOver == false) {

            while ((blockArray[1].isBottom == false || screen[blockArray[1].posX][blockArray[1].posY + 1] == " ")
                    && (blockArray[2].isBottom == false || screen[blockArray[2].posX][blockArray[2].posY + 1] == " ")
                    && (blockArray[3].isBottom == false || screen[blockArray[3].posX][blockArray[3].posY + 1] == " ")
                    && (blockArray[4].isBottom == false || screen[blockArray[4].posX][blockArray[4].posY + 1] == " ")) {
                screen[blockArray[1].posX][blockArray[1].posY] = " ";
                screen[blockArray[2].posX][blockArray[2].posY] = " ";
                screen[blockArray[3].posX][blockArray[3].posY] = " ";
                screen[blockArray[4].posX][blockArray[4].posY] = " ";

                blockArray[1].move("down");
                blockArray[2].move("down");
                blockArray[3].move("down");
                blockArray[4].move("down");

                screen[blockArray[1].posX][blockArray[1].posY] = "X";
                screen[blockArray[2].posX][blockArray[2].posY] = "X";
                screen[blockArray[3].posX][blockArray[3].posY] = "X";
                screen[blockArray[4].posX][blockArray[4].posY] = "X";

                if (dropType == "default") {
                    printScreen();
                    makeLabels();
                    try {
                        java.util.concurrent.TimeUnit.MILLISECONDS.sleep(650);
                    } catch (InterruptedException temp) {
                        temp.printStackTrace();
                    }
                } else if (dropType == "hard") {
                    try {
                        java.util.concurrent.TimeUnit.MILLISECONDS.sleep(50);
                    } catch (InterruptedException temp) {
                        temp.printStackTrace();
                    }
                    // Runs when hard dropping.
                } else if (dropType == "soft") {
                    printScreen();
                    makeLabels();
                    try {
                        java.util.concurrent.TimeUnit.MILLISECONDS.sleep(100);
                    } catch (InterruptedException temp) {
                        temp.printStackTrace();
                    }
                } else {
                    System.out.println("Please check the drop type variable.");
                    System.exit(0);
                }

            }
            dropType = "default";
            if (blockArray[1].posY == 0) {
                gameOver = true;
                System.out.println("Game Over!");
                System.exit(0);
            }
            lineClearDetect();
            blockArray[1].reset(nextBlock);
            blockArray[2].reset(nextBlock);
            blockArray[3].reset(nextBlock);
            blockArray[4].reset(nextBlock);
            nextBlock = possibleBlocks[random.nextInt(7)];
            screen[blockArray[1].posX][blockArray[1].posY] = "X";
            screen[blockArray[2].posX][blockArray[2].posY] = "X";
            screen[blockArray[3].posX][blockArray[3].posY] = "X";
            screen[blockArray[4].posX][blockArray[4].posY] = "X";
            printScreen();
        }

    }

    public static void makeLabels() {
        panel.removeAll();
        String arrayToString = "<html><pre>";
        for (int i = 0; i < screenSizeY; i++) {
            for (int x = 0; x < screenSizeX; x++) {
                arrayToString = arrayToString + screen[x][i];
            }
            arrayToString = arrayToString + "<br>";
        }
        arrayToString = arrayToString + "Next block is " + nextBlock + "</pre></html>";
        label.setBounds(50, 50, 1000, 50);
        label.setText(arrayToString);
        panel.add(label);
        panel.revalidate();
        panel.repaint();
    }

    public static void printScreen() {
        System.out.println();
        for (int y = 0; y < screenSizeY; y++) {
            for (int x = 0; x < screenSizeX; x++) {
                System.out.print(screen[x][y]);
            }
            System.out.println();
        }
        System.out.println("Next block is " + nextBlock);
    }

    public static void lineClearDetect() {
        for (int b = 1; b < 5; b++) {
            boolean run = true;
            for (int i = 1; i < screenSizeX - 1 && run == true; i++) {
                if (screen[i][blockArray[b].posY] == " ") {
                    run = false;
                }
            }
            if (run == true) {
                for (int i = 1; i < screenSizeX - 1; i++) {
                    for (int y = blockArray[b].posY; y > 0; y--) {
                        if (blockArray[b].posX == i && blockArray[b].posY == y) {
                            System.out.println("Clearing Line.");
                            System.out.println(screen[i][y - 1]);
                        }
                        screen[i][y] = screen[i][y - 1];
                    }
                }
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        switch (keyCode) {
            case KeyEvent.VK_A:
                if ((blockArray[1].isLeft == false || screen[blockArray[1].posX - 1][blockArray[1].posY] == " ")
                        && (blockArray[2].isLeft == false || screen[blockArray[2].posX - 1][blockArray[2].posY] == " ")
                        && (blockArray[3].isLeft == false || screen[blockArray[3].posX - 1][blockArray[3].posY] == " ")
                        && (blockArray[4].isLeft == false
                                || screen[blockArray[4].posX - 1][blockArray[4].posY] == " ")) {
                    screen[blockArray[1].posX][blockArray[1].posY] = " ";
                    screen[blockArray[2].posX][blockArray[2].posY] = " ";
                    screen[blockArray[3].posX][blockArray[3].posY] = " ";
                    screen[blockArray[4].posX][blockArray[4].posY] = " ";
                    blockArray[1].move("left");
                    blockArray[2].move("left");
                    blockArray[3].move("left");
                    blockArray[4].move("left");
                    screen[blockArray[1].posX][blockArray[1].posY] = "X";
                    screen[blockArray[2].posX][blockArray[2].posY] = "X";
                    screen[blockArray[3].posX][blockArray[3].posY] = "X";
                    screen[blockArray[4].posX][blockArray[4].posY] = "X";
                    makeLabels();
                    printScreen();
                }
                break;
            case KeyEvent.VK_D:
                if ((blockArray[1].isRight == false || screen[blockArray[1].posX + 1][blockArray[1].posY] == " ")
                        && (blockArray[2].isRight == false || screen[blockArray[2].posX + 1][blockArray[2].posY] == " ")
                        && (blockArray[3].isRight == false || screen[blockArray[3].posX + 1][blockArray[3].posY] == " ")
                        && (blockArray[4].isRight == false
                                || screen[blockArray[4].posX + 1][blockArray[4].posY] == " ")) {
                    screen[blockArray[1].posX][blockArray[1].posY] = " ";
                    screen[blockArray[2].posX][blockArray[2].posY] = " ";
                    screen[blockArray[3].posX][blockArray[3].posY] = " ";
                    screen[blockArray[4].posX][blockArray[4].posY] = " ";
                    blockArray[1].move("right");
                    blockArray[2].move("right");
                    blockArray[3].move("right");
                    blockArray[4].move("right");
                    screen[blockArray[1].posX][blockArray[1].posY] = "X";
                    screen[blockArray[2].posX][blockArray[2].posY] = "X";
                    screen[blockArray[3].posX][blockArray[3].posY] = "X";
                    screen[blockArray[4].posX][blockArray[4].posY] = "X";
                    makeLabels();
                    printScreen();
                }
                break;
            case KeyEvent.VK_W:
                dropType = "hard";
                break;
            case KeyEvent.VK_S:
                dropType = "soft";
                break;
            case KeyEvent.VK_LEFT:
                screen[blockArray[1].posX][blockArray[1].posY] = " ";
                screen[blockArray[2].posX][blockArray[2].posY] = " ";
                screen[blockArray[3].posX][blockArray[3].posY] = " ";
                screen[blockArray[4].posX][blockArray[4].posY] = " ";
                blockArray[1].rotate();
                blockArray[2].rotate();
                blockArray[3].rotate();
                blockArray[4].rotate();
                try {

                    if (screen[blockArray[1].posX][blockArray[1].posY] == " "
                            && screen[blockArray[2].posX][blockArray[2].posY] == " "
                            && screen[blockArray[3].posX][blockArray[3].posY] == " "
                            && screen[blockArray[4].posX][blockArray[4].posY] == " ") {

                    } else {
                        for (int i = 0; i < 3; i++) {
                            blockArray[1].rotate();
                            blockArray[2].rotate();
                            blockArray[3].rotate();
                            blockArray[4].rotate();
                        }
                    }
                } catch (ArrayIndexOutOfBoundsException joe) {
                    for (int i = 0; i < 3; i++) {
                        blockArray[1].rotate();
                        blockArray[2].rotate();
                        blockArray[3].rotate();
                        blockArray[4].rotate();
                    }
                }
                screen[blockArray[1].posX][blockArray[1].posY] = "X";
                screen[blockArray[2].posX][blockArray[2].posY] = "X";
                screen[blockArray[3].posX][blockArray[3].posY] = "X";
                screen[blockArray[4].posX][blockArray[4].posY] = "X";
                makeLabels();
                printScreen();

                break;
            case KeyEvent.VK_ESCAPE:
                System.exit(0);
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        switch (keyCode) {
            case KeyEvent.VK_S:
                dropType = "default";
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

}
