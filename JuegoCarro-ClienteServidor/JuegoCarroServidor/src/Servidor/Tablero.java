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
    private DataOutputStream salida;
    private DataInputStream entrada;
    private DataOutputStream salida2;
    private DataInputStream entrada2;
    private int puntaje = 0;
    private int puntaje2 = 0;

    public Tablero() throws IOException {
        
        this.servidor = new ServerSocket(8000);
        this.carro = new Carro(300,500);
        this.carro2 = new Carro(300,500);
        this.monedas = new ArrayList<Moneda>();
        
        for(int i = 0; i < 25; i++){
            
            for(int j = 0; j < 25; j++){
                
                this.monedas.add(new Moneda(j*20+50,i*20+50));
            }
        }
        
        this.cliente = this.servidor.accept();
        this.cliente2 = this.servidor.accept();
        this.entrada = new DataInputStream(this.cliente.getInputStream());
        this.entrada2 = new DataInputStream(this.cliente2.getInputStream());
        this.salida = new DataOutputStream(this.cliente.getOutputStream());
        this.salida2 = new DataOutputStream(this.cliente2.getOutputStream());
        
        this.timer = new Timer(50, this);
        this.timer.start();
        
        Thread hilo = new Thread(new Hilo(cliente,carro,salida2));
        hilo.start();
        Thread hilo2 = new Thread(new Hilo(cliente2,carro2,salida));
        hilo2.start();
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
             
             if(this.monedas.isEmpty()){
                 
                 if(this.puntaje > this.puntaje2){
                     g.drawString("Gana jugador 1!", 270, 30);
                 }else if(this.puntaje == this.puntaje2){
                     g.drawString("Empate!", 270, 30);
                 }else{
                     g.drawString("Gana jugador 2!", 270, 30);
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
