/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicioDelBanco;

import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author HéctorAugusto
 */
public class Ahorro extends Cuenta{
    
    private Date fechaDeVencimiento;
    private double porcentajeInteresMensual;

    public Ahorro(Date fechaDeVencimiento, double porcentajeInteresMensual, int numeroDeCuenta, String nombreDelCliente, double saldo) {
        super(numeroDeCuenta, nombreDelCliente, saldo);
        this.fechaDeVencimiento = fechaDeVencimiento;
        this.porcentajeInteresMensual = porcentajeInteresMensual;
    }
    
    public void retirar(double retiro){
        
        Date fechaActual = new Date();
        if(fechaActual.getTime()-fechaDeVencimiento.getTime() == 0){
            super.retirar(retiro);
        }else{
            throw new IllegalArgumentException("No se realizo la transacción, solo es posible retirar en la fecha de vencimiento");
        };
    }
    
    //Operación: colsultar datos
    public String toString(){
        
        String base = super.toString();
        String ahorro = "Tipo de cuenta: Cuenta de ahorros\n\n";
        String fechaDeVencimiento = "Fecha de vencimiento: " + this.fechaDeVencimiento.toLocaleString() + "\n";
        String porcentajeInteresMensual = "Porcentaje de interes mensual: " + this.porcentajeInteresMensual + "\n";
        return ahorro + base + fechaDeVencimiento + porcentajeInteresMensual;
    }
    
    public void depositarInteres(int meses){
        
        Date fechaActual = new Date();
        int dia = fechaActual.getDay();
        if(dia == 0){
            super.setSaldo(super.getSaldo() * porcentajeInteresMensual);
        }
    }
}
