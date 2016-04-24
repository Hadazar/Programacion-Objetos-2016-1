/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;
/**
 *
 * @author fabian.giraldo
 */
public abstract class Soporte {
    
    private String titulo;

    public Soporte (String titulo){
      this.titulo = titulo;
    }
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public abstract Persona getAutor(String nombre);
    
    @Override
    public String toString() {
 
        return "Título: " + titulo + "\n";
    }
}