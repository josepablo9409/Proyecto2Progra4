package Modelo;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

public class Producto implements Serializable {

    @XmlTransient
    private int id;
    private String detail;
    private float price;
    private Category category;
    private int cantidad;

    public Producto() {
        this(0, "", 0.0f, null);
        this.cantidad = 0;
    }

    public Producto(int id, String detail, float price, Category category) {
        this.id = id;
        this.detail = detail;
        this.price = price;
        this.category = category;
        this.cantidad = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @XmlElement(name = "Detalle")
    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    @XmlElement(name = "Precio")
    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @XmlElement(name = "Categoria")
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @XmlElement(name = "Cantidad")
    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @XmlElement(name = "SubTotal")
    public float getTotal() {
        float a = this.price * this.cantidad;
        float b = a * this.category.getIva();
        return a + b;
    }

}
