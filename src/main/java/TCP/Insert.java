package TCP;

import java.sql.Connection;

public class Insert {

    public Connection database;

    public Insert(Connection database) {
        this.database = database;
    }


    static public void insertResult(Connection con, String name, int result) throws SQLException {
        String query = "INSERT INTO wyniki (imie, punkty) VALUES(?,?)";

        PreparedStatement stm = con.prepareStatement(query);
        stm.setString(1,name);
        stm.setInt(2,result);
        stm.executeUpdate();
    };

}
