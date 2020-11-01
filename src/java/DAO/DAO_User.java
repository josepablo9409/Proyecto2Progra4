package DAO;

import DataAccess.DataBase;
import Model.List.List_Users;
import Modelo.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAO_User {

    private final String c = "insert into user(idUser,password) values(?,?);";
    private final String r = "select * from user;";
    //update only password
    private final String u = "update user set password=? where idUser=?;";
    private final String d = "delete from user where idUser=?;";
    private final String s = "select * from user where idUser=? and password=?;";
    private final String changeStatus = "update user set status=? where idUser = ?;";

    public boolean create(User u) throws SQLException {
        PreparedStatement ps = null;
        DataBase db = DataBase.getInstance();
        ps = db.getConnection().prepareStatement(this.c);
        ps.setString(1, u.getUser());
        ps.setString(2, u.getPass());
        if (ps.executeUpdate() > 0) {
            return true;
        }
        return false;
    }

    public List_Users read() {
        List<User> list = new ArrayList<>();
        Statement st = null;
        DataBase db = DataBase.getInstance();
        ResultSet rs = null;
        try {
            st = db.getConnection().createStatement();
            rs = st.executeQuery(this.r);
            while (rs.next()) {
                list.add(new User(
                        rs.getString("idUser"),
                        rs.getString("password"),
                        rs.getInt("status"),
                        rs.getInt("rol")
                ));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO_User.class.getName()).log(Level.SEVERE, null, ex);
        }
        List_Users usuarios = new List_Users(list);
        return usuarios;
    }

    public boolean update(User u) {
        PreparedStatement ps = null;
        DataBase db = DataBase.getInstance();
        try {
            ps = db.getConnection().prepareStatement(this.u);
            ps.setString(1, u.getPass());
            ps.setString(2, u.getUser());
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO_User.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean delete(String u) {
        PreparedStatement ps = null;
        DataBase db = DataBase.getInstance();
        try {
            ps = db.getConnection().prepareStatement(this.d);
            ps.setString(1, u);
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO_User.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public User validate(String u, String pass) {
        PreparedStatement ps = null;
        DataBase db = DataBase.getInstance();
        ResultSet rs = null;
        User user = null;
        try {
            ps = db.getConnection().prepareStatement(this.s);
            ps.setString(1, u);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            if (rs.next()) {
                user = new User(
                        rs.getString("idUser"),
                        rs.getString("password"),
                        rs.getInt("status"),
                        rs.getInt("rol"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO_User.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }

    public boolean changeStatus(String user, int status) {
        PreparedStatement ps = null;
        DataBase db = DataBase.getInstance();
        try {
            ps = db.getConnection().prepareStatement(this.changeStatus);
            ps.setInt(1, status);
            ps.setString(2, user);
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO_User.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

}
