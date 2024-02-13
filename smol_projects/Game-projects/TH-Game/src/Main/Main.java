package Main;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame window = new JFrame();

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // console will be close if this is closed
        window.setResizable(false);
        window.setTitle("2D Adventure");

        GamePanel gamePanel = new GamePanel();

        window.add(gamePanel);

        window.pack();
        // cause the windows to be sized to fit the preferred size and layouts



        window.setLocationRelativeTo(null);
        // Screen will be always at center
        window.setVisible(true);

        gamePanel.startGameThread();
    }
}