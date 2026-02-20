package calculator;
public class Calculator
{
    public double x1,x2;
    //Constructor
    public Calculator(double a, double b)
    {
        x1 = a;
        x2 = b;
    }
    public double add()
    {
        return x1+x2;
    }
    public double subs()
    {
        return x1-x2;
    }
    public double mul()
    {
        return x1*x2;
    }
    public void div()
    {
        if (x2 == 0)
        {
            System.out.println("No es posible dividir entre 0");
        }
        else
        {
            System.out.println("La division es: " + x1/x2);
        }
    }
    
    public static void main(String[]args)
    {
        Calculator m = new Calculator(25,45);
        System.out.println("La suma de m es: " + m.add());
        System.out.println("La resta de m es: " + m.subs());
        System.out.println("La multiplicacion de m es: " + m.mul());
        System.out.print("La division para m es: ");
        m.div();
        Calculator n = new Calculator(34,1);
        System.out.println("La suma de n es: " + n.add());
        System.out.println("La resta de n es: " + n.subs());
        System.out.println("La multiplicacion de n es: " + n.mul());
        System.out.print("La division para n es: ");
        n.div();
        
    }
}
