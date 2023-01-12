package villagewars;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class App {

    static PrintWriter pw;

    static String host = "localhost";
    static Integer port = 2234;

    static Socket socket;

    static InputStreamReader in;
    static BufferedReader bf;

    public App() throws IOException {}

    public static void main(String[] args) throws IOException {

        socket = new Socket(InetAddress.getByName(host),port);

        //wysylanie do servera
        pw = new PrintWriter(socket.getOutputStream());

        //odbieranie od servera
        in = new InputStreamReader(socket.getInputStream());
        bf = new BufferedReader(in);

            System.out.println("Oczekiwanie na polaczenie" + System.lineSeparator());


            System.out.println(getWood());

        //start GUI
        Main.main(args);

    }

    static String getWood(){
        try {

            String output;
            pw.println("getWoodProduction");
            pw.flush();
            while ((output = bf.readLine()) == null){}
                return output;

        }catch (IOException e) {
            return "NaN";
        }
    }

}
