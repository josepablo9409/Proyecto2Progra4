package Modelo;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlElement;

public class Person implements Serializable {

    private String dni;
    private String name;
    private String telephone;
    private String e_mail;

    private int id_type;
    private Ubication location;

    public Person() {
        this("", "", "", "", -1, null);
    }

    public Person(String dni, String name, String telephone, String e_mail,
            int id_type, Ubication location) {
        this.dni = dni;
        this.name = name;
        this.telephone = telephone;
        this.e_mail = e_mail;
        this.id_type = id_type;
        this.location = location;

    }

    @XmlElement(name = "Numero_de_identificacion")
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    @XmlElement(name = "Numero_Completo")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElement(name = "Numero_de_telefono")
    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @XmlElement(name = "Correo_electronico")
    public String getE_mail() {
        return e_mail;
    }

    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }

    @XmlElement(name = "Tipo_de_identificacion")
    public int getId_type() {
        return id_type;
    }

    public void setId_type(int id_type) {
        this.id_type = id_type;
    }

    @XmlElement(name = "Ubicacion")
    public Ubication getLocation() {
        return location;
    }

    public void setLocation(Ubication location) {
        this.location = location;
    }
}
