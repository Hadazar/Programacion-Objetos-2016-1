/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import Exception.PrestamoException;
import Exception.SoporteException;
import data.Miembro;
import data.Prestamo;
import data.Soporte;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;
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
        System.out.println("Bienvenido a la mediateca\n\n");
        System.out.println("Opciones:\n\n1. Cargar datos.\n2. Imprimir repertorio.");
        System.out.println("3. Buscar por título.\n4. Buscar por autor");
        System.out.println("5. Cargar miembros.\n6. Prestamo\n7. Listar prestamos vencidos.\n\n");
        opcion = this.leer.nextInt();
        
        switch(opcion){
            case 1:
                System.out.println("Nombre del archivo: ");
                String rutaArchivo = leer.next();
                try {
                    this.servicio.cargarSoportes(rutaArchivo);
                } catch (FileNotFoundException ex) {
                    System.out.println("El archivo especificado no existe");
                } catch (SoporteException ex) {
                    System.out.println(ex.getMessage());
                }
                break;
            case 2:
                ArrayList<Soporte> soportes = this.servicio.getSoportes();
                this.imprimirSoportes(soportes);
                break;
            case 3:
                System.out.println("Título del soporte: ");
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
            case 5:
                System.out.println("Nombre del archivo:");
                String rutaArchivo2 = leer.next();
                try {
                    this.servicio.cargarMiembros(rutaArchivo2);
                } catch (FileNotFoundException ex) {
                    System.out.println("El archivo especificado no existe");
                } catch (SoporteException ex) {
                    System.out.println(ex.getMessage());
                }
                break;
            case 6:
                System.out.println("Su nombre:");
                String nombre2 = leer.next();
                Miembro miembro = servicio.busquedaMiembro(nombre2);
                System.out.println("Titulo del soporte:");
                String titulo2 = leer.next();
                Soporte soporte3 = servicio.busquedaPorTitulo(titulo2);
                System.out.println(soporte3);
                Date fechaActual = new Date();
                Prestamo prestamo = new Prestamo(titulo2, fechaActual);
                try{
                    miembro.setPrestamos(prestamo);
                }catch(PrestamoException e){
                    System.out.println(e.getMessage());
                }
            case 7:
                String prestamos = servicio.prestamosVencidos();
                System.out.println(prestamos);
            default:
                System.out.println("Opcion invalida");
        }
    }
   
}
