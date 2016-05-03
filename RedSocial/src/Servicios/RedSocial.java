/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import java.util.ArrayList;
import redsocial.Comentario;
import redsocial.Fotografia;
import redsocial.Marco;
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
        return usuario.toString();
    }
    public String listarComentarios(String nombre){
        
        Usuario usuario = this.buscarUsuario(nombre);
        String listaComentarios = "Comentarios del usuario " + nombre + ":\n\n";
        ArrayList<Comentario> comentarios = usuario.getComentarios();
        for(Comentario comentario : comentarios){
            listaComentarios += comentario.toString() + "\n";
        }
        return listaComentarios;
    }
    
    public String listarFotos(String nombre){
        
        String listaFotos = "Fotos en las que se encuentra " + nombre + ":\n\n";
        
        for(Usuario usuario : this.usuarios){ 
            
            ArrayList<Fotografia> fotos = usuario.getFotos();
            for(Fotografia foto : fotos){
                ArrayList<Marco> marcos = foto.getEtiquetas();
                for(Marco marco : marcos){
                    if(marco.getPersona().getNombre().equals(nombre)){
                      listaFotos += foto.toString() + "\n";
                      break;
                    }
                }
            }
            listaFotos += "\n";
        }
        return listaFotos;
    }
    
    public String buscarComentarios(String palabraBuscada){
        
        String comentariosConPalabra = "Comentarios con la palabra " + palabraBuscada + " :\n\n";
        
        for(Usuario usuario : this.usuarios){
            ArrayList<Comentario> comentarios = usuario.getComentarios();
            for(Comentario comentario : comentarios){
                ArrayList<String> texto = this.convertirTexto(comentario.getTexto());
                for(String palabra : texto){
                    if(palabra.equals(palabraBuscada)){
                        comentariosConPalabra += comentario.toString();
                        break;
                    }
                }
            }
        }
        return comentariosConPalabra;
    }
    
    public ArrayList<String> convertirTexto(String texto){
        
        ArrayList<String> arreglo = new ArrayList<String>();
        boolean hayPalabras = true;
        while(hayPalabras == true){
            
            int posicion = 0;
            String palabra = "";
            boolean hayLetras = true;
            while (hayLetras == true){
                
                char letra = texto.charAt(posicion);
                if(letra == ' '){posicion ++; break;};
                palabra += texto.charAt(posicion);
                posicion ++;
            }
            if(palabra == null){break;};
            arreglo.add(palabra);
        }
        return arreglo;
    }
}
