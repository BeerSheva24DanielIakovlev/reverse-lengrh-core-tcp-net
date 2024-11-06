package telran.appl.net;

import telran.view.*;
import telran.net.TcpClient;

public class Main {
    public static void main(String[] args) {
        InputOutput io = new StandardInputOutput();

        String host = io.readString("Enter hostname:");
        int port = io.readInt("Enter port:", "Invalid port");

        try (TcpClient client = new TcpClient(host, port)) {
            Menu menu = new Menu("Client Menu", getMenuItems(client));
            menu.perform(io);
        } catch (Exception e) {
            io.writeLine("Connection error: " + e.getMessage());
        }
    }

    private static Item[] getMenuItems(TcpClient client) {
        return new Item[]{
            Item.of("Reverse String", io -> {
                String input = io.readString("Enter any string:");
                String response = client.sendAndReceive("reverse", input);
                io.writeLine("Response from server: " + response);
            }),
            Item.of("Get Length", io -> {
                String input = io.readString("Enter any string:");
                String response = client.sendAndReceive("length", input);
                io.writeLine("Response from server: " + response);
            }),
            Item.ofExit()
        };
    }
}
