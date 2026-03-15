package matriz2x2;
import java.util.Scanner;


public class Matriz2x2 
{
    public int[][] data;
    public int filas;
    public int columnas;

    public Matriz2x2() 
    {
        filas = 2;
        columnas = 2;
        data = new int[filas][columnas];
    }

    public void getvector(String name) 
    {
        Scanner sc = new Scanner(System.in);
        
        
        for (int i = 0; i < filas ; i++) 
        {
            for (int j = 0 ; j < columnas ; j++)
            {
                System.out.print("data[" + i + "][" + j + "]:");
                data[i][j] = sc.nextInt();
                
            }
        }
        
    }

    public void setvector()
    {
        
        for ( int i = 0; i < filas ; i++)
        {
            for ( int j = 0 ; j < columnas ; j++)
            {
                System.out.print(data[i][j] + " ");
            }
            System.out.println();
        }
    }
    public Matriz2x2 sumar(Matriz2x2 otra)
    {
        Matriz2x2 resultado = new Matriz2x2();
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
    
    public Matriz2x2 multiplicar(Matriz2x2 otra)
    {
        Matriz2x2 resultado = new Matriz2x2();
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
        Matriz2x2 m = new Matriz2x2();
        m.getvector("matriz1");
        m.setvector();
        Matriz2x2 n = new Matriz2x2();
        n.getvector("matriz2");
        n.setvector();
        m.sumar(n);
        m.multiplicar(n);
        
        
    }
}
