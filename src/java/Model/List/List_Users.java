package Model.List;

import Modelo.User;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class List_Users implements Serializable {

    private List<User> usuarios;

    public List_Users() {
        this.usuarios = new ArrayList<>();
    }

    public List_Users(List<User> usuarios) {
        this.usuarios = usuarios;
    }

    public List<User> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<User> usuarios) {
        this.usuarios = usuarios;
    }

}
