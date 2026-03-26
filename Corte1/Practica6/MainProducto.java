package constructores;

public class MainProducto {

    
    public static void main(String[] args) {
        Producto p1 = new Producto ();
        Producto p2 = new Producto ("Cuaderno");
        Producto p3 = new Producto ("Lapiz" , 2500.0);
        System.out.println("Producto 1:");
        p1.mostrar();
        System.out.println("\n Producto 2: ");
        p2.mostrar();
        System.out.println("\n Producto 3:");
        p3.mostrar();
    }
    
}
