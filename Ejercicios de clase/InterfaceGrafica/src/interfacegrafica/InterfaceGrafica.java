/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfacegrafica;

import java.awt.*;
import javax.swing.*;


/**
 *
 * @author Usuario12
 */
public class InterfaceGrafica {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        /*
        JOptionPane.showMessageDialog(null,"Hola, mundo");
        
        String nombre = JOptionPane.showInputDialog(null,"¿Cuál es su nombre?");
        
        int eleccion = JOptionPane.showConfirmDialog(null, "¿Le gustan las tortas "+ nombre + "?");
        
        if (eleccion == JOptionPane.NO_OPTION){
            JOptionPane.showMessageDialog(null, "¿Por qué no?");
        }else{
            JOptionPane.showMessageDialog(null, "¿Le compro una?");
        }
        */
        
        JFrame frame = new JFrame();
        frame.setLayout(new FlowLayout());
        frame.setLayout(new GridLayout(3,1));
        /*
        Image icon = ToolKit.getDefaultToolKit().getImage("icon.gif");
        frame.setIconImage(icon);
        JPanel panel = (JPanel) frame.getContentPane();
        panel.setBackground(Color.WHITE);
        */
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(300, 120));
        frame.setTitle("Una ventana");
        
        /*
        Dimension dim = ToolKit.getDefaultToolkit().getScreenSize();
        frame.setLocation(dim.width/2 - frame.getSize().width/2,
                dim.height/2 - frame.getSize().height/2);
        frame.setTitle("Una ventana");
        */
        
        
        JButton button1 = new JButton();
        button1.setText("Soy un botón");
        button1.setBackground(Color.red);
        button1.addActionListener(new MessageListener());
        frame.add(button1);
        
         JButton button2 = new JButton();
        button2.setText("Clickeame");
        button2.setBackground(Color.BLUE);
        frame.add(button2);
        
        JLabel label = new JLabel("Type your ZIP code:");
        frame.add(label);
        JTextField field = new JTextField(5);
        frame.add(field);
        frame.pack();
        
        frame.setVisible(true);
        
    }
    
}
