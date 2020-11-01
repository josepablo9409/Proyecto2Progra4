package Modelo;

import java.io.Serializable;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

public class Emisor extends Person implements Serializable {

    private String tradename;
    @XmlTransient
    private User user;
    @XmlTransient
    private List<Producto> products;

    public Emisor() {
        this("a", null, null, "a", "a", "a", "a", -1, null);
    }

    public Emisor(String tradename, User user, List<Producto> products, String dni,
            String name, String telephone, String e_mail, int id_type, Ubication location) {
        super(dni, name, telephone, e_mail, id_type, location);
        this.tradename = tradename;
        this.user = user;
        this.products = products;
    }

    @XmlElement(name = "NombreComercio")
    public String getTradename() {
        return tradename;
    }

    public void setTradename(String tradename) {
        this.tradename = tradename;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Producto> getProducts() {
        return products;
    }

    public void setProducts(List<Producto> products) {
        this.products = products;
    }

    public String printProductsList(List<Producto> products) {
        products = getProducts();

        String s = "";
        if (products != null) {
            for (int i = 0; i < products.size(); i++) {
                s = " [Id:" + (products.get(i).getId() + " Cantidad:" + products.get(i).getCantidad() + "Precio: "
                        + products.get(i).getPrice() + "Descripcion :" + products.get(i).getCategory().getDescripcion() + "IVA : " + products.get(i).getCategory().getIva() + " Detalle"
                        + products.get(i).getDetail() + "]");

            }
        } else {
            s = "sin productos";
        }
        return s;
    }

    @Override
    public String toString() {
        return "Transmitter { \n" + " DNI: " + super.getDni() + " nombre: " + super.getName() + " email: " + super.getE_mail() + " telefono: " + super.getTelephone() + " tradename = " + tradename + "\n usuario = " + user.getUser()
                + "\n Lista de productos \n" + printProductsList(products) + '}';
    }
}
