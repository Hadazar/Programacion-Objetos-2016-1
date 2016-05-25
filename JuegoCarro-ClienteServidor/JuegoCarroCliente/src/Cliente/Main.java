/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente;

import java.awt.Dimension;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JFrame;

/**
 *
 * @author HéctorAugusto
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
        JFrame ventana = new JFrame();
        ventana.setTitle("Juego de carros (cliente) : Jugador 1");
        ventana.setSize(new Dimension(600,600));
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.add(new Tablero());
        ventana.setVisible(true);
    }
    
}
