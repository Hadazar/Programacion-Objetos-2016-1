/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mini.juegos.olimpicos;

import java.util.HashMap;

/**
 *
 * @author HéctorAugusto
 */
public class Delegacion {
    
    private String pais;
    private int[] numeroMedallas;
    private HashMap<String, Grupo> grupos;

    public Delegacion(String pais, int[] numeroMedallas, HashMap<String, Grupo> grupos) {
        this.pais = pais;
        this.numeroMedallas = numeroMedallas;
        this.grupos = grupos;
    }

    public Grupo getGrupo(String deporte){
        return grupos.get(deporte);
    }
    
    public void setMedallas(String tipo, int cantidad){
        switch(tipo){
            case "bronce": numeroMedallas[0] = cantidad;
                break;
            case "plata": numeroMedallas[1] = cantidad;
                break;
            case "oro": numeroMedallas[2] = cantidad;
                break;    
        }
    }
    
    public int totalMedallas(){
        int total = 0;
        for(int medallas : numeroMedallas){
            total += medallas;
        }
        return total;
    }
    
    public void imprimirDatos(){
        
        System.out.println("Delegacion de " + pais + "\n");
        System.out.println("Medallas de bronce: " + numeroMedallas[0]);
        System.out.println("Medallas de plata: " + numeroMedallas[1]);
        System.out.println("Medallas de oro: " + numeroMedallas[0] + "\n");
        System.out.println("Grupos:\n");
        for(Grupo grupo : grupos.values()){
            grupo.imprimirDatos();
        }
    }
}
