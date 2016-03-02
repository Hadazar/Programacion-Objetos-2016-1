/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package triangulo;

/**
 *
 * @author Usuario9
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Punto p1 = new Punto(8,0);
        Punto p2 = new Punto(0,1);
        Punto p3=new Punto(1,1);
        Color cr=new Color(10,10,10);
        Color cl=new Color(255,255,255);
        Triangulo triangulo = new Triangulo(p1,p2,p3,cr,cl);
        double area =triangulo.calcularArea();
        System.out.println("Area " + area);
        
    }
    
}
