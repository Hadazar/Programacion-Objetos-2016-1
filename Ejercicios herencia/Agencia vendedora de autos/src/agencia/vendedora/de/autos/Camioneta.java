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
public class Camioneta extends Auto{
    
    private double capacidadDeCarga;
    private int cantidadDeEjes;
    private int cantidadDeRodadas;

    public Camioneta(double capacidadDeCarga, int cantidadDeEjes, int cantidadDeRodadas, int numeroDeSerieDeMotor, String marca, int año, double precio) {
        super(numeroDeSerieDeMotor, marca, año, precio);
        this.capacidadDeCarga = capacidadDeCarga;
        this.cantidadDeEjes = cantidadDeEjes;
        this.cantidadDeRodadas = cantidadDeRodadas;
    }
    
    public String toString(){
        
        String base = super.toString();
        String auto = "Camioneta:\n\n" + "Capacidad de carga: " + capacidadDeCarga + "kg\n" + "Cantidad de ejes: " + cantidadDeEjes + "\n" + "Cantidad de rodadas: " + cantidadDeRodadas + "\n";
        return base + auto;
    }
}
