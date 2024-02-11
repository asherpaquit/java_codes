import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame window = new JFrame();

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // console will be close if this is closed
        window.setResizable(false);
        window.setTitle("2D Adventure");

        window.setLocationRelativeTo(null);
        // Screen will be always at center
        window.setVisible(true);
    }
}