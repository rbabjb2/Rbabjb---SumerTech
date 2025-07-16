import javax.swing.*;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Scanner;

public class BankSystem implements ActionListener {
    JFrame frame = new JFrame("Bank of Saba");
    JPanel loginPanel = new JPanel();
    JLabel loginLabel = new JLabel("Bank of Saba");
    JTextField username = new JTextField("Username", 20);
    JTextField password = new JTextField("Password", 20);
    JButton loginButton = new JButton("Login");
    JButton registerButton = new JButton("Register");
    Account bob = new Account(100, true);
    Account joe = new Account(50, false);

    public BankSystem() {
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        loginLabel.setSize(new Dimension(200, 100));
        loginLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 50));
        loginPanel.add(loginLabel);
        loginPanel.add(username);
        loginPanel.add(password);
        registerButton.addActionListener(this);
        registerButton.setActionCommand("Register");
        loginButton.addActionListener(this);
        loginButton.setActionCommand("Login");
        loginPanel.add(loginButton);
        loginPanel.add(registerButton);
        frame.add(loginPanel);
        frame.setVisible(true);
        System.out.println(bob.money);

    }

    public static void main(String[] args) {
        new BankSystem();
    }

    public void withdraw(Account account, double amount) {
        if (account.money >= amount * account.intrestRate) {
            account.money -= amount * account.intrestRate;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Login":
                if (password.getText().equals(checkNames(username.getText()))) {
                    System.out.println("You are logged in as " + username.getText());
                } else {
                    System.out.println("Wrong Password.");
                }
                break;
            case "Register":
                register(username.getText(), password.getText());
            break;
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
                FileWriter writer = new FileWriter(path);
                writer.write(passwordStr);
                writer.close();
            }
         } catch (IOException e) {
            e.printStackTrace();
         }
    }
}
