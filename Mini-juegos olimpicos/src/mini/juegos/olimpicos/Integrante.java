/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mini.juegos.olimpicos;

/**
 *
 * @author HéctorAugusto
 */
public class Integrante {
    
    private String nombre;
    private String apellido;

    public Integrante(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }
    
    public void imprimirDatos(){
        System.out.println("Nombre: " + nombre);
        System.out.println("Apellido: " + apellido + "\n");
    }
}
