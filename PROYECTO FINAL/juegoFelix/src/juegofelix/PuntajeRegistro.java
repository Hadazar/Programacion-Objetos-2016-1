/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package juegofelix;

import java.io.*;
import java.util.Date;

/**
 *
 * @author oskarauxiliar
 */
public class PuntajeRegistro {

    File archivo = null;
    FileReader fr = null;
    BufferedReader br = null;
    FileWriter fichero = null;
    PrintWriter pw = null;

    public void escrituraArchivo(String pAImprimir) {

        try {
            fichero = new FileWriter("C:\\FelixVsSonic/puntaje.txt", true);
            pw = new PrintWriter(fichero);
            pw.println(pAImprimir + "  - " + new Date());
        } catch (Exception e) {
            System.err.println("Error al escribir puntaje " + e.getMessage());
        } finally {
            try {
                if (null != fichero) {
                    fichero.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

    }
}
