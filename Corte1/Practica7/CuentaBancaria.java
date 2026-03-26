package modificadoresacceso;

public class CuentaBancaria 
{
    private String titular;
    private double saldo;

    public CuentaBancaria(String titular, double saldo) 
    {
        this.titular = titular;
        this.saldo = saldo;
    }
    
    

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    public void retirar ( double monto )
    {
        if (monto > 0 && monto <= saldo)
        {
            saldo = saldo - monto;
        }
    }
    public void mostrar ()
    {
        System.out.println("Titular = " + titular);
        System.out.println("Saldo = " + saldo);
    }
    public void depositar (double monto)
    {
        if (monto > 0) 
        {
            saldo = saldo + monto;
        }
    }
    
    
    
    
}
