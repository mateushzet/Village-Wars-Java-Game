package TCP;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Insert {

    private Select select;
    static public Connection database;
    public Insert(Connection database) {
        this.database = database;
        select = new Select(database);
    }

    public void village(int player_id) {
        try {
            String query = "INSERT INTO village (player_id) VALUES(?)";

            PreparedStatement stm = database.prepareStatement(query);
            stm.setInt(1, player_id);
            stm.executeUpdate();
        } catch (
                SQLException e) {
            System.out.println("Warning: new village insert failed!");
        }
    }

     public void player(String password, String nickname) {
         try {
             String query = "INSERT INTO player (password, nickname) VALUES(?,?)";

             PreparedStatement stm = database.prepareStatement(query);
             stm.setString(1, password);
             stm.setString(2, nickname);
             stm.executeUpdate();
             int playerID = select.playerID(nickname);
             village(playerID);
         } catch (
                 SQLException e) {
             System.out.println("Warning: new player insert failed!");
         }
     }


    public void building(int village_id) {
        try {
            String query = "INSERT INTO building (village_id, rathaus_level, warehouse_level, barracks_level, farm_level, mine_level, timbercamp_level) VALUES(?, 1, 1, 1, 1, 1, 1)";

            PreparedStatement stm = database.prepareStatement(query);
            stm.setInt(1, village_id);
            stm.executeUpdate();
        } catch (
                SQLException e) {
            System.out.println("Warning: new buildings insert failed!");
        }
    }

    public void resources(int village_id) {
        try {
            String query = "INSERT INTO resources (village_id, food, wood ,stone) VALUES(?, 0, 0, 0)";

            PreparedStatement stm = database.prepareStatement(query);
            stm.setInt(1, village_id);
            stm.executeUpdate();
        } catch (
                SQLException e) {
            System.out.println("Warning: new resources insert failed!");
        }
    }

    public void soldiers(int village_id) {
        try {
            String query = "INSERT INTO soldiers (village_id, quantity_pikeman, quantity_swordsman , quantity_axeman) VALUES(?, 5, 0, 0)";

            PreparedStatement stm = database.prepareStatement(query);
            stm.setInt(1, village_id);
            stm.executeUpdate();
        } catch (
                SQLException e) {
            System.out.println("Warning: new soldiers insert failed!");
        }
    }

}
