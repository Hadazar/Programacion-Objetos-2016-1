/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carro;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author HéctorAugusto
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        JFrame ventana = new JFrame();
        JButton botonParar = new JButton("Parar");
        
        JButton botonContinuar = new JButton("Continuar");
        ventana.setSize(new Dimension(1500, 900));
        ventana.setTitle("Animación Automóvil");
        ventana.add(new CarroPanel(), BorderLayout.CENTER);
        ventana.add(botonParar, BorderLayout.SOUTH);
        ventana.add(botonContinuar, BorderLayout.NORTH);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);
    }
    
}
