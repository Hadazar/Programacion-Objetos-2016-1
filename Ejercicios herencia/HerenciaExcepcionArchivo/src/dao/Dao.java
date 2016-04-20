/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Exception.LibroException;
import data.CD;
import data.DVD;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import data.Persona;
import data.Libro;
import data.Soporte;

/**
 * @author fabian.giraldo
 * Luego va ser mejorada
 */
public class Dao {
         
    public Persona cargarPersona(Scanner archivo) {
	
	String nombre = archivo.next().trim();
        String apellido = archivo.next().trim();
        Persona persona = new Persona(nombre, apellido);
        
        return persona;
    }
        
    public Libro cargarLibro(Scanner archivo) throws LibroException{
	
	String titulo = archivo.next().trim();
        String isbn = archivo.next().trim();
        int numeroDePaginas = archivo.nextInt();
        Persona autor = cargarPersona(archivo);
        Libro libro = new Libro(isbn, numeroDePaginas, autor, titulo);
        
        return libro;
    }
    
    public CD cargarCD(Scanner archivo) throws LibroException{
	
	String titulo = archivo.next().trim();
        String genero = archivo.next().trim();
        double duracion = archivo.nextDouble();
        int cantidadMusicos = archivo.nextInt();
        ArrayList<Persona> musicos = null;
        for( int i = 0; i < cantidadMusicos; i++ ){
            musicos.add(cargarPersona(archivo));
        }
        CD cd = new CD(genero, duracion, musicos, titulo);
        
        return cd;
    }
    
    public DVD cargarDVD(Scanner archivo) throws LibroException{
	
	String titulo = archivo.next().trim();
        double duracion = archivo.nextDouble();
        int cantidadAutores = archivo.nextInt();
        Persona[] autores = new Persona[5];
        for( int i = 0; i < cantidadAutores; i++ ){
            autores[i] = cargarPersona(archivo);
        }
        int cantidadActores = archivo.nextInt();
        ArrayList<Persona> actores = null;
        for( int i = 0; i < cantidadActores; i++ ){
            actores.add(cargarPersona(archivo));
        }
        DVD dvd = new DVD(duracion, autores, actores, titulo);
        
        return dvd;
    }
    
    public Soporte leerSoporte(Scanner archivo) throws LibroException {
	String tipo = archivo.next().trim();
        Soporte soporte = null;
	if (tipo.equals("Libro")){
            soporte = cargarLibro(archivo);
        }else if(tipo.equals("CD")){
            soporte = cargarCD(archivo);
        }else if(tipo.equals("DVD")){
            soporte = cargarDVD(archivo);
        }
        
        return soporte;
    }
	
    public ArrayList<Soporte> cargarSoportes(String archivo) throws FileNotFoundException, LibroException{
  	ArrayList<Soporte> soportes = new ArrayList<Soporte>();
	Scanner leer = new Scanner(new File(archivo));
	leer.useDelimiter(",");
	while (leer.hasNext()) {
		soportes.add(leerSoporte(leer));
	}
	
	return soportes;
   }
    
}
