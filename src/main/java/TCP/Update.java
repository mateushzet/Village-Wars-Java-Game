package TCP;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Update {
    public Connection database;

    public Update(Connection database) {
        this.database = database;
    }

    public void setResources(int food, int wood, int stone, int village_id)throws SQLException {

            String query = "UPDATE resources SET food = ?, wood = ?, stone = ? WHERE village_id = ?";

            PreparedStatement stm = database.prepareStatement(query);
            stm.setInt(1,food);
            stm.setInt(2,wood);
            stm.setInt(3,stone);
            stm.setInt(4,village_id);
            stm.executeUpdate();
        };
    public void incrementResources(int food, int wood, int stone, int village_id)throws SQLException {

        String query = "UPDATE resources SET food = food + ?, wood = wood + ?, stone = stone + ? WHERE village_id = ?";

        PreparedStatement stm = database.prepareStatement(query);
        stm.setInt(1,food);
        stm.setInt(2,wood);
        stm.setInt(3,stone);
        stm.setInt(4,village_id);
        stm.executeUpdate();
    };
    public void setSoldiers(int pikeman, int swordsman, int axeman, int village_id)throws SQLException {

        String query = "UPDATE soldiers SET quantity_pikeman = ?, quantity_swordsman = ?, quantity_axeman = ? WHERE village_id = ?";

        PreparedStatement stm = database.prepareStatement(query);
        stm.setInt(1,pikeman);
        stm.setInt(2,swordsman);
        stm.setInt(3,axeman);
        stm.setInt(4,village_id);
        stm.executeUpdate();
    };
    public void incrementSoldiers(int pikeman, int swordsman, int axeman, int village_id)throws SQLException {

        String query = "UPDATE soldiers SET quantity_pikeman = quantity_pikeman + ?, quantity_swordsman = quantity_swordsman + ?, quantity_axeman = quantity_axeman + ? WHERE village_id = ?";

        PreparedStatement stm = database.prepareStatement(query);
        stm.setInt(1,pikeman);
        stm.setInt(2,swordsman);
        stm.setInt(3,axeman);
        stm.setInt(4,village_id);
        stm.executeUpdate();
    };
    public void incrementBuildings(int rathaus, int warehouse, int barracks, int farm, int mine, int timbercamp)throws SQLException {

        String query = "UPDATE building SET rathaus_level = rathaus_level + ?,  warehouse_level = warehouse_level + ?, barracks_level = barracks_level + ?, farm_level = farm_level + ?," +
                " mine_level = mine_level + ?, timbercamp_level = timbercamp_level + ? WHERE village_id = ?";

        PreparedStatement stm = database.prepareStatement(query);
        stm.setInt(1,rathaus);
        stm.setInt(2,warehouse);
        stm.setInt(3,barracks);
        stm.setInt(4,farm);
        stm.setInt(5,mine);
        stm.setInt(6,timbercamp);
        stm.executeUpdate();
    };
    public void setBuildings(int rathaus, int warehouse, int barracks, int farm, int mine, int timbercamp)throws SQLException {

        String query = "UPDATE building SET rathaus_level =  ?,  warehouse_level = ?, barracks_level = ?, farm_level = ?," +
                " mine_level = ?, timbercamp_level = ? WHERE village_id = ?";

        PreparedStatement stm = database.prepareStatement(query);
        stm.setInt(1,rathaus);
        stm.setInt(2,warehouse);
        stm.setInt(3,barracks);
        stm.setInt(4,farm);
        stm.setInt(5,mine);
        stm.setInt(6,timbercamp);
        stm.executeUpdate();
    };
}
