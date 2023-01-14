package TCP;

import java.net.ServerSocket;
import java.sql.Connection;

public class ConnectingClientsThread extends Thread{

    ServerSocket serverSocket;
    final int MAX_PLAYERS_CAPACITY = 7;

    Connection con;

    public ConnectingClientsThread(ServerSocket serverSocket, Connection con) {
        super();
        this.serverSocket = serverSocket;
        this.con = con;
    }

    public void run() {
        int i = 0;
        while (!serverSocket.isClosed()) {
            try {
                if (PlayerTCPThread.connectedClients < MAX_PLAYERS_CAPACITY) {
                    PlayerTCPThread thread = new PlayerTCPThread(serverSocket.accept(), con);
                    i++;
                    PlayerTCPThread.connectedClients++;
                    System.out.println("polaczono klienta nr: " + i);
                    thread.start();
                } else System.out.println("Wszystkie miejsca zajete");
            } catch (Exception e) {
                System.err.println(e);
            }
        }
    }

}
