/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package impresion.en.pantalla;

/**
 *
 * @author HéctorAugusto
 */
public class ImpresionEnPantalla {

    public static void func1(){ 

        System.out.println("Segunda Funcion"); 

    } 

    public static void func2(){ 

        System.out.println("Tercera Funcion"); 

    } 

    /**
     * @param args the command line arguments
     */
    public static void main (String []args){ 

        System.out.println("Primera Funcion en Main"); 

        func1(); 

        func2(); 

        System.out.println("Se termina Main"); 

    } 
}
