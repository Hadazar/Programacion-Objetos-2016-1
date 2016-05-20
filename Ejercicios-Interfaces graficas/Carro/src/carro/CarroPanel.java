/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carro;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.Timer;

/**
 *
 * @author HéctorAugusto
 */
public class CarroPanel extends JPanel implements MouseListener, KeyListener, FocusListener{

    private Timer timer;
    private JButton continuarDetener;
    private Carro carro;

    public CarroPanel() {
        
        this.carro = new Carro();
        this.timer = new Timer(10, this.carro);
        this.timer.start();
        this.continuarDetener = new JButton("Continuar/Detener");
        this.continuarDetener.addMouseListener(this);
        setLayout(new BorderLayout());
        add(this.carro, BorderLayout.CENTER);
        add(this.continuarDetener, BorderLayout.NORTH);
        addKeyListener(this);
        setFocusable(true);
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
        this.timer.stop();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
        this.timer.start();
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
        if(e.getKeyCode() == KeyEvent.VK_UP){
            
            this.carro.setDx(2);
        }
        if(e.getKeyCode() == KeyEvent.VK_DOWN){
            
            this.carro.setDx(-2);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
    
    public void focusLost(FocusEvent e){
        
        this.carro.setFocusable(true);
    }
    
    public void focusGained(FocusEvent e){
        
    }
}
