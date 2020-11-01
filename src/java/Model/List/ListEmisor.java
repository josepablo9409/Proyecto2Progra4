package Model.List;

import Modelo.Emisor;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ListEmisor implements Serializable {

    private List<Emisor> proveedores;

    public ListEmisor() {
        this.proveedores = new ArrayList<>();
    }

    public ListEmisor(List<Emisor> proveedores) {
        this.proveedores = proveedores;
    }

    public List<Emisor> getProveedores() {
        return proveedores;
    }

    public void setProveedores(List<Emisor> proveedores) {
        this.proveedores = proveedores;
    }

}
