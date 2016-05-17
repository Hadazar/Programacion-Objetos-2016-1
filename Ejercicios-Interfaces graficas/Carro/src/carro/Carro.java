/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carro;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;

/**
 *
 * @author HéctorAugusto
 */
public class Carro extends JPanel implements ActionListener, KeyListener{
    
    private int x;
    private int y;
    private int dx;

    public Carro() {
        
        this.x = 0;
        this.y = 250;
        this.dx = 5;
        setFocusable(true);
        addKeyListener(this);
    }
    
    public void paintComponent(Graphics g){
        
        super.paintComponent(g);
        
        g.setColor(new Color(0, 191, 255));
        int[] xPoints = {x + 100, x + 200, x + 300, x + 400};
        int[] yPoints = {y + 200, y + 100, y + 100, y + 200};
        g.fillPolygon(xPoints, yPoints, 4);
        g.setColor(new Color(129, 208, 230));
        g.fillRect(x, y + 200, 500, 100);
        g.setColor(Color.BLACK);
        g.drawRect(x, y + 200, 500, 100);
        g.fillOval(x + 100, y + 300, 100, 100);
        g.fillOval(x + 300, y + 300, 100, 100);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        x += dx;
        if (x == 1000){
            x = 0;
        }
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
       
        switch(e.getKeyCode()){
            case KeyEvent.VK_DOWN:
                dx -= 5;
                break;
            case KeyEvent.VK_UP:
                dx += 5;
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
        switch(e.getKeyCode()){
            case KeyEvent.VK_DOWN:
                dx -= 5;
                break;
            case KeyEvent.VK_UP:
                dx += 5;
                break;
        }
    }
}
