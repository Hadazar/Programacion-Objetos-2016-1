/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package triangulo;

/**
 *
 * @author Usuario12
 */
public class Triangulo {
    
    private  Color colorLinea;
    private  Color colorRelleno;
    private Punto[] puntos = new Punto[3];
    private double lado1 = calcularDistancia(puntos[0], puntos[1]);
    private double lado2 = calcularDistancia(puntos[1], puntos[2]);
    private double lado3 = calcularDistancia(puntos[2], puntos[0]);

    public Triangulo(Color colorLinea, Color colorRelleno, Punto[] puntos) {
        this.colorLinea = colorLinea;
        this.colorRelleno = colorRelleno;
        this.puntos = puntos;
    }
    
    
    public void dibujar(){
        
    }
    
    public double calcularDistancia(Punto punto1, Punto punto2){
        return Math.sqrt(Math.pow(punto1.getCoordenadaX() - punto2.getCoordenadaX(),2) + Math.pow(punto1.getCoordenadaY() - punto2.getCoordenadaY(),2));
    }
    public double calcularArea(){
        double semiperimetro = calcularPerimetro() / 2;
        double area = Math.sqrt(semiperimetro * (semiperimetro - lado1) * (semiperimetro - lado2) * (semiperimetro - lado3));
        return area;
    }
    
    public double calcularPerimetro(){
        return (lado1 + lado2 + lado3);
    }
    
    public double calcularAltura(){
        return 2 * calcularArea() / lado1;
    }
}
