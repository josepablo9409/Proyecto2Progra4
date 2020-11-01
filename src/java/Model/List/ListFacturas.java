package Model.List;

import Modelo.Factura;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ListFacturas implements Serializable {

    private List<Factura> facturas;

    public ListFacturas() {
        this.facturas = new ArrayList<>();
    }

    public ListFacturas(List<Factura> facturas) {
        this.facturas = facturas;
    }

    public List<Factura> getFacturas() {
        return facturas;
    }

    public void setFacturas(List<Factura> facturas) {
        this.facturas = facturas;
    }

}
