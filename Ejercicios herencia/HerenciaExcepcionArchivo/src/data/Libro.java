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
public class Libro extends Soporte{
    
    private String isbn;
    private int numeroDePaginas;
    private Persona autor;

    public Libro(String isbn, int numeroDePaginas, Persona autor, String titulo) {
        super(titulo);
        this.isbn = isbn;
        this.numeroDePaginas = numeroDePaginas;
        this.autor = autor;
    }
    
    @Override
    public Persona getAutor(String nombre){
        
        return autor;
    }

    @Override
    public String toString(){
        
        String soporte = "Soporte: Libro\n\n";
        String titulo = super.toString();
        String numeroDePaginas = "Número de páginas: " + this.numeroDePaginas + "\n";
        String autor = "Autor: \n\n" + this.autor + "\n";
        
        return soporte + titulo + numeroDePaginas + autor;
    }
}
