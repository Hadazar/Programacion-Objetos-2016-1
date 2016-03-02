/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrianguloVectores;

/**
 *
 * @author Usuario9
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Punto [] puntos= new Punto[3];
        Color[] color = new Color[2];
        puntos[0] = new Punto(0,0);
        puntos[1] = new Punto(2,0);
        puntos[2]=new Punto(0,2);
        color[0]=new Color(10,10,10);
        color[1]=new Color(255,255,255);
        
        
        Triangulo triangulo = new Triangulo(puntos,color);
        double area =triangulo.calcularArea();
        System.out.println("Area " + area);
    }
    
}
