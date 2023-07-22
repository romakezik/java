package s;

import java.awt.*; 
import java.awt.event.*;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.swing.*;

public class ClientInterface extends JFrame  {
    JLabel countLabel = new JLabel("Account: 2000");
    JLabel ipLabel = new JLabel();

    public ClientInterface(String host, int port, String name) {
        setSize(600, 600);
        setTitle(name);
        setVisible(true);
        JButton buttonChange = new JButton("Change");
        JButton buttonRefresh = new JButton("Refresh");
        JPanel panel = new JPanel(new FlowLayout());
        
        panel.add(buttonChange);
        panel.add(buttonRefresh);
        panel.add(countLabel);
        panel.add(ipLabel); 
        getContentPane().add(panel);
        try {
            InetAddress inetAddress = InetAddress.getLocalHost();
            String ipAddress = inetAddress.getHostAddress();
            ipLabel.setText("IP Address: " + ipAddress); // ip
        } catch (UnknownHostException e) {
            System.out.println("Error getting IP address");
        }
        buttonChange.addActionListener((ActionEvent e) -> {
            ClientThread CT = new ClientThread(this, host, port, true);
            CT.start();
        });
        
        buttonRefresh.addActionListener((ActionEvent e) -> {
            ClientThread CT = new ClientThread(this, host, port, false);
            CT.start();
        });
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing (WindowEvent e) {    
                dispose();
            }    
        }); 
    }
}
