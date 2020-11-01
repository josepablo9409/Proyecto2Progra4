package DataAccess;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataBase {

    private Connection con;
    private Properties prop;
    private static DataBase bd;
    private final String propURL = "properties.properties";

    private DataBase() {
        try {
            prop = new Properties();
            prop.load(getClass().getResourceAsStream(propURL));
            Class.forName(prop.getProperty("database_driver"));
            con = DriverManager.getConnection(getURLCnx(), prop.getProperty("user"), prop.getProperty("pass"));
        } catch (IOException | SQLException | ClassNotFoundException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static DataBase getInstance() {
        if (bd == null) {
            bd = new DataBase();
        }
        return bd;
    }

    public String getURLCnx() {
        return String.format("%s//%s/%s", prop.getProperty("protocol"),
                prop.getProperty("server_url"), prop.getProperty("database")) + "?serverTimezone=UTC";
    }

    public Connection getConnection() {
        return con;
    }

    public void closeConnection() {
        if (this.con != null) {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void main(String[] args) {
        DataBase bd = DataBase.getInstance();
        Connection c = bd.getConnection();
        try {
            Statement st = c.createStatement();
            st.execute("insert into identification values(1,'hola bb')");
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
