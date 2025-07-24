import javax.swing.*;

public class dialog {
    
    public dialog() {
        JOptionPane text = new JOptionPane("Bob");
        JOptionPane.showInputDialog("Do you like waffles?");
    }

    public static void main(String[] args) {
        new dialog();

    }
}