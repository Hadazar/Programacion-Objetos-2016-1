/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author HéctorAugusto
 */
public class Miembro extends Persona{
    
    private String direccion;
    private int prestamos;

    public Miembro(String direccion, String nombre, String apellido) {
        super(nombre, apellido);
        this.direccion = direccion;
    }
    
    public void setPrestamos(){
        prestamos++;
    }
}
