/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mini.juegos.olimpicos;

/**
 *
 * @author HéctorAugusto
 */
public class Delegacion {
    
    private String pais;
    private int[] numeroMedallas;
    private Grupo[] grupos;

    public Delegacion(String pais, int[] numeroMedallas, Grupo[] grupos) {
        this.pais = pais;
        this.numeroMedallas = numeroMedallas;
        this.grupos = grupos;
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
    
    public int totalMedallas(int cantidad){
        int total = 0;
        for(int medallas : numeroMedallas){
            total += medallas;
        }
        return total;
    }
    
    public boolean busquedaDeporte(String deporte){
        boolean existeDeporte = false;
        for(Grupo grupo : grupos){
            if(deporte.equals(grupo.getNombreDelDeporte())){
                existeDeporte = true; break;
            };
        }
        return existeDeporte;
    }
}
