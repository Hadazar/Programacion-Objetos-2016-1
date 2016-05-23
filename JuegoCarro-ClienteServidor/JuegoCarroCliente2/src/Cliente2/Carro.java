/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente2;

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

    public Carro(int x, int y) {
        
        this.x = x;
        this.y = y;
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
       
        g.setColor(new Color(0, 191, 255));
        int[] xPoints = {x + 10, x + 20, x + 30, x + 40};
        int[] yPoints = {y + 20, y + 10, y + 10, y + 20};
        g.fillPolygon(xPoints, yPoints, 4);
        g.setColor(new Color(129, 208, 230));
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
