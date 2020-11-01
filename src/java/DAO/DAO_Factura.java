package DAO;

import DataAccess.DataBase;

import Modelo.Factura;
import Model.List.ListFacturas;
import Modelo.ListProduct;
import Modelo.Person;
import Modelo.Producto;
import Modelo.Emisor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAO_Factura {

    private final String create = "insert into factura values(0,?,?);";
    private final String findByOwner = "select idFactura,receptor from factura where emisor=?;";

    //detalle
    private final String createDetalle = "insert into detalle values (?,?,?);";
    private final String findByFacId = "Select * from detalle where idFac=?;";

    public boolean create(Factura f) {
        PreparedStatement ps = null;
        DataBase db = DataBase.getInstance();
        try {
            ps = db.getConnection().prepareStatement(create, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, f.getEmisor().getDni());
            ps.setString(2, f.getCliente().getDni());
            if (ps.executeUpdate() > 0) {
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    f.setId(rs.getInt(1));
                } else {
                    return false;
                }
                return this.createDetalle(f);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Factura.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public Factura findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ListFacturas findByOwner(Emisor emisor) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        DataBase db = DataBase.getInstance();
        ListFacturas facturas = new ListFacturas();
        try {
            DAO_Person cliente = new DAO_Person();
            ps = db.getConnection().prepareStatement(this.findByOwner);
            ps.setString(1, emisor.getDni());
            rs = ps.executeQuery();
            while (rs.next()) {
                Person r = cliente.findById(rs.getString("receptor"));
                if (r != null) {
                    facturas.getFacturas().add(
                            new Factura(
                                    rs.getInt("idFactura"),
                                    emisor,
                                    r,
                                    this.findByFac(
                                            rs.getInt("idFactura"))
                            )
                    );
                } else {
                    return null;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Factura.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (facturas.getFacturas().isEmpty()) {
            return null;
        }
        return facturas;
    }

    //detalle
//	
    private ListProduct findByFac(int id) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        DataBase db = DataBase.getInstance();
        ListProduct productos = new ListProduct();
        try {
            DAO_Product producto = new DAO_Product();
            ps = db.getConnection().prepareStatement(this.findByFacId);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                Producto p = producto.findById(rs.getInt("idProd"));
                if (p != null) {
                    p.setCantidad(rs.getInt("cantidad"));
                    productos.add(p);
                } else {
                    return null;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Factura.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (productos.isEmpty()) {
            return null;
        }
        return productos;
    }

    private boolean createDetalle(Factura f) {
        PreparedStatement ps = null;
        DataBase db = DataBase.getInstance();
        try {
            ps = db.getConnection().prepareStatement(this.createDetalle);
            ps.setInt(1, f.getId());
            for (Producto p : f.getProductos()) {
                ps.setInt(2, p.getId());
                ps.setInt(3, p.getCantidad());
                if (ps.executeUpdate() < 0) {
                    return false;
                }
            }
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Factura.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
