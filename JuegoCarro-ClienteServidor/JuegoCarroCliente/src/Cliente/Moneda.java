/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author HéctorAugusto
 */
public class Moneda {
    
    private int x;
    private int y;
    private Image imagen;
    private int numeroImagen;
    
    public Moneda(int x, int y) {
        
        this.x = x;
        this.y = y;
        this.numeroImagen =0;
         this.imagen = cargarImagen("FullCoins.png");
    }
    
    public void dibujar(Graphics g, JPanel panel){
        
       g.setColor(Color.BLUE);
       g.drawImage(imagen, x, y, x+16, y+16, 16*this.numeroImagen, 0, 16*this.numeroImagen + 16, 16, panel);
    
    }
    
    protected Image cargarImagen(String nombreImagen) {
        
       ImageIcon img = new ImageIcon(nombreImagen);
        Image imagen = img.getImage();
         return imagen;
    }
    
    public void girar(){
        
       if(this.numeroImagen==8){
           this.numeroImagen =0;
       }
       else{
           this.numeroImagen++;
       }
    }
    
    public Rectangle siluetaColision(){
        
       return new Rectangle(x, y, 20, 20);
    }
}
