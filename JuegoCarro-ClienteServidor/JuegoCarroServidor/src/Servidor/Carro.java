/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;

/**
 *
 * @author HéctorAugusto
 */
public class Carro {
    
    private int x;
    private int y;
    //Referencias para colores aleatorios
    private int red;
    private int green;
    private int blue;
    private int red2;
    private int green2;
    private int blue2;
    
    public Carro(int x, int y) {
        
        this.x = x;
        this.y = y;
        this.red = (int)(Math.random()*250);
        this.green = (int)(Math.random()*250);
        this.blue = (int)(Math.random()*250);
        this.red2 = (int)(Math.random()*250);
        this.green2 = (int)(Math.random()*250);
        this.blue2 = (int)(Math.random()*250);
    }
    
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    public void dibujar(Graphics g, JPanel panel){
        
        g.setColor(new Color(red, green, blue));
        int[] xPoints = {x + 10, x + 20, x + 30, x + 40};
        int[] yPoints = {y + 20, y + 10, y + 10, y + 20};
        g.fillPolygon(xPoints, yPoints, 4);
        
        g.setColor(new Color(red2, green2, blue2));
        g.fillRect(x, y + 20, 50, 10);
        g.setColor(Color.BLACK);
        g.drawRect(x, y + 20, 50, 10);
        g.fillOval(x + 10, y + 30, 10, 10);
        g.fillOval(x + 30, y + 30, 10, 10);
   }
    
    public void keyPressed(KeyEvent e) {
        
        switch (e.getKeyCode()) {
            
            case KeyEvent.VK_DOWN: y += 10; break;
            case KeyEvent.VK_UP: y -= 10; break;
            case KeyEvent.VK_LEFT: x -= 10; break;
            case KeyEvent.VK_RIGHT: x += 10; break;
          }
    }
    
     public Rectangle siluetaColision(){
         
       return new Rectangle(x, y, 20, 20);
    }
}
