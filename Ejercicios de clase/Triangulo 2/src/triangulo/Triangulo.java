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
public class Triangulo {
   private Punto p1;
   private Punto p2;
   private Punto p3;
   private Color colorRelleno;
   private Color colorLinea;

    public Triangulo(Punto p1, Punto p2, Punto p3, Color colorRelleno, Color colorLinea) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.colorRelleno = colorRelleno;
        this.colorLinea = colorLinea;
    }

    public Punto getP1() {
        return p1;
    }

    public void setP1(Punto p1) {
        this.p1 = p1;
    }

    public Punto getP2() {
        return p2;
    }

    public void setP2(Punto p2) {
        this.p2 = p2;
    }

    public Punto getP3() {
        return p3;
    }

    public void setP3(Punto p3) {
        this.p3 = p3;
    }

    public Color getColorRelleno() {
        return colorRelleno;
    }

    public void setColorRelleno(Color colorRelleno) {
        this.colorRelleno = colorRelleno;
    }

    public Color getColorLinea() {
        return colorLinea;
    }

    public void setColorLinea(Color colorLinea) {
        this.colorLinea = colorLinea;
    }
    
    public double calcularArea(){
       double a = this.calcularDistancia(this.p1, this.p2);
       double b= this.calcularDistancia(this.p1, this.p3);
       double c =  this.calcularDistancia(this.p2, this.p3);
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
