/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente;

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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author HéctorAugusto
 */
public class Tablero extends JPanel implements ActionListener, KeyListener{

    private Timer timer; 
    private ArrayList<Moneda> monedas;
    private Carro carro;
    private Carro carro2;
    private Socket cliente;
    private DataInputStream entrada;
    private DataOutputStream salida;
    private int puntaje = 0;
    private int puntaje2 = 0;

    public Tablero() throws IOException {
        
        this.setFocusable(true);
        this.addKeyListener(this);
            
        this.carro = new Carro(50,500);
        this.carro2 = new Carro(500,500);
        this.monedas = new ArrayList<Moneda>();
        
        //Monedas aleatorias
        int numeroAleatorio = (int)(Math.random()*30+5);
        for(int i = 1; i <= numeroAleatorio; i++){
            
            this.monedas.add(new Moneda((int)Math.random()*500,(int)Math.random()*500));
        }
        
        this.cliente = new Socket("localhost",8000);
        this.timer = new Timer(50, this);
        this.timer.start();
        
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

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
        int movimiento=-1;
        try {
            
            int tecla = e.getKeyCode();
            if (tecla == KeyEvent.VK_SPACE) {
                movimiento=1;
            }
            if (tecla == KeyEvent.VK_LEFT) {
                movimiento=1;
            }
            if (tecla == KeyEvent.VK_RIGHT) {
               movimiento=2;
            }
            if (tecla == KeyEvent.VK_UP) {
               movimiento=3;
            }
            if (tecla == KeyEvent.VK_DOWN) {
               movimiento=4;
        }
        
         this.carro.keyPressed(e);
         this.salida.writeInt(movimiento);
         this.salida.flush();
        } catch (IOException ex) {
            Logger.getLogger(Tablero.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
        
    }
}
