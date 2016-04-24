/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Exception.SoporteException;
import data.CD;
import data.DVD;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import data.Persona;
import data.Libro;
import data.Miembro;
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
    
    public Miembro cargarMiembro(Scanner archivo){
        
        Persona persona = cargarPersona(archivo);
        String direccion = archivo.next().trim();
        Miembro miembro = new Miembro(direccion, persona.getNombre(), persona.getApellido());
        
        return miembro;
    }
    
    public Libro cargarLibro(Scanner archivo) throws SoporteException{
	
	String titulo = archivo.next().trim();
        if(titulo.length() > 100){throw new SoporteException("No se aceptan soportes con titulos superiores a cien carácteres");};
        String isbn = archivo.next().trim();
        int numeroDePaginas = archivo.nextInt();
        Persona autor = cargarPersona(archivo);
        Libro libro = new Libro(isbn, numeroDePaginas, autor, titulo);
        
        //Libro debe tener mas de 10 paginas
        if(numeroDePaginas < 10){
            libro = null;
        }
        return libro;
    }
    
    public CD cargarCD(Scanner archivo) throws SoporteException{
	
	String titulo = archivo.next().trim();
        if(titulo.length() > 100){throw new SoporteException("No se aceptan soportes con titulos superiores a cien carácteres");};
        String genero = archivo.next().trim();
        double duracion = archivo.nextDouble();
        if(duracion < 10 || duracion > 200){throw new SoporteException("No se aceptan cds que duren menos de 10 minutos o mas de 200");}
        int cantidadMusicos = archivo.nextInt();
        ArrayList<Persona> musicos = new ArrayList<Persona>();
        for( int i = 0; i < cantidadMusicos; i++ ){
            musicos.add(cargarPersona(archivo));
        }
        CD cd = new CD(genero, duracion, musicos, titulo);
        
        return cd;
    }
    
    public DVD cargarDVD(Scanner archivo) throws SoporteException{
	
	String titulo = archivo.next().trim();
        if(titulo.length() > 100){throw new SoporteException("No se aceptan soportes con titulos superiores a cien carácteres");};
        double duracion = archivo.nextDouble();
        if(duracion < 20){throw new SoporteException("No se aceptan dvds que duren menos de 20 minutos");}
        int cantidadAutores = archivo.nextInt();
        if(cantidadAutores > 5){throw new SoporteException("No se aceptan dvds con mas de 5 autores");};
        Persona[] autores = new Persona[cantidadAutores];
        for( int i = 0; i < cantidadAutores; i++ ){
            autores[i] = cargarPersona(archivo);
        }
        int cantidadActores = archivo.nextInt();
        ArrayList<Persona> actores = new ArrayList<Persona>();
        for( int i = 0; i < cantidadActores; i++ ){
            actores.add(cargarPersona(archivo));
        }
        DVD dvd = new DVD(duracion, autores, actores, titulo);
        
        return dvd;
    }
    
    public Soporte leerSoporte(Scanner archivo) throws SoporteException {
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
	
    public ArrayList<Soporte> cargarSoportes(String archivo) throws FileNotFoundException, SoporteException{
        
  	ArrayList<Soporte> soportes = new ArrayList<Soporte>();
	Scanner leer = new Scanner(new File(archivo));
	leer.useDelimiter(",");
	while (leer.hasNext()) {
		soportes.add(leerSoporte(leer));
	}
	
	return soportes;
   }
    
    public ArrayList<Miembro> cargarMiembros(String archivo)throws FileNotFoundException, SoporteException{
        
        ArrayList<Miembro> miembros = new ArrayList<Miembro>();
        Scanner leer = new Scanner(new File(archivo));
        leer.useDelimiter(",");
        while(leer.hasNext()){
            miembros.add(cargarMiembro(leer));
        }
        
        return miembros;
    }
    
}
