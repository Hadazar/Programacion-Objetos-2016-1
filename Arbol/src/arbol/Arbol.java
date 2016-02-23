/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbol;

/**
 *
 * @author HéctorAugusto
 */
public class Arbol {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        double cuenta_as = 1;
        double contador = 1;
        double blan = 1;
        double num = 5;
        String ast = "*";
        String esp = " ";
        System.out.println("");
        while(contador <= num){
            blan = num - contador;
        while(blan > 0){
            System.out.print(esp);
            blan--;
        }
        cuenta_as = 1;
        while(cuenta_as < (2 * contador)){
            System.out.print(ast);
            cuenta_as++;
        }
        contador++;
        System.out.println("");
        }

    }
 /**kjkjhkjk */
}
