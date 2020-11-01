package DAO;

import DataAccess.DataBase;

import Modelo.Category;
import Modelo.ListProduct;
import Modelo.Producto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAO_Product {

    private final String c = "insert into eif209_2020_p01.product values(0,?,?,?,?);";
    private final String r = "select p.idProduct,p.detail,p.price,c.category,c.iva from eif209_2020_p01.product p inner join "
            + "category c on p.category=c.category and owner=?;";
    private final String u = "update eif209_2020_p01.product set detail=?,price=?,";
    private final String d = "";
    private final String findById = "select p.idProduct,p.detail,p.price,c.category,c.iva from eif209_2020_p01.product p inner join "
            + "category c on p.category=c.category and p.idProduct=?;";

    public boolean create(Producto p, String owner) {
        DataBase bd = DataBase.getInstance();
        ResultSet rs = null;
        try {
            PreparedStatement ps = bd.getConnection().prepareStatement(this.c, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, p.getDetail());
            ps.setFloat(2, p.getPrice());
            ps.setString(3, p.getCategory().getDescripcion());
            ps.setString(4, owner);
            if (ps.executeUpdate() > 0) {
                rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    p.setId(rs.getInt(1));
                }
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Product.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public ListProduct read(String owner) {
        PreparedStatement ps = null;
        DataBase db = DataBase.getInstance();
        ResultSet rs = null;
        ListProduct lista = new ListProduct();
        try {
            ps = db.getConnection().prepareStatement(this.r);
            ps.setString(1, owner);
            rs = ps.executeQuery();
            while (rs.next()) {
                lista.add(new Producto(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getFloat(3),
                        new Category(
                                rs.getString(4),
                                rs.getFloat(5))
                ));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Product.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (lista.isEmpty()) {
            return null;
        }
        return lista;
    }

    public boolean update(Producto p) {
        return true;
    }

    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Producto findById(int id) {
        PreparedStatement ps = null;
        DataBase db = DataBase.getInstance();
        ResultSet rs = null;
        Producto producto = null;
        try {
            ps = db.getConnection().prepareStatement(this.findById);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                producto = new Producto(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getFloat(3),
                        new Category(
                                rs.getString(4),
                                rs.getFloat(5))
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Product.class.getName()).log(Level.SEVERE, null, ex);
        }
        return producto;
    }

}
