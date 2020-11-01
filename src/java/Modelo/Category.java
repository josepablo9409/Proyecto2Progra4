package Modelo;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlElement;

public class Category implements Serializable {

    private String descripcion;
    private float iva;

    public Category() {
        this("", 1);
    }

    public Category(String descripcion, float iva) {
        this.descripcion = descripcion;
        this.iva = iva;
    }

    @XmlElement(name = "Descripcion")
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlElement(name = "IVA")
    public float getIva() {
        return iva;
    }

    public void setIva(float iva) {
        this.iva = iva;
    }
}
