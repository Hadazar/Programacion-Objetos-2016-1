/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package redsocial;

import java.util.Date;

/**
 *
 * @author HéctorAugusto
 */
public class Comentario {
    
    private String texto;
    private Date fechaCreacion;

    public Comentario(String texto, Date fechaCreacion) {
        this.texto = texto;
        this.fechaCreacion = fechaCreacion;
    }
    
}
