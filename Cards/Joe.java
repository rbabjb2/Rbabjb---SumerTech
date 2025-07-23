import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.Random;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;


public class Joe {
    public Clipboard clipboard;
    public Robot joe;
    
    public Joe() {
        clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(new StringSelection("//Joe was here"), null);
        try {
            joe = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        joe.mouseMove(700, new Random().nextInt(700) + 300);
        joe.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        joe.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        joe.keyPress(KeyEvent.VK_CONTROL);
        joe.keyPress(KeyEvent.VK_V);
        joe.keyRelease(KeyEvent.VK_V);
        joe.keyRelease(KeyEvent.VK_CONTROL);

    }

    public static void main(String[] args) {
        new Joe();
    }
}
