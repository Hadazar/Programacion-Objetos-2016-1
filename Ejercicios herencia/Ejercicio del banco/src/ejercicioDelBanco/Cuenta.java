/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicioDelBanco;

/**
 *
 * @author HéctorAugusto
 */
public class Cuenta {
    
    private int numeroDeCuenta;
    private String nombreDelCliente;
    private double saldo;

    public Cuenta(int numeroDeCuenta, String nombreDelCliente, double saldo) {
        this.numeroDeCuenta = numeroDeCuenta;
        this.nombreDelCliente = nombreDelCliente;
        this.saldo = saldo;
    }
    
    //Operación: colsultar datos
    public String toString(){
        
        String numeroDeCuenta = "Numero de cuenta: " + this.numeroDeCuenta + "\n";
        String nombreDelCliente = "Nombre del cliente: " + this.nombreDelCliente + "\n";
        String saldo = "Saldo: $" + this.saldo + "\n";
        return numeroDeCuenta + nombreDelCliente + saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    public double getSaldo() {
        return saldo;
    }
    
    
    public void depositar(double deposito){
        
        saldo += deposito;
    }
    
    public void retirar(double retiro){
        
        if(saldo >= retiro){
            saldo -= retiro;
        }else{
            throw new ArithmeticException("No Cuenta con saldo suficiente para realizar su retiro");
        }
    }
}
