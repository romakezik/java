package s;

import java.io.*;
import java.net.*;

class ClientThread extends Thread {
    Socket s = null;
    boolean spending;
    ClientInterface CI;
    
    public ClientThread(ClientInterface ci, String host, int port, boolean spend) {
        spending = spend;
        CI = ci;
        try {
            s = new Socket(host, port); 
        }
        catch(IOException e) {
            System.out.println("IOException on socket instantiating in ClientThread constructor" + e);
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                sleep(100);
            }
            catch(InterruptedException e) {
                System.out.println("InterruptedException on sleep in ClientThread.run()");
            }
            try {
                PrintWriter toServer = new PrintWriter(s.getOutputStream(), true);
                int amount = ((int)(Math.random()*100));
                if (spending)
                    toServer.println(-amount);
                else
                    toServer.println(0);

                BufferedReader fromServer = new BufferedReader(new InputStreamReader(s.getInputStream()));
                String line = fromServer.readLine();
                if(line == null)
                    break;
                CI.countLabel.setText("Account: "+ line);
            }
            catch(SocketException e) {
                break;
            } catch (IOException e) {
                System.out.println("IOException in ClientThread.run()");
            }
        } 
    }  
}