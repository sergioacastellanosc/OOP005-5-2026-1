
package constructores;

public class Producto 
{
    public String nombre;
    public double precio;
    
    
    
    public Producto(){}
    public Producto(String nombre)
    {
        this.nombre = nombre;
    }
    public Producto(String nombre, double precio)
    {
        this.nombre = nombre;
        this.precio = precio;
    }
    
    public void mostrar()
    {
        System.out.println("Nombre = " + nombre);
        System.out.println("Precio = " + precio);
    }
    
}
