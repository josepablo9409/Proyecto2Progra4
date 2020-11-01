package DAO;

import DataAccess.DataBase;
import Modelo.Person;
import Modelo.Ubication;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import Model.List.List_Clients;

public class DAO_Person {

    private final String create = "insert into receiver values(?,?,?,?,?,?,?);";
    private final String findById = "SELECT * FROM eif209_2020_p01.receiver r inner join "
            + "ubication u on r.location = u.idUbication and r.dni=?;";
    private final String update = "update personal_info set name = ?, telephone =?, e-mail =?, tradename =?, location int \n"
            + "id_type int \n"
            + "user ?,?,?,?,?,?,?,?);";
    private final String searchClient = "SELECT * FROM eif209_2020_p01.receiver r inner join "
            + "ubication u on r.location = u.idUbication and r.transmitter_owner = ?;";

    public boolean create(Person p, String owner) throws SQLException {
        PreparedStatement ps = null;
        DataBase db = DataBase.getInstance();
        ps = db.getConnection().prepareStatement(create);
        ps.setString(1, p.getDni());
        ps.setString(2, p.getName());
        ps.setString(3, p.getTelephone());
        ps.setString(4, p.getE_mail());
        ps.setInt(5, p.getLocation().getIdUbication());
        ps.setInt(6, p.getId_type());
        ps.setString(7, owner);
        if (ps.executeUpdate() > 0) {
            return true;
        }
        return false;
    }

    public Person findById(String id) {
        PreparedStatement ps = null;
        DataBase db = DataBase.getInstance();
        ResultSet rs = null;
        Person p = null;
        try {
            ps = db.getConnection().prepareStatement(this.findById);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                p = new Person(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(6),
                        new Ubication(
                                rs.getInt(8),
                                rs.getString(9),
                                rs.getString(10),
                                rs.getString(11),
                                rs.getString(12))
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Person.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }

    public boolean update(Person p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List_Clients searchClients(String owner) {
        List_Clients clientes = new List_Clients();
        PreparedStatement ps = null;
        DataBase db = DataBase.getInstance();
        ResultSet rs = null;
        try {
            ps = db.getConnection().prepareStatement(this.searchClient);
            ps.setString(1, owner);
            rs = ps.executeQuery();
            while (rs.next()) {
                clientes.getClientes().add(
                        new Person(
                                rs.getString(1),
                                rs.getString(2),
                                rs.getString(3),
                                rs.getString(4),
                                rs.getInt(6),
                                new Ubication(
                                        rs.getInt(8),
                                        rs.getString(9),
                                        rs.getString(10),
                                        rs.getString(11),
                                        rs.getString(12))
                        ));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Person.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (clientes.getClientes().isEmpty()) {
            return null;
        } else {
            return clientes;
        }
    }

}
