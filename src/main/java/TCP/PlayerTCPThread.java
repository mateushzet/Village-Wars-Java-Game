package TCP;

import villagewars.game.player.Player;
import villagewars.game.village.Village;

import java.io.*;
import java.net.Socket;
import java.sql.Connection;
import java.util.Scanner;

public class PlayerTCPThread extends Thread{
    private Socket mySocket;
    static int connectedClients = 0;
    public int villageID;
    public Connection database;
    public Select select;
    public Insert insert;
    public Update update;

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

            //odbieranie od klienta
            InputStreamReader in = new InputStreamReader(mySocket.getInputStream());
            BufferedReader bf = new BufferedReader(in);
            String clientMethod;

            //przesylanie do klienta
            PrintWriter pw = new PrintWriter(mySocket.getOutputStream());

//----------------TODO testy do usuniecia
//            Player a = new Player("admin","password",database);
//            Player b = new Player("kamil","piesek",database);
//            a.village.attackVillage(b.village);
//            System.out.println("po bitwie");

            String output;
            String nickname = new String();
            String password = new String();
            Player loggedPlayer = null;
            boolean notLogged = true;


            // login or registration
            while (notLogged){
                while ((output = bf.readLine()) == null){}
                    if(output.equals("login")) {
                        pw.println("sendMeLogin");
                        pw.flush();

                        while ((output = bf.readLine()) == null) {}
                        nickname = output;
                        pw.println("sendMePassword");
                        pw.flush();

                        while ((output = bf.readLine()) == null) {
                        }
                        password = output;
                        loggedPlayer = loadPlayer(nickname, password, database);
                        villageID = loggedPlayer.getVillageID();
                        if (loggedPlayer != null) {
                            notLogged = false;
                            System.out.println("zalogowano");
                        } else System.out.println("Info: wrong login input");
                    }else if(output.equals("registration")) {

                        pw.println("sendMeLogin");
                        pw.flush();

                        while ((output = bf.readLine()) == null) {}

                        if(select.checkNicknameRegistration(output)) {
                            nickname = output;
                            pw.println("sendMePassword");
                            pw.flush();

                            while ((output = bf.readLine()) == null) {}
                            password = output;

                            insert.player(password, nickname);
                            int tempPlayerID = select.playerID(nickname);
                            int tempVillageID = select.villageID(tempPlayerID);
                            insert.building(tempVillageID);
                            insert.resources(tempVillageID);
                            insert.soldiers(tempVillageID);

                            loggedPlayer = loadPlayer(nickname, password, database);
                            villageID = loggedPlayer.getVillageID();

                            if (loggedPlayer != null) {
                                notLogged = false;
                                System.out.println("Info: zarejestrowano");
                            } else System.out.println("Info: wrong registration input");
                       }

                    }else{
                        System.out.println("Warning: requested query while not loged");
                        pw.println("false");
                        pw.flush();
                    }
            }
            pw.println("true");
            pw.flush();




            Update.incrementResources(1000,1000,1000, villageID);


            // RMI listener - server
            while(true){
                while ((clientMethod = bf.readLine()) == null){}

                output = new String();
                int numberOutput;

                switch(clientMethod){
                    case "getWoodProduction":
                        output = Integer.toString(getWoodProduction(villageID));
                        pw.println(output);
                        pw.flush();
                        break;

                    case "getFoodProduction":
                        output = Integer.toString(getFoodProduction(villageID));
                        pw.println(output);
                        pw.flush();
                        break;

                    case "getStoneProduction":
                        output = Integer.toString(getStoneProduction(villageID));
                        pw.println(output);
                        pw.flush();
                        break;

                    case "getWood":
                        output = Integer.toString(select.woodQuantity(villageID));
                        pw.println(output);
                        pw.flush();
                        break;

                    case "getFood":
                        output = Integer.toString(select.foodQuantity(villageID));
                        pw.println(output);
                        pw.flush();
                        break;

                    case "getStone":
                        output = Integer.toString(select.stoneQuantity(villageID));
                        pw.println(output);
                        pw.flush();
                        break;

                    case "quantityPikeman":
                        output = Integer.toString(select.quantityPikeman(villageID));
                        pw.println(output);
                        pw.flush();
                        break;

                    case "quantitySwordsman":
                        output = Integer.toString(select.quantitySwordsman(villageID));
                        pw.println(output);
                        pw.flush();
                        break;

                    case "quantityAxeman":
                        output = Integer.toString(select.quantityAxeman(villageID));
                        pw.println(output);
                        pw.flush();
                        break;

                    case "barracksLevel":
                        output = Integer.toString(select.barracksLevel(villageID));
                        pw.println(output);
                        pw.flush();
                        break;

                    case "farmLevel":
                        output = Integer.toString(select.farmLevel(villageID));
                        pw.println(output);
                        pw.flush();
                        break;

                    case "mineLevel":
                        output = Integer.toString(select.mineLevel(villageID));
                        pw.println(output);
                        pw.flush();
                        break;

                    case "rathausLevel":
                        output = Integer.toString(select.rathausLevel(villageID));
                        pw.println(output);
                        pw.flush();
                        break;

                    case "timberCampLevel":
                        output = Integer.toString(select.timberCampLevel(villageID));
                        pw.println(output);
                        pw.flush();
                        break;

                    case "wareHouseLevel":
                        output = Integer.toString(select.wareHouseLevel(villageID));
                        pw.println(output);
                        pw.flush();
                        break;

                    case "recruitPikeman":
                        loggedPlayer.village.getBarracks().recruitPikeman(1);
                        break;

                    case "recruitSwordsman":
                        loggedPlayer.village.getBarracks().recruitSwordsman(1);
                        break;

                    case "recruitAxeman":
                        loggedPlayer.village.getBarracks().recruitAxeman(1);
                        break;

                    case "incrementBarracks":
                        loggedPlayer.village.getRathaus().levelUp("barracks");
                        break;

                    case "incrementFarm":
                        loggedPlayer.village.getRathaus().levelUp("farm");
                        break;

                    case "incrementMine":
                        loggedPlayer.village.getRathaus().levelUp("mine");
                        break;

                    case "incrementRathaus":
                        loggedPlayer.village.getRathaus().levelUp("rathaus");
                        break;

                    case "incrementTimberCamp":
                        loggedPlayer.village.getRathaus().levelUp("timbercamp");
                        break;

                    case "incrementWareHouse":
                        loggedPlayer.village.getRathaus().levelUp("warehouse");
                        break;

                    case "getNickname":
                        output = loggedPlayer.getNickname();
                        pw.println(output);
                        pw.flush();
                        break;

                    case "getPlayerID":
                        output = String.valueOf( loggedPlayer.getPlayerID());
                        pw.println(output);
                        pw.flush();
                        break;

                    case "getDefencePower":
                        numberOutput = loggedPlayer.village.getBarracks().calculateDefencePower();
                        pw.println(numberOutput);
                        pw.flush();
                        break;

                    case "getAttackPower":
                        numberOutput = loggedPlayer.village.getBarracks().calculateAttackPower();
                        pw.println(numberOutput);
                        pw.flush();
                        break;

                    case "getDefencePowerByVillageID":
                        pw.println("sendMeVillageID");
                        pw.flush();
                        while (true){
                            try { if (!((output = bf.readLine()) == null)) break;
                            } catch (IOException e) {throw new RuntimeException(e);}
                        }
                        numberOutput = loggedPlayer.village.getBarracks().calculateDefencePowerByVillageID(Integer.parseInt(output));
                        pw.println(numberOutput);
                        pw.flush();
                        break;

                    case "getAttackPowerByVillageID":
                        pw.println("sendMeVillageID");
                        pw.flush();
                        while (true){
                            try { if (!((output = bf.readLine()) == null)) break;
                            } catch (IOException e) {throw new RuntimeException(e);}
                        }
                        numberOutput = loggedPlayer.village.getBarracks().calculateAttackPowerByVillageID(Integer.parseInt(output));
                        pw.println(numberOutput);
                        pw.flush();
                        break;

                    case "neededResourcesToBuild":

                        pw.println("sendMeBuildingLevel");
                        pw.flush();

                        while (true){
                            try { if (!((output = bf.readLine()) == null)) break;
                            } catch (IOException e) {throw new RuntimeException(e);}
                        }

                        numberOutput = Integer.parseInt(output) * Integer.parseInt(output) * 100;
                        pw.println(numberOutput);
                        pw.flush();
                        break;

                    case "getMaxID":
                        output = String.valueOf(Select.getMaxID());
                        pw.println(output);
                        pw.flush();
                        break;

                    case "getVillageID":
                        while (true){
                            try { if (!((output = bf.readLine()) == null)) break;
                            } catch (IOException e) {throw new RuntimeException(e);}
                        }
                        pw.println("sendMePlayerID");
                        pw.flush();
                        while (true){
                            try { if (!((output = bf.readLine()) == null)) break;
                            } catch (IOException e) {throw new RuntimeException(e);}
                        }
                        int temp = Integer.parseInt(output);
                        output =  String.valueOf(Select.villageID(temp));
                        pw.println(output);
                        pw.flush();
                        break;

                    case "attackPlayer":
                        pw.println("sendMeVillageID");
                        pw.flush();
                        while (true){
                            try { if (!((output = bf.readLine()) == null)) break;
                            } catch (IOException e) {throw new RuntimeException(e);}
                        }
                        Village defender = loadPlayerByVillageID(Integer.parseInt(output), database);
                        loggedPlayer.village.attackVillage(defender);
                        break;
                }
            }

//----------------TODO:

//            pw.close();
//            bf.close();
//
//            mySocket.close();
//            connectedClients--;

        }catch (Exception e){
            System.err.println(e);
        }
    }


    private boolean checkPassword(String nick, String password){
        boolean result = password.equals(select.password(nick));
        return result;
    }


    private Player loadPlayer(String nick, String password, Connection con){
        if(checkPassword(nick, password)) {
            Player player = new Player(nick, password, con);
            System.out.println("Information: User \""+nick+"\" has been successfully logged in.");
            return player;
        }else {
            System.out.println("Information: Login failed for \""+nick+"\" user.");
            return null;
        }

    }

    private Village loadPlayerByVillageID(int villageID, Connection con){
        int temp = Select.villageOwner(villageID);
            Player player = new Player(villageID, temp, con);
            return player.village;
        }


    private int getWoodProduction(int village_id){
        return select.timberCampLevel(village_id)*10;
    }

    private int getFoodProduction(int village_id){
        return select.farmLevel(village_id)*10;
    }

    private int getStoneProduction(int village_id){
        return select.mineLevel(village_id)*10;
    }
}
