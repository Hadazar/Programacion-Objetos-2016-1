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
public class Transporte extends Auto{
    
    private int cantidadPasajeros;

    public Transporte(int cantidadPasajeros, int numeroDeSerieDeMotor, String marca, int año, double precio) {
        super(numeroDeSerieDeMotor, marca, año, precio);
        this.cantidadPasajeros = cantidadPasajeros;
    }
    
    public String toString(){
        
        String base = super.toString();
        String cantidadPasajeros = "Cantidad de pasajeros: " + this.cantidadPasajeros + "\n";
        return base + cantidadPasajeros;
    }
}
