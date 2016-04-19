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
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Auto[] autos = new Auto[4];
        autos[0] = new AutoCompacto(5, 2315, "Chevrolet", 2000, 10000000);
        autos[1] = new AutoDeLujo(6, 8695, "Ford", 2005, 50000000);
        autos[2] = new Camioneta(5000, 4, 5, 2540, "Lamborghini", 2015, 200000000);
        autos[3] = new Vagoneta(10, 6895, "Ferrari", 2016, 250000000);
        
        for(Auto auto : autos){
            System.out.println(auto);
        }
    }
    
}
