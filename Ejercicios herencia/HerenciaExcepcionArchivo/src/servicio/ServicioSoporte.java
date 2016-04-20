/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio;

import Exception.SoporteException;
import dao.Dao;
import data.Miembro;
import data.Soporte;
import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 *
 * @author fabian.giraldo
 */
public class ServicioSoporte {
    private Dao dao;
    private ArrayList<Soporte> soportes = null; //Debe ser mejorado notablemente.
    private ArrayList<Miembro> miembros = null;
    public ServicioSoporte(){
      this.dao = new Dao();
     }
    
    public void cargarSoportes(String archivo) throws FileNotFoundException, SoporteException{
       this.soportes = this.dao.cargarSoportes(archivo);
       this.validarUnicidad();
    }
    
    public ArrayList<Soporte> getSoportes(){
      return this.soportes;
    }
    
    public void cargarMiembros(String archivo) throws FileNotFoundException, SoporteException{
        this.miembros=this.dao.cargarMiembros(archivo);
    }
    
    public ArrayList<Miembro> getMiembros(){
        return this.miembros;
    }
    
   public Soporte busquedaPorTitulo(String titulo){
       
       Soporte soporteBuscado = null;
       for(Soporte soporte : soportes){
           if(soporte.getTitulo().equals(titulo)){
               soporteBuscado = soporte;
               break;
           }
       }
       
       return soporteBuscado;
   }
   
   public Soporte busquedaPorAutor(String autor){
       
       Soporte soporteBuscado = null;
       for(Soporte soporte : soportes){
           if(soporte.getAutor(autor).getNombre().equals(autor)){
               soporteBuscado = soporte;
               break;
           }
       }
       
       return soporteBuscado;
   }
   
   public Miembro busquedaMiembro(String nombre){
       
       Miembro miembroBuscado = null;
       for(Miembro miembro: miembros){
           if(miembro.getNombre().equals(nombre)){
               miembroBuscado = miembro;
               break;
           }
       }
       return miembroBuscado;
   }
   
   public void validarUnicidad(){
       
       for(Soporte soporte : soportes){
           String titulo = soporte.getTitulo();
           for(Soporte soporte2 : soportes){
               if(soporte2.getTitulo().equals(titulo)){
                   soportes.remove(soporte2);
               }
           }
       }
   }
   
   public String prestamosVencidos(){
       
       for(Miembro miembro : miembro){
           
       }
   }
}
