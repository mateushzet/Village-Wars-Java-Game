package TCP;

import villagewars.game.player.Player;

import java.io.*;
import java.net.Socket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PlayerTCPThread extends Thread{
    Socket mySocket;
    static int connectedClients = 0;

    public Connection database;

    public PlayerTCPThread(Socket socket, Connection con) {
        super();
        mySocket = socket;
        database = con;
    }

    public void run() {
        try{

            loadPlayer("admin", "password");

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
        boolean result = password.equals(selectPassword(nick));
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


    public String selectPassword(String nick) {
        String error = "selectPassword_ERROR";
        try {
        String query = "SELECT password FROM player WHERE nickname = ?";
        PreparedStatement stm = null;
        stm = database.prepareStatement(query);
        stm.setString(1,nick);
        ResultSet result = stm.executeQuery();
        result.next();
        String password = new String();
        password = result.getString("password");
        return password;
    } catch (SQLException e) {
            System.out.println("Warning: selectPassword query failed!");
            return error;
        }
    }

}
