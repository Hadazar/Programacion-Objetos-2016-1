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
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.Timer;

/**
 *
 * @author HéctorAugusto
 */
public class CarroPanel extends JPanel implements ActionListener{

    private Timer timer;
    private JButton continuar;
    private JButton detener;
    private Carro carro;

    public CarroPanel() {
        
        this.carro = new Carro();
        this.timer = new Timer(10, this.carro);
        this.timer.start();
        this.continuar = new JButton("Continuar");
        this.detener = new JButton("Detener");
        this.continuar.addActionListener(this);
        this.detener.addActionListener(this);
        setLayout(new BorderLayout());
        add(this.carro, BorderLayout.CENTER);
        add(this.continuar, BorderLayout.NORTH);
        add(this.detener, BorderLayout.SOUTH);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == this.continuar){
            this.timer.start();
        }else if(e.getSource() == this.detener){
            this.timer.stop();
        }
    }
    
}
