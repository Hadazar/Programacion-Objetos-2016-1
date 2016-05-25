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
            
        this.carro = new Carro(300,500);
        this.carro2 = new Carro(300,500);
        this.monedas = new ArrayList<Moneda>();
        
        this.monedas.add(new Moneda(-1000,-1000));
        for(int i = 0; i < 25; i++){
            
            for(int j = 0; j < 25; j++){
                
                this.monedas.add(new Moneda(j*20+50,i*20+50));
            }
        }
        
        this.cliente = new Socket("localhost",8000);
        this.entrada = new DataInputStream(this.cliente.getInputStream());
        this.salida = new DataOutputStream(this.cliente.getOutputStream());
        Thread hilo = new Thread(new Hilo(entrada,carro2));
        hilo.start();
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
             
             g.drawString("Puntuacion Jugador 1: " + this.puntaje, 30, 30);
             g.drawString("Puntuacion Jugador 2: " + this.puntaje2, 420, 30);
             
             if(this.monedas.size() == 1){
                 
                 if(this.puntaje > this.puntaje2){
                     g.drawString("Gana jugador 1!", 270, 300);
                 }else if(this.puntaje == this.puntaje2){
                     g.drawString("Empate!", 270, 300);
                 }else{
                     g.drawString("Gana jugador 2!", 270, 300);
                 }
             }
        }
    
    public void Colision(){
        
        Rectangle siluetaCarro = this.carro.siluetaColision();
        Rectangle siluetaCarro2 = this.carro2.siluetaColision();
        ArrayList<Moneda> clone = (ArrayList<Moneda>) this.monedas.clone();
        
        for(Moneda moneda : monedas){
             
           Rectangle siluetaMoneda = moneda.siluetaColision();
           if(siluetaCarro.intersects(siluetaMoneda)){
               
               clone.remove(moneda);
               this.puntaje2++;
               
           }
           if(siluetaCarro2.intersects(siluetaMoneda)){
               
               clone.remove(moneda);
               this.puntaje++;
               
           }
           this.monedas = clone;   
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        this.Colision();
        for(Moneda moneda: this.monedas){
           if(this.monedas.isEmpty() == false){
            moneda.girar();
           }
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
