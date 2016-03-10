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
public class Grupo {
    
    private String nombreDelDeporte;
    private Integrante[] integrantes;

    public Grupo(String nombreDelDeporte, Integrante[] integrantes) {
        this.nombreDelDeporte = nombreDelDeporte;
        this.integrantes = integrantes;
    }

    public String getNombreDelDeporte() {
        return nombreDelDeporte;
    }

    public Integrante[] getIntegrantes() {
        return integrantes;
    }
}
