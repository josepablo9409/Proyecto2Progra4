package DAO;

import DataAccess.DataBase;
import Modelo.Category;
import Model.List.List_category;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAO_Categories {

    private final String read = "select * from category;";

    public DAO_Categories() {
    }

    public List_category read() {
        List_category list = new List_category();
        Statement st = null;
        ResultSet rs = null;
        DataBase db = DataBase.getInstance();
        try {
            st = db.getConnection().createStatement();
            rs = st.executeQuery(read);
            while (rs.next()) {
                list.add(new Category(
                        rs.getString(1),
                        rs.getFloat(2))
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Categories.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public static void main(String[] args) {
        DAO_Categories dao = new DAO_Categories();
        List_category lista = dao.read();
        lista.forEach(v -> System.out.println(v.getDescripcion()));
    }
}
