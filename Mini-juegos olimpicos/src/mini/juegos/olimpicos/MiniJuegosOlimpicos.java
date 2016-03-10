/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mini.juegos.olimpicos;

/**
 *
 * @author HéctorAugusto
 */
public class MiniJuegosOlimpicos {

    private static Delegacion[] delegaciones;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        java.util.Scanner leer = new java.util.Scanner(System.in);
        int posicion = 0;
        boolean continuar = true;
        
        while(continuar = true){
            
            System.out.println("Mini-juegos Olimpicos\n");
            System.out.println("Menu de opciones:\n");
            System.out.println("1. Ingresar una nueva delegación.");
            System.out.println("2. Consultar delegacion.");
            System.out.println("3. Cambiar la cantidad de medallas de una delegación.");
            System.out.println("4. Identificar la delegación con mas medallas.\n");

            System.out.print("Elija una opción: ");
            char opcion = leer.next().charAt(0);
            System.out.println("\n");
            
            switch(opcion){
                case '1':
                    System.out.println("Diligencie los datos\n");
                    System.out.print("Pais: ");
                    String pais = leer.next();
                    System.out.println("");
                    int[] numeroMedallas = new int[3];
                    System.out.print("Número de medallas de bronce: ");
                    numeroMedallas[0] = leer.nextInt();
                    System.out.println("");
                    System.out.print("Número de medallas de plata: ");
                    numeroMedallas[1] = leer.nextInt();
                    System.out.println("");
                    System.out.print("Número de medallas de oro: ");
                    numeroMedallas[2] = leer.nextInt();
                    System.out.println("");
                    Grupo[] grupos = new Grupo[5];
                    delegaciones[posicion] = new Delegacion(pais, numeroMedallas);
                    break;
                case '2':
                    break;
                case '3':
                    break;
                case '4':
                    break;
                default:
            }
        }
    }
    
}
