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
    private Insert insert;
    private Update update;

    public PlayerTCPThread(Socket socket, Connection con) {
        super();
        mySocket = socket;
        database = con;
        select = new Select(database);
        insert = new Insert(database);
        update = new Update(database);
    }


    public void run() {
        try{

            loadPlayer("admin", "password");

//            System.out.println(
//                    select.barracksLevel(1) +"|"+
//                            select.farmLevel(1)+"|"+
//                            select.mineLevel(1)+"|"+
//                            select.rathausLevel(1)+"|"+
//                            select.timberCampLevel(1)+"|"+
//                            select.wareHouseLevel(1)+"|"+
//                            select.quantityPikeman(1)+"|"+
//                            select.quantitySwordsman(1)+"|"+
//                            select.quantityAxeman(1)+"|"+
//                            select.villageOwner(1)+"|"+
//                            select.playerID("admin")+"|"+
//                            select.villageID(1)+"|"+
//                            select.foodQuantity(1)+"|"+
//                            select.woodQuantity(1)+"|"+
//                            select.stoneQuantity(1)+"|"
//            );



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
