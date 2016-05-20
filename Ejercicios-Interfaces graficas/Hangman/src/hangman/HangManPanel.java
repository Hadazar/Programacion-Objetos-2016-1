/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangman;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Biblioteca
 */
public class HangManPanel extends JPanel implements ActionListener, KeyListener{
    
    private double x;
    private double y;
    private double angulo;
    private double variacion;
    private Timer timer;
    private boolean avanzar;
    
    public HangManPanel() {
        
        this.x = 750;
        this.y = 40;
        this.angulo = 5/6;
        this.variacion = 1;
        this.timer = new Timer(1, this);
        this.timer.start();
        this.avanzar = true;
        addKeyListener(this);
        setFocusable(true);
    }
    
    public int[] calculoPosicion(double hipotenusa, double angulo){
        
        int[] coordenadas = new int[2];
        double py = y + hipotenusa * Math.sin(angulo);
        double px = x - hipotenusa * Math.cos(angulo);
        coordenadas[0] = (int)px;
        coordenadas[1] = (int)py;
        return coordenadas;
    }
    public void paintComponent(Graphics g){
        
        super.paintComponent(g);
        
        g.drawLine(200, 40, 200, 800);//Horca
        g.drawLine(200, 40, 750, 40);//Horca
        g.drawOval(120, 800, 160, 100);//Base de la horca
        
        //soga
        int[] coordenadas = calculoPosicion(150, this.angulo);
        g.drawLine((int)x, (int)y, coordenadas[0], coordenadas[1]);
        //Cabeza
        coordenadas = calculoPosicion(150, this.angulo);
        coordenadas[0] = (int)(coordenadas[0]- 100 *(1+Math.cos(angulo)));
        coordenadas[1] = (int)(coordenadas[1]- 100 *(1-Math.sin(angulo)));
        g.drawOval(coordenadas[0], coordenadas[1], 200, 200);
        //Tronco
        coordenadas = calculoPosicion(350, this.angulo);
        int[] coordenadas2 = calculoPosicion(650, this.angulo);
        g.drawLine(coordenadas[0], coordenadas[1], coordenadas2[0], coordenadas2[1]);
        //Brazo
        coordenadas = calculoPosicion(349, this.angulo - 17.76/180);
        coordenadas2 = calculoPosicion(495.37, this.angulo - 28.41/180);
        g.drawLine(coordenadas[0], coordenadas[1], coordenadas2[0], coordenadas2[1]);
        //Brazo
        coordenadas = calculoPosicion(349, this.angulo + 17.76/180);
        coordenadas2 = calculoPosicion(495.37, this.angulo + 28.41/180);
        g.drawLine(coordenadas[0], coordenadas[1], coordenadas2[0], coordenadas2[1]);
        //Pierna
        coordenadas = calculoPosicion(650, this.angulo);
        coordenadas2 = calculoPosicion(782, this.angulo - 11.3/180);
        g.drawLine(coordenadas[0], coordenadas[1], coordenadas2[0], coordenadas2[1]);
        //Pierna
        coordenadas = calculoPosicion(650, this.angulo);
        coordenadas2 = calculoPosicion(782, this.angulo + 11.3/180);
        g.drawLine(coordenadas[0], coordenadas[1], coordenadas2[0], coordenadas2[1]);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(avanzar == true){
            this.angulo += this.variacion/180;
            if(this.angulo >= 3){
                avanzar = false;
            }
        }else{
            this.angulo -= this.variacion/180;
            if(this.angulo <= 5/6){
                avanzar = true;
            }
        }
        System.out.println(this.angulo);
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
        if(e.getKeyCode() == KeyEvent.VK_UP){
            
            this.variacion += 1;
        }
        if(e.getKeyCode() == KeyEvent.VK_DOWN){
            
            this.variacion -= 1;
            if(this.variacion < 0){
                this.variacion = 0;
            }
        }
        if(e.getKeyCode() == KeyEvent.VK_S){
            
            this.timer.stop();
        }
        if(e.getKeyCode() == KeyEvent.VK_R){
            
            this.timer.start();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
}
