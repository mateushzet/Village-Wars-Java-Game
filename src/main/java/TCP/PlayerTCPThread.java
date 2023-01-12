package TCP;

import villagewars.game.player.Player;
import java.io.*;
import java.net.Socket;
import java.sql.Connection;

public class PlayerTCPThread extends Thread{
    private Socket mySocket;
    static int connectedClients = 0;

    private Connection database;
    private Select select;

    public PlayerTCPThread(Socket socket, Connection con) {
        super();
        mySocket = socket;
        database = con;
        select = new Select(database);
    }


    public void run() {
        try{

            loadPlayer("admin", "password");
            System.out.println("Poziom baraku: " + select.barracksLevel(1));

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


    public boolean checkPassword(String nick, String password){
        boolean result = password.equals(select.password(nick));
        return result;
    }


    public void loadPlayer(String nick, String password){
        if(checkPassword(nick, password)) {
            Player player = new Player(nick, password);
            System.out.println("Information: User \""+nick+"\" has been successfully logged in.");
        }else {
            System.out.println("Information: Login failed for \""+nick+"\" user.");
        }
    }

    public int getWoodProduction(int village_id){
        return select.timberCampLevel(village_id)*10;
    }

    public int getFoodProduction(int village_id){
        return select.farmLevel(village_id)*10;
    }

    public int getStoneProduction(int village_id){
        return select.mineLevel(village_id)*10;
    }
}
