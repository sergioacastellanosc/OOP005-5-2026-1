
package modificadoresacceso;


public class MainCuenta {


    public static void main(String[] args) 
    {
        CuentaBancaria c1 = new CuentaBancaria("Maria" , 100000.0);
        c1.mostrar();
        c1.depositar(25000.0);
        c1.retirar(10000.0);
        System.out.println("\n Despues de operaciones: ");
        c1.mostrar();
        System.out.println("\n Acceso controlado por getter: ");
        System.out.println(" Saldo actual = " + c1.getSaldo());
        System.out.println("\n:Operaciones forzadas: \n");
        
        CuentaBancaria c2 = new CuentaBancaria("Mario" , 50000.0);
        c2.mostrar();
        c2.setSaldo(75000);
        System.out.println("Saldo Mario: " + c2.getSaldo());
        c2.setTitular("Alejandro");
        System.out.println(c2.getTitular());
    }
    
}
