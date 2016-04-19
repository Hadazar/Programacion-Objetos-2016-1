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
public class Auto {
    
    private int numeroDeSerieDeMotor;
    private String marca;
    private int año;
    private double precio;

    public Auto(int numeroDeSerieDeMotor, String marca, int año, double precio) {
        this.numeroDeSerieDeMotor = numeroDeSerieDeMotor;
        this.marca = marca;
        this.año = año;
        this.precio = precio;
    }
    
    public String toString(){
        
        String numeroDeSerieDeMotor = "Número de serie del motor: " + this.numeroDeSerieDeMotor + "\n";
        String marca = "Marca: " + this.marca + "\n";
        String año = "Año: " + this.año + "\n";
        String precio = "Precio: $" + this.precio + "\n";
        return numeroDeSerieDeMotor + marca + año + precio;
    }
}
