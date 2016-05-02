/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import java.util.ArrayList;
import redsocial.Usuario;

/**
 *
 * @author HéctorAugusto
 */
public class RedSocial {
    
    private String nombre;
    private ArrayList<Usuario> usuarios;

    public RedSocial(String nombre) {
        this.nombre = nombre;
        this.usuarios = new ArrayList<Usuario>(); 
    }
    
    public void registrar(String nick, String clave, String nombre, int edad, String correo){
        
        usuarios.add(new Usuario(nick, clave, nombre, edad, correo));
    }
    
    public Usuario buscarUsuario(String nombre){
        
        Usuario usuarioBuscado = null;
        for(Usuario usuario : this.usuarios){
            if(usuario.getNombre().equals(nombre)){
                usuarioBuscado = usuario;
                break;
            }
        }
        return usuarioBuscado;
    }
    
    public String imprimirUsuario(String nombre){
        
        Usuario usuario = this.buscarUsuario(nombre);
    }
    public String listarComentarios(String nombre){
        
        
    }
    
    public String listarFotos(String nombre){
        
    }
    
    public String buscarComentarios(String palabra){
        
    }
}
