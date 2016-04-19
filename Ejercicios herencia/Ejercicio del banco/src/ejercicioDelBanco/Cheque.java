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
public class Cheque extends Cuenta{
    
    private double comision;
    private double comisionPorEmision;

    public Cheque(double comision, double comisionPorEmision, int numeroDeCuenta, String nombreDelCliente, double saldo) {
        super(numeroDeCuenta, nombreDelCliente, saldo);
        this.comision = comision;
        this.comisionPorEmision = comisionPorEmision;
    }
    
    //Operación: colsultar datos
    public String toString(){
        
        String base = super.toString();
        String ahorro = "Tipo de cuenta: Cheque\n\n";
        String comision = "Comision por uso de chequera: " + this.comision + "\n";
        String comisionPorEmision = "Comision por emisión de cheques con saldo insuficiente: " + this.comisionPorEmision + "\n";
        return ahorro + base + comision + comisionPorEmision;
    }
}
