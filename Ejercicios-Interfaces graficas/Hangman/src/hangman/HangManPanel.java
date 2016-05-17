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
    
    private int x;
    private int y;
    private int angulo;
    private int variacion;
    private Timer timer;

    public HangManPanel() {
        
        this.x = 600;
        this.y = 40;
        this.angulo = 20;
        this.variacion = 1;
        this.timer = new Timer(300, this);
        this.timer.start();
    }
    
    public int[] calculoPosicion(int hipotenusa, int angulo){
        
        int[] coordenadas = new int[2];
        double py = y + hipotenusa * Math.sin(angulo);
        double px = x - hipotenusa * Math.cos(angulo);
        coordenadas[0] = (int)px;
        coordenadas[1] = (int)py;
        return coordenadas;
    }
    public void paintComponent(Graphics g){
        
        super.paintComponent(g);
        
        g.drawLine(200, 40, 200, 800);
        g.drawLine(200, 40, 600, 40);
        g.drawOval(120, 800, 160, 100);
        
        int[] coordenadas = calculoPosicion(100, this.angulo);
        g.drawLine(x, y, coordenadas[0], coordenadas[1]);
        coordenadas = calculoPosicion(150, this.angulo);
        coordenadas[0] = (int)(coordenadas[0]- 100 *(1+Math.cos(angulo)));
        coordenadas[1] = (int)(coordenadas[1]- 100 *(1-Math.sin(angulo)));
        g.drawOval(coordenadas[0], coordenadas[1], 200, 200);
        coordenadas = calculoPosicion(350, this.angulo);
        int[] coordenadas2 = calculoPosicion(650, this.angulo);
        g.drawLine(coordenadas[0], coordenadas[1], coordenadas2[0], coordenadas2[1]);
        
        g.drawLine(coordenadas[0], coordenadas[1], coordenadas[0] + 100, coordenadas[1] + 100);
        coordenadas = calculoPosicion(150, this.angulo);
        g.drawLine(x, y, coordenadas[0], coordenadas[1]);
        coordenadas = calculoPosicion(150, this.angulo);
        g.drawLine(x, y, coordenadas[0], coordenadas[1]);
        coordenadas = calculoPosicion(150, this.angulo);
        g.drawLine(x, y, coordenadas[0], coordenadas[1]);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        
        boolean avanzar = true;
        if(avanzar == true){
            this.angulo += this.variacion;
            if(this.angulo == 160){
                avanzar = false;
            }
        }else{
            this.angulo -= this.variacion;
            if(this.angulo == 20){
                avanzar = true;
            }
        }
        repaint();
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
