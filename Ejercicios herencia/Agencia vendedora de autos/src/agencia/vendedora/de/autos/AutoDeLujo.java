/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agencia.vendedora.de.autos;

/**
 *
 * @author HéctorAugusto
 */
public class AutoDeLujo extends Transporte{

    public AutoDeLujo(int cantidadPasajeros, int numeroDeSerieDeMotor, String marca, int año, double precio) {
        super(cantidadPasajeros, numeroDeSerieDeMotor, marca, año, precio);
    }
    
    public String toString(){
        
        String base = super.toString();
        String auto = "Auto de lujo:\n\n";
        return auto + base;
    }
}
