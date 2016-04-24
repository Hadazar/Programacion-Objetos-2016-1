/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejecución;

import UI.UI;
import java.util.Scanner;

/**
 *
 * @author HéctorAugusto
 */
public class Main {
    
    public static void main(String[] args) {
        
        UI vista = new UI();
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;
        
        while(continuar == true){
            
               vista.menu();
               System.out.println("¿Desea continuar?\n\n1. Si\n2. No\n");
               int opcion = scanner.nextInt();
               
               if(opcion != 1){
                  continuar = false;
               }
        }
    }
}
