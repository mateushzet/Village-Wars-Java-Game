package TCP;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ServerTCP {
    public static void main(String args[]) {
        String[] tempArgs = new String[1];
        tempArgs[0] = "2234";
        final int MAX_PLAYERS_CAPACITY = 1000;

        if (tempArgs.length == 0)
            System.out.println("Wprowadz numer portu, na ktorym" + "serwer bpdzie oczekiwai na graczy");
        else {
            int port = 0;
            try {
                port = Integer.parseInt(tempArgs[0]);
            }catch (NumberFormatException e) {
                System.err.println("Wprowadz poprawny numer portu: " + e);
                return;
            }

            try(ServerSocket serverSocket = new ServerSocket(port)) {
                int i = 0;
                while (true) {
                    if(ServerTCPThread.connectedClients < MAX_PLAYERS_CAPACITY) {
                        ServerTCPThread thread = new ServerTCPThread(serverSocket.accept());
                        i++;
                        ServerTCPThread.connectedClients++;
                        System.out.println("polaczono klienta nr: " + i);
                        thread.start();
                    }else System.out.println("Wszystkie miejsca zajete");
                }

            }catch (Exception e)
            { System.err.println(e); }
        }
    }
}

