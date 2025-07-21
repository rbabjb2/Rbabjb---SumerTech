import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;

import javax.swing.*;

public class App extends JFrame implements Runnable {
    JFrame frame = new JFrame("CLICK THE BUTTON, DONT LOOK AT ME");
    ImageIcon cookie = new ImageIcon("res/bomb.png");
    JPanel upgradePanel = new JPanel();
    JPanel mainPanel = new JPanel();
    JPanel buttonPanel = new JPanel();
    private boolean isRunning;
    private DecimalFormat form = new DecimalFormat("0.00");
    private JLabel bpsDisplay = new JLabel("0");
    private double bps = 0;
    private int tick = 0;
    private double money = 0;
    private boolean delay;
    int upTick = 0;
    JLabel moneyAmount = new JLabel(form.format(money));
    private Thread thread = new Thread(this);
    BoxLayout box = new BoxLayout(buttonPanel, BoxLayout.Y_AXIS);
    BoxLayout box2 = new BoxLayout(upgradePanel, BoxLayout.Y_AXIS);
    GridLayout grid = new GridLayout(0, 2);
    JButton click = new JButton(cookie);
    JButton[] upgrades = { new JButton("Mine Clicker"), new JButton("Mine Miner") };

    public App() {
        Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setSize((int) screensize.getWidth(), (int) screensize.getHeight());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        buttonPanel.getInputMap();
        buttonPanel.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "Escape");
        buttonPanel.setSize(new Dimension(64, 64));
        buttonPanel.getActionMap();
        buttonPanel.setBackground(Color.LIGHT_GRAY);
        buttonPanel.setLayout(box);
        moneyAmount.setAlignmentY(Component.CENTER_ALIGNMENT);
        buttonPanel.add(moneyAmount);
        buttonPanel.getActionMap().put("Escape", new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }

        });
        click.addActionListener(e -> add());

        moneyAmount.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 32));
        moneyAmount.setAlignmentX(Component.CENTER_ALIGNMENT);

        upgradePanel.getInputMap();
        upgradePanel.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "Escape");
        upgradePanel.getActionMap();
        upgradePanel.getActionMap().put("Escape", new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Added clicker thing");
            }

        });

        Dimension panelSize = Toolkit.getDefaultToolkit().getScreenSize();
        upgrades[0].setAlignmentX(Component.CENTER_ALIGNMENT);
        upgrades[0].setMaximumSize(new Dimension((int) Math.floor(panelSize.getWidth()) - 25, 75));
        upgrades[0].setPreferredSize(new Dimension((int) Math.floor(panelSize.getWidth()), 100));
        upgrades[0].setPreferredSize(new Dimension((int) Math.floor(panelSize.getWidth()) + 25, 125));
        upgrades[0].setSize((int) Math.floor(panelSize.getWidth()), 30);
        upgrades[0].addActionListener(e -> upgrade(0));

        upgrades[1].setAlignmentX(Component.CENTER_ALIGNMENT);
        upgrades[1].setMaximumSize(new Dimension((int) Math.floor(panelSize.getWidth()) - 25, 75));
        upgrades[1].setPreferredSize(new Dimension((int) Math.floor(panelSize.getWidth()), 100));
        upgrades[1].setPreferredSize(new Dimension((int) Math.floor(panelSize.getWidth()) + 25, 125));
        upgrades[1].addActionListener(e -> upgrade(1));

        upgradePanel.setLayout(box2);
        upgradePanel.add(upgrades[0]);
        upgradePanel.add(upgrades[1]);
        upgradePanel.setAlignmentX(Component.RIGHT_ALIGNMENT);

        bpsDisplay.setAlignmentX(Component.CENTER_ALIGNMENT);

        click.setMinimumSize(new Dimension((int)panelSize.getWidth() - 50, (int) panelSize.getHeight() - 50));
        click.setPreferredSize(new Dimension((int)panelSize.getWidth() - 25, (int) panelSize.getHeight() - 25));
        click.setMaximumSize(new Dimension((int)panelSize.getWidth() - 10, (int) panelSize.getHeight() - 10));
        click.setOpaque(true);
        click.setAlignmentX(Component.CENTER_ALIGNMENT);
        click.setContentAreaFilled(false);
        click.setBorderPainted(false);
        buttonPanel.add(click);
        buttonPanel.add(bpsDisplay);
        buttonPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        mainPanel.setLayout(grid);
        mainPanel.add(buttonPanel);
        mainPanel.add(upgradePanel);
        frame.add(mainPanel);
        frame.setVisible(true);
        start();
    }

    public static void main(String[] args) {
        new App();
    }

    public void run() {
        System.out.println("Running");
        double delta = 0;
        long startTime = System.nanoTime();
        final double frameRate = 1000000000.0 / 60.0;
        while (isRunning) {
            long nanoTime = System.nanoTime();
            delta += ((nanoTime - startTime) / frameRate);
            startTime = nanoTime;
            while (delta >= 0) {
                moneyAmount.setText("Bombs: " + form.format(money));
                bpsDisplay.setText("You have " + form.format(bps) + " BPS");
                delta--;
                if (tick == 60) {
                    tick = 0;
                    money += bps;
                    if (delay) {
                        upgrades[0].setText("Mine Clicker: 1");
                        upgrades[1].setText("Mine Miner: 30");
                        delay = false;
                    }
                }
                tick++;
            }
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

    public void add() {
        money++;
    }

    public void upgrade(int place) {
        switch (place) {
            case 0:
                if (money >= 1) {
                    money -= 1;
                    bps += 0.1;
                } else {
                    upgrades[0].setText("You can't afford that");
                    delay = true;
                }
                break;
            case 1:
                if (money >= 30) {
                    money -= 30;
                    bps += 0.5;
                } else {
                    upgrades[1].setText("You can't afford that");
                    delay = true;
                }
                break;
        }
    }

}
