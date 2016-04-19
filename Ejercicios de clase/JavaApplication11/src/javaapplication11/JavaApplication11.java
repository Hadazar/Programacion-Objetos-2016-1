/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication11;

import java.util.Scanner;
/**
 *
 * @author HéctorAugusto
 */
public class JavaApplication11 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner leer = new Scanner(System.in);
        
        System.out.print("Ingrese el número: ");
        double numero = leer.nextDouble();
        System.out.println("");
        double referencia = (numero - 2.1)*30 + 1.5 + 1;
        System.out.println("Refenrencia: " + referencia);
    }
    
}
