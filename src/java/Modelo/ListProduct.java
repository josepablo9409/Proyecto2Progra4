package Modelo;

import java.util.ArrayList;
import java.util.Optional;

public class ListProduct extends ArrayList<Producto> {

    public ListProduct() {
        super();
    }

    public float total() {
        float t = this.stream().map(element -> element.getTotal())
                .reduce(0.0f, (total, detalle) -> total + detalle);
        return t;
    }

    public Producto search(int id) {
        Optional<Producto> optional = this.stream().filter(elem -> elem.getId() == id).findFirst();
        if (optional.isPresent()) {
            return optional.get();
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        ListProduct lista = new ListProduct();
        Producto prod1 = new Producto(0, "hola0", 550, new Category("saludo1", 0.13f));
        Producto prod2 = new Producto(1, "hola1", 650, new Category("saludo2", 0.12f));
        Producto prod3 = new Producto(2, "hola2", 750, new Category("saludo3", 0.11f));
        Producto prod4 = new Producto(3, "hola3", 850, new Category("saludo4", 0.10f));
        lista.add(prod1);
        lista.add(prod2);
        lista.add(prod3);
        lista.add(prod4);
        System.out.println(lista.total());
    }
}
