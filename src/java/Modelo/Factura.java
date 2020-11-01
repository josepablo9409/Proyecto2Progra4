package Modelo;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement(name = "Factura")
public class Factura implements Serializable {

    @XmlTransient
    private int id;
    private Emisor emisor;
    private Person cliente;
    private ListProduct productos;

    public Factura() {
        this(null, null);
        this.productos = null;
    }

    public Factura(Emisor emisor, Person cliente) {
        this.id = 0;
        this.emisor = emisor;
        this.cliente = cliente;
        this.productos = new ListProduct();
    }

    public Factura(int id, Emisor emisor, Person cliente) {
        this.id = id;
        this.emisor = emisor;
        this.cliente = cliente;
        this.productos = new ListProduct();
    }

    public Factura(int id, Emisor emisor, Person cliente, ListProduct productos) {
        this.id = id;
        this.emisor = emisor;
        this.cliente = cliente;
        this.productos = productos;
    }

    public Factura(Emisor emisor, Person cliente, ListProduct productos) {
        this.emisor = emisor;
        this.cliente = cliente;
        this.productos = productos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @XmlElement(name = "Emisor")
    public Emisor getEmisor() {
        return emisor;
    }

    public void setEmisor(Emisor emisor) {
        this.emisor = emisor;
    }

    @XmlElement(name = "Receptor")
    public Person getCliente() {
        return cliente;
    }

    public void setCliente(Person cliente) {
        this.cliente = cliente;
    }

    @XmlElement(name = "Productos")
    public ListProduct getProductos() {
        return productos;
    }

    public void setProductos(ListProduct productos) {
        this.productos = productos;
    }

    @XmlElement(name = "Total")
    public float getTotal() {
        return this.productos.total();
    }
}
