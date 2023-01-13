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


            System.out.println(getWoodProduction());
            System.out.println(getFoodProduction());
            System.out.println(getStoneProduction());

            System.out.println(getWood());
            System.out.println(getFood());
            System.out.println(getStone());

            System.out.println(quantityPikeman());
            System.out.println(quantitySwordsman());
            System.out.println(quantityAxeman());

            System.out.println(barracksLevel());
            System.out.println(farmLevel());
            System.out.println(mineLevel());
            System.out.println(rathausLevel());
            System.out.println(timberCampLevel());
            System.out.println(wareHouseLevel());

        //start GUI
        Main.main(args);

    }

    //---------------- Select methods

    static String getWoodProduction(){
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

    static String getFoodProduction(){
        try {

            String output;
            pw.println("getFoodProduction");
            pw.flush();
            while ((output = bf.readLine()) == null){}
            return output;

        }catch (IOException e) {
            return "NaN";
        }
    }

    static String getStoneProduction(){
        try {

            String output;
            pw.println("getStoneProduction");
            pw.flush();
            while ((output = bf.readLine()) == null){}
            return output;

        }catch (IOException e) {
            return "NaN";
        }
    }

    static String getWood(){
        try {

            String output;
            pw.println("getWood");
            pw.flush();
            while ((output = bf.readLine()) == null){}
            return output;

        }catch (IOException e) {
            return "NaN";
        }
    }

    static String getFood(){
        try {

            String output;
            pw.println("getFood");
            pw.flush();
            while ((output = bf.readLine()) == null){}
            return output;

        }catch (IOException e) {
            return "NaN";
        }
    }

    static String getStone(){
        try {

            String output;
            pw.println("getStone");
            pw.flush();
            while ((output = bf.readLine()) == null){}
            return output;

        }catch (IOException e) {
            return "NaN";
        }
    }

    static String quantityPikeman(){
        try {

            String output;
            pw.println("quantityPikeman");
            pw.flush();
            while ((output = bf.readLine()) == null){}
            return output;

        }catch (IOException e) {
            return "NaN";
        }
    }

    static String quantitySwordsman(){
        try {

            String output;
            pw.println("quantitySwordsman");
            pw.flush();
            while ((output = bf.readLine()) == null){}
            return output;

        }catch (IOException e) {
            return "NaN";
        }
    }

    static String quantityAxeman(){
        try {

            String output;
            pw.println("quantityAxeman");
            pw.flush();
            while ((output = bf.readLine()) == null){}
            return output;

        }catch (IOException e) {
            return "NaN";
        }
    }

    static String barracksLevel(){
        try {

            String output;
            pw.println("barracksLevel");
            pw.flush();
            while ((output = bf.readLine()) == null){}
            return output;

        }catch (IOException e) {
            return "NaN";
        }
    }

    static String farmLevel(){
        try {

            String output;
            pw.println("farmLevel");
            pw.flush();
            while ((output = bf.readLine()) == null){}
            return output;

        }catch (IOException e) {
            return "NaN";
        }
    }

    static String mineLevel(){
        try {

            String output;
            pw.println("mineLevel");
            pw.flush();
            while ((output = bf.readLine()) == null){}
            return output;

        }catch (IOException e) {
            return "NaN";
        }
    }

    static String rathausLevel(){
        try {

            String output;
            pw.println("rathausLevel");
            pw.flush();
            while ((output = bf.readLine()) == null){}
            return output;

        }catch (IOException e) {
            return "NaN";
        }
    }

    static String timberCampLevel(){
        try {

            String output;
            pw.println("timberCampLevel");
            pw.flush();
            while ((output = bf.readLine()) == null){}
            return output;

        }catch (IOException e) {
            return "NaN";
        }
    }

    static String wareHouseLevel(){
        try {

            String output;
            pw.println("wareHouseLevel");
            pw.flush();
            while ((output = bf.readLine()) == null){}
            return output;

        }catch (IOException e) {
            return "NaN";
        }
    }

    //------------- Update methods

    static boolean recruitPikeman(){
        try {
            boolean output;
            String serverOutput = new String();
            pw.println("recruitPikeman");
            pw.flush();
            while ((serverOutput = bf.readLine()) == null){}
            output = (serverOutput.equals("true")) ? true : false;
            return output;
        }catch (IOException e) {
            return false;
        }
    }


}
