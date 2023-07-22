package s;

import java.io.*;
import java.net.*;

class Account extends Thread {
    ServerSocket server;
    Socket socket = null;
    int amount = 2000;
    int port;
    
    public Account(int port) {
        this.port = port;
    }
    
    @Override
    public void run() {
        try {
            server = new ServerSocket(this.port);
        }
        catch(IOException e) { 
            System.out.println("IOException on ServerSocket instantiating");
        }
        while(true) { 
            try {
                socket = server.accept();
            }
            catch(IOException e) {
                System.out.println("IOException on accepting connection from a client socket");
            }
            try {
                PrintStream toClient = new PrintStream(socket.getOutputStream());
                BufferedReader fromClient = new BufferedReader (new InputStreamReader(socket.getInputStream())); 
                int x = Integer.parseInt(fromClient.readLine());
                amount += x;
                toClient.println(amount);
                socket.close();
            }
            catch(IOException e) {
                System.out.println("IOException on client interaction");
            }
        }
    }
}
