package villagewars;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class App {
    public static void main(String[] args) {

        String[] tempArgs = new String[2];
        tempArgs[0] = "localhost";
        tempArgs[1] = "2234";
        Socket socket;

        int port = 0;
        port = Integer.parseInt(tempArgs[1]);

        try {
            socket = new Socket(InetAddress.getByName(tempArgs[0]),port);

            System.out.println("Oczekiwanie na polaczenie" + System.lineSeparator());

            //odbieranie od servera
            InputStreamReader in = new InputStreamReader(socket.getInputStream());
            BufferedReader bf = new BufferedReader(in);
            String question;

            //wysylanie do servera
            PrintWriter pw = new PrintWriter(socket.getOutputStream());


        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        //start GUI
        Main.main(args);

    }
}
