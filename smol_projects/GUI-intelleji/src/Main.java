import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main implements ActionListener{

    static JButton button;

    public static void main(String[] args) {
        button = new JButton();
        button.setBounds(250, 220, 200, 200);
        button.setText("Click Me!");
        button.addActionListener(e -> System.out.println("Woers"));

        JLabel label = new JLabel();
        label.setText("Wow ang ganda");
        label.setVerticalAlignment(JLabel.CENTER);

        JPanel red = new JPanel();
        red.setBackground(Color.red);
        red.setBounds(0, 0, 250, 250);

        JPanel blue = new JPanel();
        blue.setBackground(Color.blue);
        blue.setBounds(250, 0, 250, 250);

        JPanel green = new JPanel();
        green.setBackground(Color.green);
        green.setBounds(0,250,500,250);
        green.setLayout(new BorderLayout()); // makes the word not in the centre

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setTitle("Game");
        frame.setSize(750, 750);

        // Set bounds for label
        frame.add(button);
        frame.add(red);
        frame.add(blue);
        frame.add(green);
        green.add(label); // add red some text;


        frame.setVisible(true);
        System.out.println("Hello world!");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button){
            System.out.print("Wowers");
        }
    }
}