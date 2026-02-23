package arrays1;
import java.util.ArrayList;

import java.util.Scanner;
import java.util.List;
public class Arrays1
{
    public int [] data;
    List<Integer> newdata = new ArrayList<>();
    public int n;
    
    public Arrays1(int n)
    {
        this.n = n;
        this.data = new int[n];
        this.data = new int[n];
    }
    
    
    
    public void setArray(String name)
    {
        Scanner adc = new Scanner(System.in);
        Scanner opc = new Scanner(System.in);
        
        
        for (int i = 0; i < n ; i++)
        {
           
            System.out.print("Ingrese la posicion del numero de la matriz que desea guardar: ");
            int user = adc.nextInt();
            newdata.add(data[user] = user);
            
            System.out.print("Desea continuar?:(Si/No): ");
            String p = opc.nextLine();
            if ("No".equals(p)) break;
            
        }
            System.out.println(name + " = " + newdata);
        
        
     }
    
    
    
    
    public void print(String name)
    {
        
        System.out.print(name + " = [");
        for (int i = 0 ; i < n ; i++)
        {
            System.out.print(data[i] = i+2);
            
            if (i < n - 1)System.out.print("," + " ");
            
        }       
            
            System.out.println("]");
            
    }
    
   
    
    
    
    public static void main(String[] args)
            
            
    {
        
        Arrays1 ob1 = new Arrays1(5);
        ob1.print("matriz1");
        
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Desea guardar elementos en una nueva matriz?(Si/No): ");
        String opc = sc.nextLine();
        if ("Si".equals(opc)) ob1.setArray("new_matriz1");
        if ("No".equals(opc)) System.out.print("Saliendo... ");  
       
           
        
    }
    
}
