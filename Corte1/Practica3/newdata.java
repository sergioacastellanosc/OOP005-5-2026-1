
package arrays1;
import java.util.ArrayList;

import java.util.Scanner;
import java.util.List;
public class newdata
{
    
    List<Integer> newdata = new ArrayList<>();
    
    
    public newdata()
    {
        
        this.newdata = new ArrayList<>();
    }
    
    
    
    public void setArray(String name , int n)
    {
        Scanner adc = new Scanner(System.in);
        Scanner opc = new Scanner(System.in);
        
        
        for (int i = 0; i < n ; i++)
        {
           
            System.out.print("Ingrese el elemento " + (i+1) + " : ");
            int user = adc.nextInt();
            newdata.add(user);
            
            
            
        }
            System.out.println(name + " = " + newdata);
        
        
     }
    public int sum()
    {
        int s = 0;
        
        for (int elemento : newdata) s += elemento;
        return s;
    }
    public double mean()
    {
        if (newdata.isEmpty()) return 0.0;
        return (double) sum() / (double) newdata.size();
    }
    public int max()
    {
        int m = newdata.get(0);
        for (int i = 1 ; i < newdata.size() ; i++) 
        {
            if (newdata.get(i) > m) m = newdata.set(i , m);
        }
        return m;
    }
    public int min()
    {
        int y = newdata.get(0);
        for (int i = 1 ; i < newdata.size() ; i++)
        {
            if (newdata.get(i) < y) y = newdata.set(i , y);
        }
        return y;
    }
    
    
    
   
    
    
    
    public static void main(String[] args)
            
            
    {
        
        newdata ob1 = new newdata();
        
        
        Scanner udc = new Scanner(System.in);
        Scanner uhc = new Scanner(System.in);
        System.out.print("Ingrese el tamano de su matriz: ");
        int tam = udc.nextInt();
        System.out.print("Ingrese el nombre del arreglo: ");
        String name = uhc.nextLine();
        
        ob1.setArray(name , tam);
        
        System.out.println("El valor de la suma de los elementos de la matriz es: " + ob1.sum());
        System.out.println("El valor del promedio de la suma de los elementos de la matriz es: " + ob1.mean());
        System.out.println("El elemento maximo de la matriz es: " + ob1.max());
        System.out.println("El elemento minimo de la matriz es: " + ob1.min());
        
    }
    
}
