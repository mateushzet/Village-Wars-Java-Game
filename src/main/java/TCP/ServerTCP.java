package TCP;

import java.net.ServerSocket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class ServerTCP {
    public static void main(String args[]) throws SQLException {

        String url = "jdbc:mariadb://localhost:3306/village_wars";
        String user = "root";
        String pwd = "password";
        Connection con = DriverManager.getConnection(url,user,pwd);

        Integer port = 2234;

        try(ServerSocket serverSocket = new ServerSocket(port)) {

            //start resources production
            ResourcesProductionThread resourcesProductionThread = new ResourcesProductionThread(con);
            resourcesProductionThread.start();


            ConnectingClientsThread connectingClientsThread = new ConnectingClientsThread(serverSocket, con);
            connectingClientsThread.start();

            String consoleInput = new String();
            Scanner in = new Scanner(System.in);

            while(!consoleInput.equals("stop")){
                consoleInput = in.next();
            }
            connectingClientsThread.interrupt();
            serverSocket.close();
            }catch (Exception e)
            { System.err.println(e);}
        }
    }


