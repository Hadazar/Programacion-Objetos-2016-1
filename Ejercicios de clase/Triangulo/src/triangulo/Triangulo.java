/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package triangulo;

/**
 *
 * @author HéctorAugusto
 */
public class Triangulo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        java.util.Scanner Leer = new java.util.Scanner(System.in);
        System.out.println("Triángulo");
        
        System.out.println("Punto 1:");
        double[] punto1 = new double[2];
        System.out.print("coordenada X:");
        punto1[0] = Leer.nextDouble();
        System.out.print("Coordenada Y:");
        punto1[1] = Leer.nextDouble();
        System.out.println("");
         
        System.out.println("Punto 2:");
        double[] punto2 = new double[2];
        System.out.print("coordenada X:");
        punto2[0] = Leer.nextDouble();
        System.out.print("Coordenada Y:");
        punto2[1] = Leer.nextDouble();
        System.out.println("");
         
        System.out.println("Punto 1:");
        double[] punto3 = new double[2];
        System.out.print("coordenada X:");
        punto3[0] = Leer.nextDouble();
        System.out.print("Coordenada Y:");
        punto3[1] = Leer.nextDouble();
        System.out.println("");
        
        double lado1 = distanciaPuntos(punto1, punto2);
        double lado2 = distanciaPuntos(punto2, punto3);
        double lado3 = distanciaPuntos(punto3, punto2);
        double perimetro = perimetro(lado1, lado2, lado3);
        double area = area(perimetro, lado1, lado2, lado3);
        double altura = altura(area, lado1);
        
        System.out.println("Perímetro:"+perimetro);
        System.out.println("Área:"+area);
        System.out.println("Altura:"+altura);
        
    }
    
    public static double distanciaPuntos(double[] punto1, double[] punto2){
        double distancia = Math.sqrt(Math.pow(punto1[0] - punto2[0],2)+Math.pow(punto1[1] - punto2[1], 2));
        return distancia;
    }
    
    public static double perimetro(double lado1, double lado2, double lado3){
        double perimetro = lado1 + lado2 + lado3;
        return perimetro;
    }
    
    public static double area(double perimetro, double lado1, double lado2, double lado3){
        double semiperimetro = perimetro / 2;
        double area = Math.sqrt(semiperimetro * (semiperimetro - lado1) * (semiperimetro - lado2) * (semiperimetro - lado3));
        return area;     
    }
    
    public static double altura(double area, double lado){
        double altura = 2 * area / lado;
        return altura;
    }
    
}
