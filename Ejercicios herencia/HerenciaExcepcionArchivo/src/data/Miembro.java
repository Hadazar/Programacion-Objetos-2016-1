/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import Exception.PrestamoException;

/**
 *
 * @author HéctorAugusto
 */
public class Miembro extends Persona{
    
    private String direccion;
    private Prestamo[] prestamos;
    private int numeroPrestamos;

    public Miembro(String direccion, String nombre, String apellido) {
        super(nombre, apellido);
        this.direccion = direccion;
        this.prestamos = new Prestamo[3];
        this.numeroPrestamos = 0;
    }
    
    public void setPrestamos(Prestamo prestamo) throws PrestamoException{
        
        if(numeroPrestamos == 3){
            throw new PrestamoException("No se permiten mas prestamos");
        }
        prestamos[numeroPrestamos] = prestamo;
        this.numeroPrestamos++;
    }
}
