package TCP;

import java.io.*;
import java.net.Socket;
import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

public class ServerTCPThread extends Thread{
    Socket mySocket;
    static int connectedClients = 0;
    int questionCount = 0;

    public ServerTCPThread(Socket socket)
    {
        super();
        mySocket = socket;
    }

    public void run()
    {
        try{
            //przesylanie do klienta
            PrintWriter pw = new PrintWriter(mySocket.getOutputStream());

            //odbieranie od klienta
            InputStreamReader in = new InputStreamReader(mySocket.getInputStream());
            BufferedReader bf = new BufferedReader(in);


            pw.close();
            bf.close();

            mySocket.close();
            connectedClients--;

        }catch (Exception e){
            System.err.println(e);
        }
    }
}
