/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package redsocial;

/**
 *
 * @author HéctorAugusto
 */
public class Persona {
    
    private String nombre;
    private int edad;
    private String correo;

    public Persona(String nombre, int edad, String correo) {
        this.nombre = nombre;
        this.edad = edad;
        this.correo = correo;
    }
    
    public String getNombre(){
        
        return this.nombre;
    }
    
    public String toString(){
        
        String nombre = "Nombre: " + this.nombre + "\n";
        String edad = "Edad: " + this.edad + "\n";
        String correo = "Correo " + this.correo + "\n";
        
        return nombre + edad + correo;
    } 
}
