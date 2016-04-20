/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import Exception.LibroException;
import data.Soporte;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import servicio.ServicioSoporte;

/**
 *
 * @author fabian.giraldo
 */
public class UI {
    
    private Scanner leer ;
    private ServicioSoporte servicio;
    
    
    public UI(){
      this.leer = new Scanner(System.in);
      this.servicio = new ServicioSoporte();
    }
         
    public void imprimirSoportes(ArrayList<Soporte> soportes){
        if(soportes != null){
          for(Soporte soporte: soportes){
              System.out.println(soporte);
          }
        }else{
            System.out.println("No existen soportes actualmente");
        }
   }
    
    public void menu(){
        int opcion = 0;     
        System.out.println("Bienvenido a la mediateca\n");
        System.out.println("Opciones:\n\n 1. Cargar datos.\n 2. Imprimir repertorio.");
        System.out.println("3. Buscar por título. 4. Buscar por autor");
        opcion = this.leer.nextInt();
        
        switch(opcion){
            case 1:
                System.out.println("Nombre del archivo: ");
                String rutaArchivo = leer.next();
                try {
                    this.servicio.cargarSoportes(rutaArchivo);
                } catch (FileNotFoundException ex) {
                    System.out.println("El archivo especificado no existe");
                } catch (LibroException ex) {
                    System.out.println(ex.getMessage());
                }
                break;
            case 2:
                ArrayList<Soporte> soportes = this.servicio.getSoportes();
                this.imprimirSoportes(soportes);
                break;
            case 3:
                System.out.println("Título: ");
                String titulo = leer.next();
                Soporte soporte = servicio.busquedaPorTitulo(titulo);
                System.out.println(soporte);
                break;
            case 4:
                System.out.println("Nombre del autor");
                String nombre = leer.next();
                Soporte soporteB = servicio.busquedaPorAutor(nombre);
                System.out.println(soporteB);
                break;
            default:
                System.out.println("Opcion invalida");
        }
    }
   
}
