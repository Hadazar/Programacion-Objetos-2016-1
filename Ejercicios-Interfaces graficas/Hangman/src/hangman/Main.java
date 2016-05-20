/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangman;

import java.awt.Dimension;
import javax.swing.JFrame;

/**
 *
 * @author Biblioteca
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        JFrame ventana = new JFrame();
        ventana.setTitle("Animacion HangMan");
        ventana.setSize(new Dimension(1500, 900));
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.add(new HangManPanel());
        ventana.setVisible(true);
    }
    
}
