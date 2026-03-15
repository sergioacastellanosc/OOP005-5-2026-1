package matriz3x3;
import java.util.Scanner;
public class Matriz3x3
{
    int [][] data;
    public int filas;
    public int columnas;
    public Matriz3x3()
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
                System.out.print(data[i][j] + "");
            }
            System.out.println();
        }
    }
    public static void main(String[] args)
    {
        Matriz3x3 m = new Matriz3x3();
        m.setmatriz3x3();
        m.getmatriz3x3();
    }
}
