package segundoparcial.Ejercicio1.ejercicio3;

public class Main {
    public static void main(String[] args) {
        Almacen container = new Almacen();
        Productor p = new Productor(1, container);
        Consumidor c = new Consumidor(1, container);
        p.start();
        c.start();
    }
}
