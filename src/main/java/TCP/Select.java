package TCP;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Select {

    static public Connection database;

    public Select(Connection database) {
        this.database = database;
    }

    public Select() {
    }

    static public String password(String nick) {
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

    static public int barracksLevel(int village_id){
        try {
            String query = "SELECT barracks_level FROM building WHERE village_id = ?";
            PreparedStatement stm = database.prepareStatement(query);
            stm.setInt(1,village_id);
            ResultSet result = stm.executeQuery();
            result.next();
            return result.getInt("barracks_level");
        } catch (SQLException e) {
            System.out.println("Warning: selectBarracksLevel query failed!");
            return 0;
        }
    }

    static public int farmLevel(int village_id){
        try {
            String query = "SELECT farm_level FROM building WHERE village_id = ?";
            PreparedStatement stm = database.prepareStatement(query);
            stm.setInt(1,village_id);
            ResultSet result = stm.executeQuery();
            result.next();
            return result.getInt("farm_level");
        } catch (SQLException e) {
            System.out.println("Warning: selectFarmLevel query failed!");
            return 0;
        }
    }

    static public int mineLevel(int village_id){
        try {
            String query = "SELECT mine_level FROM building WHERE village_id = ?";
            PreparedStatement stm = database.prepareStatement(query);
            stm.setInt(1,village_id);
            ResultSet result = stm.executeQuery();
            result.next();
            return result.getInt("mine_level");
        } catch (SQLException e) {
            System.out.println("Warning: selectMineLevel query failed!");
            return 0;
        }
    }

    static public int rathausLevel(int village_id){
        try {
            String query = "SELECT rathaus_level FROM building WHERE village_id = ?";
            PreparedStatement stm = database.prepareStatement(query);
            stm.setInt(1,village_id);
            ResultSet result = stm.executeQuery();
            result.next();
            return result.getInt("rathaus_level");
        } catch (SQLException e) {
            System.out.println("Warning: selectRathausLevel query failed!");
            return 0;
        }
    }

    static public int timberCampLevel(int village_id){
        try {
            String query = "SELECT timbercamp_level FROM building WHERE village_id = ?";
            PreparedStatement stm = database.prepareStatement(query);
            stm.setInt(1,village_id);
            ResultSet result = stm.executeQuery();
            result.next();
            return result.getInt("timbercamp_level");
        } catch (SQLException e) {
            System.out.println("Warning: selectTimberCampLevel query failed!");
            return 0;
        }
    }

    static public int wareHouseLevel(int village_id){
        try {
            String query = "SELECT warehouse_level FROM building WHERE village_id = ?";
            PreparedStatement stm = database.prepareStatement(query);
            stm.setInt(1,village_id);
            ResultSet result = stm.executeQuery();
            result.next();
            return result.getInt("warehouse_level");
        } catch (SQLException e) {
            System.out.println("Warning: selectWareHouseLevel query failed!");
            return 0;
        }
    }

    static public int quantityPikeman(int village_id){
        try {
            String query = "SELECT quantity_pikeman FROM soldiers WHERE village_id = ?";
            PreparedStatement stm = database.prepareStatement(query);
            stm.setInt(1,village_id);
            ResultSet result = stm.executeQuery();
            result.next();
            return result.getInt("quantity_pikeman");
        } catch (SQLException e) {
            System.out.println("Warning: selectQuantityPikeman query failed!");
            return 0;
        }
    }

    static public int quantitySwordsman(int village_id){
        try {
            String query = "SELECT quantity_swordsman FROM soldiers WHERE village_id = ?";
            PreparedStatement stm = database.prepareStatement(query);
            stm.setInt(1,village_id);
            ResultSet result = stm.executeQuery();
            result.next();
            return result.getInt("quantity_swordsman");
        } catch (SQLException e) {
            System.out.println("Warning: selectQuantitySwordsman query failed!");
            return 0;
        }
    }

    static public int quantityAxeman(int village_id){
        try {
            String query = "SELECT quantity_axeman FROM soldiers WHERE village_id = ?";
            PreparedStatement stm = database.prepareStatement(query);
            stm.setInt(1,village_id);
            ResultSet result = stm.executeQuery();
            result.next();
            return result.getInt("quantity_axeman");
        } catch (SQLException e) {
            System.out.println("Warning: selectQuantityAxeman query failed!");
            return 0;
        }
    }

    static public int villageOwner(int village_id){
        try {
            String query = "SELECT player_id FROM village WHERE village_id = ?";
            PreparedStatement stm = database.prepareStatement(query);
            stm.setInt(1,village_id);
            ResultSet result = stm.executeQuery();
            result.next();
            return result.getInt("player_id");
        } catch (SQLException e) {
            System.out.println("Warning: selectVillageOwner query failed!");
            return 0;
        }
    }

    static public int playerID(String nickname){
        try {
            String query = "SELECT player_id FROM player WHERE nickname = ?";
            PreparedStatement stm = database.prepareStatement(query);
            stm.setString(1,nickname);
            ResultSet result = stm.executeQuery();
            result.next();
            return result.getInt("player_id");
        } catch (SQLException e) {
            System.out.println("Warning: selectPlayerID query failed!");
            return 0;
        }
    }

    static public int villageID(int player_id){
        try {
            String query = "SELECT village_id FROM village WHERE player_id = ?";
            PreparedStatement stm = database.prepareStatement(query);
            stm.setInt(1,player_id);
            ResultSet result = stm.executeQuery();
            result.next();
            return result.getInt("village_id");
        } catch (SQLException e) {
            System.out.println("Warning: selectVillageID query failed!");
            return 0;
        }
    }

    static public int foodQuantity(int village_id){
        try {
            String query = "SELECT food FROM resources WHERE village_id = ?";
            PreparedStatement stm = database.prepareStatement(query);
            stm.setInt(1,village_id);
            ResultSet result = stm.executeQuery();
            result.next();
            return result.getInt("food");
        } catch (SQLException e) {
            System.out.println("Warning: selectFoodQuantity query failed!");
            return 0;
        }
    }

    static public int woodQuantity(int village_id){
        try {
            String query = "SELECT wood FROM resources WHERE village_id = ?";
            PreparedStatement stm = database.prepareStatement(query);
            stm.setInt(1,village_id);
            ResultSet result = stm.executeQuery();
            result.next();
            return result.getInt("wood");
        } catch (SQLException e) {
            System.out.println("Warning: selectWoodQuantity query failed!");
            return 0;
        }
    }

    static public int stoneQuantity(int village_id){
        try {
            String query = "SELECT stone FROM resources WHERE village_id = ?";
            PreparedStatement stm = database.prepareStatement(query);
            stm.setInt(1,village_id);
            ResultSet result = stm.executeQuery();
            result.next();
            return result.getInt("stone");
        } catch (SQLException e) {
            System.out.println("Warning: selectStoneQuantity query failed!");
            return 0;
        }
    }



}
