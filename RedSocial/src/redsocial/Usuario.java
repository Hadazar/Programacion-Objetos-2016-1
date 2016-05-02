/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package redsocial;

import java.util.ArrayList;

/**
 *
 * @author HéctorAugusto
 */
public class Usuario extends Persona{
    
    
    private String nick;
    private String clave;
    private ArrayList<Comentario> comentarios;
    private ArrayList<Fotografia> fotos;

    public Usuario(String nick, String clave, String nombre, int edad, String correo) {
        super(nombre, edad, correo);
        this.nick = nick;
        this.clave = clave;
        this.comentarios = new ArrayList<Comentario>();
        this.fotos = new ArrayList<Fotografia>();
    }
    
    public void PublicarFoto ( Fotografia foto ){
        
        this.fotos.add(foto);
    }
    
    public void PublicarComentario ( Comentario comentario ){
        
        this.comentarios.add(comentario);
    }
    
    public String toString(){
        
        String nick = "Nick: " + this.nick + "\n";
        String clave = "Clave: " + this.clave + "\n";
        
        return super.toString() + nick + clave;
    }
}
