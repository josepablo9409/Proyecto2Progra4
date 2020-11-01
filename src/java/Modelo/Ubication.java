package Modelo;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

public class Ubication implements Serializable {

    @XmlTransient
    private int idUbication;
    private String province;
    private String canton;
    private String distrito;
    private String address;

    public Ubication() {
        this(0, "", "", "", "");
    }

    public Ubication(int idUbication, String province, String canton, String distrito, String address) {
        this.idUbication = idUbication;
        this.province = province;
        this.canton = canton;
        this.distrito = distrito;
        this.address = address;
    }

    public int getIdUbication() {
        return idUbication;
    }

    public void setIdUbication(int idUbication) {
        this.idUbication = idUbication;
    }

    @XmlElement(name = "Provincia")
    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    @XmlElement(name = "Canton")
    public String getCanton() {
        return canton;
    }

    public void setCanton(String canton) {
        this.canton = canton;
    }

    @XmlElement(name = "Distrito")
    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    @XmlElement(name = "Direccion")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
