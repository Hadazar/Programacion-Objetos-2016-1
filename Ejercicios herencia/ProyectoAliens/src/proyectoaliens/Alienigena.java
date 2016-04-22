/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoaliens;

/**
 *
 * @amiriartep
 */
public class Alienigena {

    public String color;
    public Integer cantidadOjos;
    public String reproduccion;
    public String tipoComida;
    public String planeticio;

    public Alienigena(String color, Integer cantidadOjos, String reproduccion, String tipoComida, String planeticio) {
        this.color = color;
        this.cantidadOjos = cantidadOjos;
        this.reproduccion = reproduccion;
        this.tipoComida = tipoComida;
        this.planeticio = planeticio;
    }

    @Override
    public String toString() {
        String descripcion = "";
        descripcion += "Éste " + planeticio + " es de color " + color + ", tiene " + cantidadOjos
                + " ojos, su modalidad de reproducción es por medio de " + reproduccion
                + " y es " + tipoComida;
        return descripcion;
    }
}
