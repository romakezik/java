package s;

public class Main{

    public static void main(String[] args) {
        int amount=1;
        new Account(3001).start();

        ClientInterface CI2 = new ClientInterface("127.0.0.4", 3001, "Client1");

        new Account(3002).start();
        Menu menu = new Menu("127.0.0.4", 3001);
    }
}
