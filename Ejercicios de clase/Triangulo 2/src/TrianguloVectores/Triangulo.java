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
public class Triangulo {
    private Punto[] p;
    private Color[] c;

    public Triangulo(Punto[] p, Color[] c) {
        this.p = p;
        this.c = c;
    }

    public Punto[] getP() {
        return p;
    }

    public void setP(Punto[] p) {
        this.p = p;
    }

    public Color[] getC() {
        return c;
    }

    public void setC(Color[] c) {
        this.c = c;
    }
    
     public double calcularArea(){
       double a = this.calcularDistancia(this.p[0], this.p[1]);
       double b= this.calcularDistancia(this.p[0], this.p[2]);
       double c =  this.calcularDistancia(this.p[1], this.p[2]);
       double p = (a+b+c)/2;
       double area=Math.sqrt(p * (p-a) * (p-b)*(p-c));
       return area;
    }
   
    private double calcularDistancia(Punto a, Punto b){
       double res =  Math.sqrt(Math.pow(a.getX() - b.getX(), 2) 
                  +  Math.pow((a.getY() - b.getY()), 2));
      return res;
    
    }
    
    
}
