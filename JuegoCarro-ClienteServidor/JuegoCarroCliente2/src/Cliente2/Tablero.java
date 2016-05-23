/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente2;

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
public class Tablero  extends JPanel implements ActionListener, KeyListener{
    
    private Timer timer; 
    private ArrayList<Moneda> monedas;
    private Carro carro;
    private Carro2 carro2;
    private Socket cliente;
    private DataInputStream entrada;
    private DataOutputStream salida;
    private int puntaje = 0;
    private int puntaje2 = 0;

    public Tablero() throws IOException {
        
        this.addKeyListener(this);
        this.setFocusable(true);
        
        this.carro = new Carro(50,500);
        this.carro2 = new Carro2(500,500);
        this.monedas = new ArrayList<Moneda>();
        
        //Monedas aleatorias
        int numeroAleatorio = (int)(Math.random()*30+5);
        for(int i = 1; i <= numeroAleatorio; i++){
            
            this.monedas.add(new Moneda((int)Math.random()*500,(int)Math.random()*500));
        }
        
        this.cliente=new Socket("localhost",8000);
        this.salida = new DataOutputStream(cliente.getOutputStream());
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
             g.drawString("Puntuacion Jugador 1: " + puntaje2, 30, 470);
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
        
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
    
}
