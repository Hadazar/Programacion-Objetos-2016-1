/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author HéctorAugusto
 */
public class Tablero extends JPanel implements ActionListener{
    
    private Timer timer; 
    private ArrayList<Moneda> monedas;
    private Carro carro;
    private Carro carro2;
    private ServerSocket servidor;
    private Socket cliente;
    private Socket cliente2;
    private int puntaje = 0;
    private int puntaje2 = 0;

    public Tablero() throws IOException {
        
        this.servidor = new ServerSocket(8000);
        this.carro = new Carro(50,500);
        this.carro2 = new Carro(500,500);
        this.monedas = new ArrayList<Moneda>();
        
        //Monedas aleatorias
        int numeroAleatorio = (int)(Math.random()*30+5);
        for(int i = 1; i <= numeroAleatorio; i++){
            
            this.monedas.add(new Moneda((int)Math.random()*500,(int)Math.random()*500));
        }
        
        this.cliente = this.servidor.accept();
        this.cliente2 = this.servidor.accept();
        this.timer = new Timer(50, this);
        this.timer.start();
        
        Thread hilo = new Thread(new Hilo(cliente,carro));
        hilo.start();
        Thread hilo2 = new Thread(new Hilo(cliente,carro2));
        hilo2.start();
    }
    
    public void paintComponent(Graphics g) {
        
             super.paintComponent(g);
             
             this.carro.dibujar(g,this);
             this.carro2.dibujar(g,this);
             
             for(Moneda moneda: this.monedas){
                moneda.dibujar(g,this);
             }
             
             g.drawString("Puntuacion Jugador 1: " + puntaje, 30, 30);
             g.drawString("Puntuacion Jugador 2: " + puntaje2, 30, 470);
        }
    
    public void Colision(){
        
        Rectangle siluetaCarro = this.carro.siluetaColision();
        Rectangle siluetaCarro2 = this.carro2.siluetaColision();
        ArrayList<Moneda> clone = (ArrayList<Moneda>) this.monedas.clone();
        
        for(Moneda moneda : monedas){
            
           Rectangle siluetaMoneda = moneda.siluetaColision();
           if(siluetaCarro.intersects(siluetaMoneda)){
               
               clone.remove(moneda);
               this.puntaje++;
           }
           if(siluetaCarro2.intersects(siluetaMoneda)){
               
               clone.remove(moneda);
               this.puntaje2++;
           }
           this.monedas = clone;   
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        this.Colision();
         for(Moneda moneda: this.monedas){
            moneda.girar();
            repaint();
         }
    }
}
