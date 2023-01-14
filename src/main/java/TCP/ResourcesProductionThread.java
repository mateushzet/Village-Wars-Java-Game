package TCP;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ResourcesProductionThread extends Thread{
    static Connection database;
    public ResourcesProductionThread(Connection con) {
        this.database = con;
    }

    @Override
    public void run() {
        while(true) {
            try {
                wait(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            increaseResources();
        }
    }

    static public void increaseResources() {
        try{
            String query = "UPDATE resources, building\n" +
                    "        SET resources.wood = resources.wood + (building.timbercamp_level * 10), resources.food = resources.food + (building.farm_level * 10), resources.stone = resources.stone + (building.mine_level*10)\n" +
                    "        WHERE resources.village_id = building.village_id;";

            PreparedStatement stm = database.prepareStatement(query);
            stm.executeUpdate();
        } catch (
                SQLException e) {
            System.out.println("Warning: setBuildings update failed!");
        }
    }
}
