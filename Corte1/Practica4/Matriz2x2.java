package matriz2x2;
import java.util.Scanner;


public class Matriz2x2 
{
    public int[][] data;
    public int filas;
    public int columnas;

    public Matriz2x2(int n, int m) 
    {
        filas = n;
        columnas = m;
        data = new int[n][m];
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
    
    public static void main(String[] args) 
    {
        Scanner adc = new Scanner(System.in);
        System.out.print("Ingrese el numero de filas: ");
        int fil = adc.nextInt();
        Scanner scd = new Scanner(System.in);
        System.out.print("Ingrese el numero de columnas: ");
        int col = scd.nextInt();
        Matriz2x2 m = new Matriz2x2(fil , col);
        m.getvector("matriz");
        m.setvector();
        
        
        
        
        
        

        
    }
}
