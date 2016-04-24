/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.ArrayList;

/**
 *
 * @author HéctorAugusto
 */
public class DVD extends Soporte{
    
    private double duracion;
    private Persona[] autores;
    private ArrayList<Persona> actores;

    public DVD(double duracion, Persona[] autores, ArrayList<Persona> actores, String titulo) {
        super(titulo);
        this.duracion = duracion;
        this.autores = autores;
        this.actores = actores;
    }
    
    public String toString(){
        
        String soporte = "Soporte: DVD\n\n";
        String titulo = super.toString();
        String duracion = "Duración: " + this.duracion + " min\n";
        String autores = "Autores:\n\n";
        for(Persona persona : this.autores){
            autores += persona.toString() + "\n";
        }
        String actores = "Actores:\n\n";
        for(Persona persona : this.actores){
            actores += persona.toString() + "\n";
        }
        
        return soporte + titulo + duracion + autores + actores;
    }
    
    @Override
    public Persona getAutor(String nombre){
        
        Persona autor = null;
        for(Persona persona : autores){
            if(persona.getNombre().equals(nombre)){
                autor = persona;
                break;
            }
        }
        return autor;
    }
}
