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
public class Fotografia {
    
    private String nombre;
    private String descripcion;
    private ArrayList<Marco> etiquetas;

    public Fotografia(String nombre, String descripcion, Persona[] personas, Double[] coordenadas) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        int posicion = 1;
        this.etiquetas = new ArrayList<Marco>();
        for(Persona persona : personas){
            Marco marco = new Marco(coordenadas[posicion], coordenadas[posicion+1],persona);
            posicion += 2;
            this.etiquetas.add(marco);
        }
    }
    
}
