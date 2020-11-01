package Model.List;

import Modelo.Person;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class List_Clients implements Serializable {

    private List<Person> clientes;

    public List_Clients() {
        this.clientes = new ArrayList<>();
    }

    public List_Clients(List<Person> clientes) {
        this.clientes = clientes;
    }

    public List<Person> getClientes() {
        return clientes;
    }

    public void setClientes(List<Person> clientes) {
        this.clientes = clientes;
    }

}
