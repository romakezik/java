package s;

import javax.swing.*;
import java.awt.*; 
import java.awt.event.*;

public class Menu extends JFrame {
    int amount = 0;
    public Menu(String host, int port) {
        setSize(600, 600);
        setTitle("Client pannel");
        setVisible(true);
        JPanel panel = new JPanel(new FlowLayout());
        JButton startButton = new JButton("Start");
        panel.add(startButton);
        getContentPane().add(panel);
        startButton.addActionListener((ActionEvent e) -> {
            this.amount++;
            ClientInterface CI = new ClientInterface(host, port, "Client" + this.amount);
        });
    }
}
