/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoaliens;

/**
 *
 * @amiriartep
 */
public class ProyectoAliens {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Marte marte = new Marte("Verde", 4, "Huevos", "Carnívoro", "Marciano");
        Jupiter jupiter = new Jupiter("Morado", 12, "Larvas", "Herbívoro", "Jupiteriano");
        System.out.println(marte.toString());
        System.out.println(jupiter.toString());
    }
}
