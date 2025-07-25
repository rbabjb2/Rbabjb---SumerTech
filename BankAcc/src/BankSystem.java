import javax.swing.*;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Scanner;

public class BankSystem implements ActionListener {
    JFrame frame = new JFrame("This is *not* a legal bank under supervision of Bank of Saba");
    JPanel loginPanel = new JPanel();
    JPanel bankPanel = new JPanel();
    JLabel label = new JLabel("Not Saba Bank™®");
    JLabel generalLabel = new JLabel("");
    JTextField username = new JTextField("Username", 20);
    JPasswordField password = new JPasswordField("ARLO WAS HERE", 20);
    JButton becomePremium;
    JButton withdraw = new JButton("Withdraw");
    JButton deposit = new JButton("Deposit");
    JButton loginButton = new JButton("Login");
    JButton registerButton = new JButton("Register");
    boolean takeInput = false;
    boolean enterPressed = false;
    String text;
    Account currentUser;

    public BankSystem() {
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        label.setSize(new Dimension(200, 100));
        label.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 50));

        username.setAlignmentX(Component.CENTER_ALIGNMENT);
        password.setAlignmentX(Component.CENTER_ALIGNMENT);

        loginPanel.add(label);
        loginPanel.add(username);
        loginPanel.add(password);

        loginButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        registerButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        registerButton.addActionListener(this);
        registerButton.setActionCommand("Register");

        loginButton.addActionListener(this);
        loginButton.setActionCommand("Login");

        loginPanel.add(new Box.Filler(new Dimension(250, 50), new Dimension(150, 25), new Dimension(250, 35)));
        loginPanel.add(loginButton);
        loginPanel.add(registerButton);
        loginPanel.add(new Box.Filler(new Dimension(250, 50), new Dimension(150, 25), new Dimension(250, 35)));

        generalLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        loginPanel.add(new Box.Filler(new Dimension(25, 50), new Dimension(45, 25), new Dimension(70, 35)));
        loginPanel.add(generalLabel);

        frame.add(loginPanel);
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        new BankSystem();
    }

    public void withdraw(Account account) {
        int amount;
        // Use a loop to ensure valid input is received
        while (true) {
            String input = JOptionPane.showInputDialog(null, "How much would you like to withdraw?");

            if (input == null) {
                return;
            }

            try {
                amount = Integer.parseInt(input);

                if (account.money >= amount && (username.getText().equals("Bob") || amount > 0)) {
                    account.money -= amount;
                    save(username.getText());
                    JOptionPane.showMessageDialog(null, "Withdrawing " + amount + " sabills.");
                } else {
                    JOptionPane.showMessageDialog(null, "You can't afford that.");
                }

                break;

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid number.", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }

    }

    public void deposit(Account account) {
        int amount;
        while (true) {
            String input = JOptionPane.showInputDialog(null, "How much would you like to deposit?");

            if (input == null) {
                JOptionPane.showMessageDialog(null, "Deposit canceled successfuly.");
                return;
            }

            try {
                amount = Integer.parseInt(input);

                if (amount > 0) {
                    account.money += amount;
                    JOptionPane.showInputDialog(null, "Are you sure you have " + amount + " sabills");
                    JOptionPane.showMessageDialog(null, "Depositing " + amount + " sabills.");
                }

                break;

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid number.", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.err.println("MILO WAS HERE");
        switch (e.getActionCommand()) {
            case "Login":
                if (new String(password.getPassword()).equals(checkNames(username.getText()))) {
                    System.out.println("You are logged in as " + username.getText());
                    loginSuccess(username.getText(), new String(password.getPassword()));
                    loginPanel.removeAll();
                    frame.remove(loginPanel);
                    frame.invalidate();
                    frame.validate();
                    frame.repaint();
                    save(username.getText());
                } else {
                    System.out.println("Wrong Password.");
                    generalLabel.setText("Wrong Password");
                }
                break;
            case "Register":
                register(username.getText(), new String(password.getPassword()));
                break;
            case "Withdraw":
                withdraw(currentUser);
                save(username.getName());
                break;
            case "Deposit":
                deposit(currentUser);
                save(username.getText());
                break;
            case "Manage":
                int choice = JOptionPane.showConfirmDialog(null, "Do you want to change your status?");
                if (choice == JOptionPane.YES_OPTION) {
                    if (currentUser.premiumAcc) {
                        int desicion = JOptionPane.showConfirmDialog(null,
                                "Are you sure you want to lose your premium status?");
                        if (desicion == JOptionPane.YES_OPTION) {
                            currentUser.premiumAcc = false;
                            bankPanel.setBackground(Color.white);
                            save(username.getText());
                        }
                    } else {
                        if (currentUser.money >= 100) {
                            currentUser.premiumAcc = true;
                            currentUser.money -= 100;
                            bankPanel.setBackground(new Color(255, 215, 0));
                            save(username.getText());
                        } else {
                            JOptionPane.showMessageDialog(null, "You can't afford that.", "Manage Accounts",
                                    JOptionPane.OK_OPTION, null);
                        }
                    }
                }
        }
    }

    public String checkNames(String usernameStr) {
        String path = "Accounts/" + usernameStr + ".txt";
        try {
            File password = new File(path);
            Scanner scanner = new Scanner(password);
            String temp = scanner.nextLine();
            scanner.close();
            return temp;
        } catch (FileNotFoundException e) {
            System.out.println("User does not exist.");
        }
        return null;

    }

    public void register(String usernameStr, String passwordStr) {
        String path = "Accounts/" + usernameStr + ".txt";
        File file = new File(path);
        try {
            if (file.createNewFile() == false) {
                System.out.println("User already exists.");
            } else {
                generalLabel.setText("Account registered.");
                FileWriter writer = new FileWriter(path);
                writer.write(passwordStr + "\n");
                writer.write("false \n");
                writer.write(Integer.toString(20));
                writer.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loginSuccess(String usernameStr, String passwordStr) {
        String path = "Accounts/" + usernameStr + ".txt";
        try {
            File accName = new File(path);
            Scanner scanner = new Scanner(accName);
            scanner.nextLine();
            currentUser = new Account(scanner.nextBoolean(), (int) scanner.nextInt());
            scanner.close();
        } catch (FileNotFoundException e) {

        }
        if (currentUser.premiumAcc) {
            bankPanel.setBackground(new Color(255, 215, 0));
        }
        bankPanel.setLayout(new BoxLayout(bankPanel, BoxLayout.Y_AXIS));
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        generalLabel.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 14));
        generalLabel.setText("You have " + currentUser.money + " sabills.");
        generalLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        withdraw.setAlignmentX(Component.CENTER_ALIGNMENT);
        withdraw.addActionListener(this);
        withdraw.setActionCommand("Withdraw");
        deposit.setAlignmentX(Component.CENTER_ALIGNMENT);
        deposit.addActionListener(this);
        deposit.setActionCommand("Deposit");
        bankPanel.add(label);
        bankPanel.add(withdraw);
        bankPanel.add(new Box.Filler(new Dimension(25, 50), new Dimension(50, 10), new Dimension(75, 25)));
        bankPanel.add(deposit);
        bankPanel.add(generalLabel);
        becomePremium = new JButton("Manage Account Plan");
        becomePremium.addActionListener(this);
        becomePremium.setActionCommand("Manage");
        becomePremium.setAlignmentX(Component.CENTER_ALIGNMENT);

        bankPanel.add(new Box.Filler(new Dimension(50, 50), new Dimension(75, 10), new Dimension(100, 25)));
        bankPanel.add(becomePremium);
        frame.add(bankPanel);
    }

    public void save(String usernameStr) {
        String path = "Accounts/" + usernameStr + ".txt";
        String passwordStr = "";
        File accName = new File(path);
        try {
            Scanner scanner = new Scanner(accName);
            passwordStr = scanner.nextLine() + "\n";
            scanner.close();
        } catch (FileNotFoundException e) {
        }
        try {
            FileWriter writer = new FileWriter(accName);
            accName.delete();
            accName.createNewFile();
            writer.append(passwordStr);
            writer.append(currentUser.getPremiumAcc() + "\n");
            writer.append(Integer.toString(currentUser.money));
            writer.close();
        } catch (IOException e) {

        }
    }


}
