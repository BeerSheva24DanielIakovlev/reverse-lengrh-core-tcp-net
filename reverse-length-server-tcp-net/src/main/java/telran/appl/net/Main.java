package telran.appl.net;

import telran.net.TcpServer;

public class Main {
    public static void main(String[] args) {
        ReverseLengthProtocol protocol = new ReverseLengthProtocol();
        TcpServer server = new TcpServer(protocol, 6000);
        server.run();
    }
}
