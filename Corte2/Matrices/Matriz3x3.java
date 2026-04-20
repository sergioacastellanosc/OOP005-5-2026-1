package matriz3x3;
import java.util.Scanner;
public class Matriz3x3
{
    private final int [][] data;
    private final int filas;
    private final int columnas;
    Matriz3x3()
    {
        filas = 3;
        columnas = 3;
        data = new int[filas][columnas];
    }
    public void setmatriz3x3()
    {
        Scanner sc = new Scanner(System.in);
        for (int i = 0 ; i < filas ; i++)
        {
            for ( int j = 0 ; j < columnas ; j++)
            {
                System.out.print("data[" + i + "][" + j + "]:");
                data[i][j] = sc.nextInt();
            }
        }
    }
    public void getmatriz3x3()
    {
        System.out.println("\nMatriz 3x3:");
        for ( int i = 0 ; i < filas ; i++)
        {
            for ( int j = 0 ; j < columnas ; j++)
            {
                System.out.print(data[i][j] + " ");
            }
            System.out.println();
        }
    }
        public Matriz3x3 sumar(Matriz3x3 otra)
    {
        Matriz3x3 resultado = new Matriz3x3();
        System.out.println("Matriz suma");
        for (int i = 0 ; i < filas ; i++)
        {
            for (int j = 0 ; j < columnas ; j++)
            {
                resultado.data[i][j] = this.data[i][j] + otra.data[i][j];
                System.out.print(resultado.data[i][j] + " ");
            }
            System.out.println();
        }
        return resultado;
    }
    
    public Matriz3x3 multiplicar(Matriz3x3 otra)
    {
        Matriz3x3 resultado = new Matriz3x3();
        System.out.println("Marriz multiplicacion");
        for ( int i = 0 ; i < filas ; i++)
        {
            for ( int j = 0 ; j < columnas ; j++)
            {
                resultado.data[i][j] = 0;
                for (int k = 0; k < columnas ; k++)
                {
                    resultado.data[i][j] = resultado.data[i][j] + this.data[i][k] * otra.data[k][j];
                    
                            
                }
                System.out.print(resultado.data[i][j] + " ");
            }
            System.out.println();
        }
        return resultado;
    }
    public static void main(String[] args)
    {
        Matriz3x3 m = new Matriz3x3();
        m.setmatriz3x3();
        m.getmatriz3x3();
        Matriz3x3 n = new Matriz3x3();
        n.setmatriz3x3();
        n.getmatriz3x3();
        m.sumar(n);
        m.multiplicar(n);
    }
}
