/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mini.juegos.olimpicos;


import java.util.Scanner;
import java.util.*;
/**
 *
 * @author HéctorAugusto
 */
public class MiniJuegosOlimpicos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        
        ArrayList<Scanner> lectura= new ArrayList<Scanner>();
        Delegacion[] delegaciones = new Delegacion[10];
        int posicion = 0;
        boolean continuar = true;
        
        while(continuar = true){
            
            lectura.add(new Scanner(System.in));
            lectura.add(new Scanner(System.in));
            
            System.out.println("Mini-juegos Olimpicos\n");
            System.out.println("Menu de opciones:\n");
            System.out.println("1. Ingresar una nueva delegación.");
            System.out.println("2. Consultar delegacion.");
            System.out.println("3. Cambiar la cantidad de medallas de una delegación.");
            System.out.println("4. Identificar la delegación con mas medallas.\n");

            System.out.print("Elija una opción: ");
            char opcion = lectura.get(0).next().charAt(0);
            System.out.println("\n");
            
            switch(opcion){
                case '1':
                    if(posicion == 9){System.out.println("Los cupos de incripcion están llenos\n");break;}
                    System.out.println("Diligencie los datos\n");
                    System.out.print("Pais: ");
                    String pais = lectura.get(1).next();
                    System.out.println("");
                    int[] numeroMedallas = new int[3];
                    System.out.print("Número de medallas de bronce: ");
                    numeroMedallas[0] = lectura.get(0).nextInt();
                    System.out.println("");
                    System.out.print("Número de medallas de plata: ");
                    numeroMedallas[1] = lectura.get(1).nextInt();
                    System.out.println("");
                    System.out.print("Número de medallas de oro: ");
                    numeroMedallas[2] = lectura.get(0).nextInt();
                    System.out.println("\n");
                    Grupo[] grupos = new Grupo[5];
                    char numeroGrupo = '1';
                    for(int i = 0; i < 5; i++){
                        System.out.println("Grupo " + numeroGrupo + "\n");
                        numeroGrupo++;
                        System.out.print("Deporte: ");
                        String deporte = lectura.get(1).next();
                        System.out.println("");
                        System.out.print("Numero de integrantes: ");
                        int numeroIntegrantes = lectura.get(0).nextInt();
                        System.out.println("");
                        while((2 > numeroIntegrantes)||(numeroIntegrantes  > 10)){
                            numeroIntegrantes = lectura.get(1).nextInt();
                        }
                        Integrante[] integrantes = new Integrante[numeroIntegrantes];
                        char numeroIntegrante = '1';
                        for(int j = 0; j < numeroIntegrantes; j++){
                            System.out.println("Integrante " + numeroIntegrante + ":\n");
                            numeroIntegrante++;
                            System.out.print("Nombre: ");
                            String nombre = lectura.get(0).next();
                            System.out.println("");
                            System.out.print("Apellido: ");
                            String apellido = lectura.get(1).next();
                            System.out.println("\n");
                            integrantes[j] = new Integrante(nombre, apellido);
                        }
                        grupos[i] = new Grupo(deporte, integrantes);
                    }
                    delegaciones[posicion] = new Delegacion(pais, numeroMedallas, grupos);
                    break;
                case '2':
                    System.out.print("Deporte: ");
                    String deporte = lectura.get(0).next();
                    System.out.println("");
                    int casilla = 0;
                    System.out.println("Delegaciones con grupo de ese deporte:\n");
                    while(delegaciones[casilla] != null && casilla < 10){
                        if(delegaciones[casilla].busquedaDeporte(deporte)[0] == 1){
                            System.out.println(delegaciones[casilla].getPais() + "\n");
                            delegaciones[casilla].getGrupo(delegaciones[casilla].busquedaDeporte(deporte)[1]).imprimirDatos();
                        };
                        casilla++;
                    };
                    break;
                case '3':
                    System.out.print("Pais de la delegacion: ");
                    String paisDelegacion = lectura.get(1).next();
                    int lugar = 0;
                    while(lugar < 10){
                        if(paisDelegacion.equals(delegaciones[lugar].getPais())){
                            break;
                        }
                        lugar++;
                    }
                    System.out.print("Tipo de medalla: ");
                    String medalla = lectura.get(0).next();
                    System.out.println("");
                    System.out.print("Numero de medallas: ");
                    int cantidadMedallas = lectura.get(1).nextInt();
                    System.out.println("");
                    delegaciones[lugar].setMedallas(medalla, cantidadMedallas);
                    break;
                case '4':
                    int ubicacion = 0;
                    int totalMedallas = 0;
                    while((delegaciones[ubicacion] != null) && ubicacion < 10){
                        if(delegaciones[ubicacion].totalMedallas() > totalMedallas){
                            totalMedallas += delegaciones[ubicacion].totalMedallas();
                        }
                        ubicacion++;
                    }
                    ubicacion = 0;
                    while(ubicacion < 10){
                        if(delegaciones[ubicacion].totalMedallas() == totalMedallas){
                            break;
                        }
                        ubicacion++;
                    }
                    System.out.println("Delegacion con mas medallas:\n");
                    delegaciones[ubicacion].imprimirDatos();
                    break;
                default:
            }
            lectura.clear();
        }
    }
    
}
