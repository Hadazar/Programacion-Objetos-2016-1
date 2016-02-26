/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numero.mayor;

/**
 *
 * @author HéctorAugusto
 */
public class NumeroMayor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        java.util.Scanner Leer = new java.util.Scanner(System.in);
        double mayor = 0;
        System.out.print("Ingrese A: ");
        double a = Leer.nextDouble();
        System.out.println();
        System.out.print("Ingrese B: ");
        double b = Leer.nextDouble();
        System.out.println();
        System.out.print("Ingrese C: ");
        double c = Leer.nextDouble();
        System.out.println();
        if(a > b){
            if(a > c){mayor = a;}
            else{mayor = c;};
        }
        else{
            if(b > c){mayor = b;}
            else{mayor = c;};
        };
        System.out.println("El mayor es " + mayor);
        Leer.close();
    }
    
}
