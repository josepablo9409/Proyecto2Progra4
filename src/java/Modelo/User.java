package Modelo;

import java.io.Serializable;

public class User implements Serializable {

    private String user;
    private String pass;
    private int status;
    private int rol;

    public User() {
        this("", "");
        this.status = 2;
        this.rol = 1;
    }

    public User(String user, String pass) {
        this.user = user;
        this.pass = pass;
        this.status = 2;
        this.rol = 1;
    }

    public User(String user, String pass, int status, int rol) {
        this.user = user;
        this.pass = pass;
        this.status = status;
        this.rol = rol;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getRol() {
        return rol;
    }

    public void setRol(int rol) {
        this.rol = rol;
    }

}
