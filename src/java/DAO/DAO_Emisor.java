package DAO;

import DataAccess.DataBase;
import Modelo.Emisor;
import Modelo.Ubication;
import Modelo.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAO_Emisor {

    private final String create = "insert into transmitter values(?,?,?,?,?,?,?,?);";
    private final String search = "select * from transmitter t inner join ubication u on t.location = u.idUbication and user = ?;";
    private final String r = "select * from transmitter";
    private final String update = "UPDATE eif209_2020_p01.transmitter SET name= ? ,telephone=?,email=?,"
            + " tradename=? WHERE dni=?";

    public boolean create(Emisor emisor) {
        PreparedStatement ps = null;
        DataAccess.DataBase db = DataBase.getInstance();
        try {
            ps = db.getConnection().prepareStatement(create);
            ps.setString(1, emisor.getDni());
            ps.setString(2, emisor.getName());
            ps.setString(3, emisor.getTelephone());
            ps.setString(4, emisor.getE_mail());
            ps.setString(5, emisor.getTradename());
            ps.setInt(6, emisor.getLocation().getIdUbication());
            ps.setInt(7, emisor.getId_type());
            ps.setString(8, emisor.getUser().getUser());
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Emisor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public Emisor search(String user) {
        PreparedStatement ps = null;
        DataBase db = DataBase.getInstance();
        ResultSet rs = null;
        Emisor emisor = null;
        try {
            ps = db.getConnection().prepareStatement(this.search);
            ps.setString(1, user);
            rs = ps.executeQuery();
            if (rs.next()) {
                emisor = new Emisor(
                        rs.getString("tradename"),
                        new User(user, ""),
                        null,
                        rs.getString("dni"),
                        rs.getString("name"),
                        rs.getString("telephone"),
                        rs.getString("email"),
                        rs.getInt("id_type"),
                        new Ubication(
                                rs.getInt("idUbication"),
                                rs.getString("nomProvince"),
                                rs.getString("nomCanton"),
                                rs.getString("nomDistrito"),
                                rs.getString("address"))
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Person.class.getName()).log(Level.SEVERE, null, ex);
        }
        return emisor;
    }

    public List<Emisor> read() {
        List<Emisor> list = new ArrayList<>();
        Statement st = null;
        DataBase db = DataBase.getInstance();
        ResultSet rs = null;
        try {
            st = db.getConnection().createStatement();
            rs = st.executeQuery(this.r);
            while (rs.next()) {
                list.add(new Emisor( //dni name tel email tradename loc idtype 
                        rs.getString("tradename"),
                        new User(rs.getString("user"), ""),
                        null,
                        rs.getString("dni"),
                        rs.getString("name"),
                        rs.getString("telephone"),
                        rs.getString("email"),
                        rs.getInt("id_type"),
                        new Ubication(
                                rs.getInt("idUbication"),
                                rs.getString("nomProvince"),
                                rs.getString("nomCanton"),
                                rs.getString("nomDistrito"),
                                rs.getString("address"))
                ));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Ubication.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                this.closeCnx(null, st, rs);
            } catch (SQLException ex) {
                Logger.getLogger(DAO_Ubication.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }

    private void closeCnx(PreparedStatement ps, Statement st, ResultSet rs) throws SQLException {
        if (ps != null) {
            ps.close();
        }
        if (st != null) {
            st.close();
        }
        if (rs != null) {
            rs.close();
        }
    }

    public boolean update(Emisor emisor) {
        PreparedStatement ps = null;
        DataBase db = DataBase.getInstance();
        try {
            ps = db.getConnection().prepareStatement(this.update);
            ps.setString(1, emisor.getName());
            ps.setString(2, emisor.getTelephone());
            ps.setString(3, emisor.getE_mail());
            ps.setString(4, emisor.getTradename());
            ps.setString(5, emisor.getDni());

            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Ubication.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

}
