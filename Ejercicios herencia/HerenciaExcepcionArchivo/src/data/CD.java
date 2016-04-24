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
public class CD extends Soporte{
    
    private String genero;
    private double duracion;
    private ArrayList<Persona> musicos;

    public CD(String genero, double duracion, ArrayList<Persona> musicos, String titulo) {
        super(titulo);
        this.genero = genero;
        this.duracion = duracion;
        this.musicos = musicos;
    }
    
    public String toString(){
        
        String soporte = "Soporte: CD\n\n";
        String titulo = super.toString();
        String genero = "Género: " + this.genero + "\n";
        String duracion = "Duración: " + this.duracion + " min\n";
        String musicos = "Musicos:\n\n";
        for(Persona persona : this.musicos){
            musicos += persona.toString() + "\n";
        }
        
        return soporte + titulo + genero + duracion + musicos;
    }
    
    @Override
    public Persona getAutor(String nombre){
        
        Persona autor = null;
        for(Persona persona : musicos){
            if(persona.getNombre().equals(nombre)){
                autor = persona;
                break;
            }
        }
        return autor;
    }
}
